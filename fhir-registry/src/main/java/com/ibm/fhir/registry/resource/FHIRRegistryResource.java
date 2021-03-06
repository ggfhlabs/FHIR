/*
 * (C) Copyright IBM Corp. 2019, 2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.registry.resource;

import static com.ibm.fhir.registry.util.FHIRRegistryUtil.loadResource;

import java.util.Objects;

import com.ibm.fhir.model.resource.Resource;

/**
 * A registry entry that can load a definitional resource (e.g. StructureDefinition) given a url, version and name
 */
public class FHIRRegistryResource implements Comparable<FHIRRegistryResource> {    
    private final Class<?> resourceType;
    private final String id;
    private final String url;
    private final Version version;
    private final String kind;
    private final String type;
    private final String path;
    
    private volatile Resource resource;
    
    public FHIRRegistryResource(
            Class<?> resourceType, 
            String id, 
            String url, 
            Version version, 
            String kind, 
            String type, 
            String path) {
        this.resourceType = Objects.requireNonNull(resourceType);
        this.id = id;
        this.url = Objects.requireNonNull(url);
        this.version = Objects.requireNonNull(version);
        this.kind = kind;
        this.type = type;
        this.path = Objects.requireNonNull(path);
    }
    
    public Class<?> getResourceType() {
        return resourceType;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Version getVersion() {
        return version;
    }

    public String getKind() {
        return kind;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    /**
     * Get the resource associated with this url, version and name.
     * 
     * @return
     *     the resource
     */
    public Resource getResource() {
        Resource resource = this.resource;
        if (resource == null) {
            synchronized (this) {
                resource = this.resource;
                if (resource == null) {
                    resource = loadResource(path);
                    this.resource = resource;
                }
            }
        }
        return resource;
    }
    
    /**
     * Unload the resource by setting it to null, thus making it available for 
     * garbage collection.
     */
    public void unload() {
        Resource resource = this.resource;
        if (resource != null) {
            synchronized (this) {
                resource = this.resource;
                if (resource != null) {
                    this.resource = null;
                }
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FHIRRegistryResource other = (FHIRRegistryResource) obj;
        return Objects.equals(url, other.url) && Objects.equals(version, other.version);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(url, version);
    }
    
    @Override
    public int compareTo(FHIRRegistryResource other) {
        return this.version.compareTo(other.version);
    }

    /**
     * Represents a version that can either be lexical or follow the Semantic Versioning format
     */
    public static class Version implements Comparable<Version> {
        public enum CompareMode { SEMVER, LEXICAL };
        
        private final String version;
        private final Integer major;
        private final Integer minor;
        private final Integer patch;
        private final CompareMode mode;
        
        private Version(String version) {
            this.version = version;
            major = minor = patch = null;
            mode = CompareMode.LEXICAL;
        }
        
        private Version(String version, Integer major, Integer minor, Integer patch) {
            this.version = version;
            this.major = major;
            this.minor = minor;
            this.patch = patch;
            this.mode = CompareMode.SEMVER;
        }
        
        public int major() {
            return major;
        }
        
        public int minor() {
            return minor;
        }
        
        public int patch() {
            return patch;
        }
        
        public static Version from(String version) {
            String[] tokens = version.split("\\.");
            if (tokens.length < 1 || tokens.length > 3) {
                return new Version(version);
            }
            try {
                Integer major = Integer.parseInt(tokens[0]);
                Integer minor = (tokens.length >= 2) ? Integer.parseInt(tokens[1]) : 0;
                Integer patch = (tokens.length == 3) ? Integer.parseInt(tokens[2]) : 0;
                return new Version(version, major, minor, patch);
            } catch (Exception e) {
                return new Version(version);
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Version other = (Version) obj;
            if (CompareMode.LEXICAL.equals(mode) || CompareMode.LEXICAL.equals(other.mode)) {
                return Objects.equals(version, other.version);
            } else {
                return Objects.equals(major, other.major) && Objects.equals(minor, other.minor) && Objects.equals(patch, other.patch);
            }
        }
        
        @Override
        public int hashCode() {
            if (CompareMode.LEXICAL.equals(mode)) {
                return Objects.hash(version);
            } else {
                return Objects.hash(major, minor, patch);
            }
        }
        
        @Override
        public String toString() {
            return version;   
        }

        @Override
        public int compareTo(Version version) {
            if (CompareMode.LEXICAL.equals(mode) || CompareMode.LEXICAL.equals(version.mode)) {
                return this.version.compareTo(version.version);
            } else {
                int result = major.compareTo(version.major);
                if (result == 0) {
                    result = minor.compareTo(version.minor);
                    if (result == 0) {
                        return patch.compareTo(version.patch);
                    }
                    return result;
                }
                return result;
            }
        }
    }
}