/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import com.ibm.watsonhealth.fhir.model.type.NameUse;
import com.ibm.watsonhealth.fhir.model.visitor.Visitor;

/**
 * <p>
 * A human's name with the ability to identify parts and usage.
 * </p>
 */
@Generated("com.ibm.watsonhealth.fhir.tools.CodeGenerator")
public class HumanName extends Element {
    private final NameUse use;
    private final String text;
    private final String family;
    private final List<String> given;
    private final List<String> prefix;
    private final List<String> suffix;
    private final Period period;

    private HumanName(Builder builder) {
        super(builder);
        use = builder.use;
        text = builder.text;
        family = builder.family;
        given = Collections.unmodifiableList(builder.given);
        prefix = Collections.unmodifiableList(builder.prefix);
        suffix = Collections.unmodifiableList(builder.suffix);
        period = builder.period;
    }

    /**
     * <p>
     * Identifies the purpose for this name.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link NameUse}.
     */
    public NameUse getUse() {
        return use;
    }

    /**
     * <p>
     * Specifies the entire name as it should be displayed e.g. on an application UI. This may be provided instead of or as 
     * well as the specific parts.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getText() {
        return text;
    }

    /**
     * <p>
     * The part of a name that links to the genealogy. In some cultures (e.g. Eritrea) the family name of a son is the first 
     * name of his father.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getFamily() {
        return family;
    }

    /**
     * <p>
     * Given name.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link String}.
     */
    public List<String> getGiven() {
        return given;
    }

    /**
     * <p>
     * Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that 
     * appears at the start of the name.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link String}.
     */
    public List<String> getPrefix() {
        return prefix;
    }

    /**
     * <p>
     * Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that 
     * appears at the end of the name.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link String}.
     */
    public List<String> getSuffix() {
        return suffix;
    }

    /**
     * <p>
     * Indicates the period of time when this name was valid for the named person.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Period}.
     */
    public Period getPeriod() {
        return period;
    }

    @Override
    public void accept(java.lang.String elementName, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, this);
            if (visitor.visit(elementName, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(extension, "extension", visitor, Extension.class);
                accept(use, "use", visitor);
                accept(text, "text", visitor);
                accept(family, "family", visitor);
                accept(given, "given", visitor, String.class);
                accept(prefix, "prefix", visitor, String.class);
                accept(suffix, "suffix", visitor, String.class);
                accept(period, "period", visitor);
            }
            visitor.visitEnd(elementName, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.id = id;
        builder.extension.addAll(extension);
        builder.use = use;
        builder.text = text;
        builder.family = family;
        builder.given.addAll(given);
        builder.prefix.addAll(prefix);
        builder.suffix.addAll(suffix);
        builder.period = period;
        return builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Element.Builder {
        // optional
        private NameUse use;
        private String text;
        private String family;
        private List<String> given = new ArrayList<>();
        private List<String> prefix = new ArrayList<>();
        private List<String> suffix = new ArrayList<>();
        private Period period;

        private Builder() {
            super();
        }

        /**
         * <p>
         * Unique id for the element within a resource (for internal references). This may be any string value that does not 
         * contain spaces.
         * </p>
         * 
         * @param id
         *     Unique id for inter-element referencing
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder id(java.lang.String id) {
            return (Builder) super.id(id);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the element. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the element. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * Identifies the purpose for this name.
         * </p>
         * 
         * @param use
         *     usual | official | temp | nickname | anonymous | old | maiden
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder use(NameUse use) {
            this.use = use;
            return this;
        }

        /**
         * <p>
         * Specifies the entire name as it should be displayed e.g. on an application UI. This may be provided instead of or as 
         * well as the specific parts.
         * </p>
         * 
         * @param text
         *     Text representation of the full name
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * <p>
         * The part of a name that links to the genealogy. In some cultures (e.g. Eritrea) the family name of a son is the first 
         * name of his father.
         * </p>
         * 
         * @param family
         *     Family name (often called 'Surname')
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder family(String family) {
            this.family = family;
            return this;
        }

        /**
         * <p>
         * Given name.
         * </p>
         * 
         * @param given
         *     Given names (not always 'first'). Includes middle names
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder given(String... given) {
            for (String value : given) {
                this.given.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Given name.
         * </p>
         * 
         * @param given
         *     Given names (not always 'first'). Includes middle names
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder given(Collection<String> given) {
            this.given.addAll(given);
            return this;
        }

        /**
         * <p>
         * Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that 
         * appears at the start of the name.
         * </p>
         * 
         * @param prefix
         *     Parts that come before the name
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder prefix(String... prefix) {
            for (String value : prefix) {
                this.prefix.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that 
         * appears at the start of the name.
         * </p>
         * 
         * @param prefix
         *     Parts that come before the name
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder prefix(Collection<String> prefix) {
            this.prefix.addAll(prefix);
            return this;
        }

        /**
         * <p>
         * Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that 
         * appears at the end of the name.
         * </p>
         * 
         * @param suffix
         *     Parts that come after the name
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder suffix(String... suffix) {
            for (String value : suffix) {
                this.suffix.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that 
         * appears at the end of the name.
         * </p>
         * 
         * @param suffix
         *     Parts that come after the name
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder suffix(Collection<String> suffix) {
            this.suffix.addAll(suffix);
            return this;
        }

        /**
         * <p>
         * Indicates the period of time when this name was valid for the named person.
         * </p>
         * 
         * @param period
         *     Time period when name was/is in use
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder period(Period period) {
            this.period = period;
            return this;
        }

        @Override
        public HumanName build() {
            return new HumanName(this);
        }
    }
}