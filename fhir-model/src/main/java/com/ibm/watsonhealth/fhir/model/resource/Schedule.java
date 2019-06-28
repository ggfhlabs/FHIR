/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import com.ibm.watsonhealth.fhir.model.type.Boolean;
import com.ibm.watsonhealth.fhir.model.type.Code;
import com.ibm.watsonhealth.fhir.model.type.CodeableConcept;
import com.ibm.watsonhealth.fhir.model.type.Extension;
import com.ibm.watsonhealth.fhir.model.type.Id;
import com.ibm.watsonhealth.fhir.model.type.Identifier;
import com.ibm.watsonhealth.fhir.model.type.Meta;
import com.ibm.watsonhealth.fhir.model.type.Narrative;
import com.ibm.watsonhealth.fhir.model.type.Period;
import com.ibm.watsonhealth.fhir.model.type.Reference;
import com.ibm.watsonhealth.fhir.model.type.String;
import com.ibm.watsonhealth.fhir.model.type.Uri;
import com.ibm.watsonhealth.fhir.model.util.ValidationSupport;
import com.ibm.watsonhealth.fhir.model.visitor.Visitor;

/**
 * <p>
 * A container for slots of time that may be available for booking appointments.
 * </p>
 */
@Generated("com.ibm.watsonhealth.fhir.tools.CodeGenerator")
public class Schedule extends DomainResource {
    private final List<Identifier> identifier;
    private final Boolean active;
    private final List<CodeableConcept> serviceCategory;
    private final List<CodeableConcept> serviceType;
    private final List<CodeableConcept> specialty;
    private final List<Reference> actor;
    private final Period planningHorizon;
    private final String comment;

    private Schedule(Builder builder) {
        super(builder);
        identifier = Collections.unmodifiableList(builder.identifier);
        active = builder.active;
        serviceCategory = Collections.unmodifiableList(builder.serviceCategory);
        serviceType = Collections.unmodifiableList(builder.serviceType);
        specialty = Collections.unmodifiableList(builder.specialty);
        actor = Collections.unmodifiableList(ValidationSupport.requireNonEmpty(builder.actor, "actor"));
        planningHorizon = builder.planningHorizon;
        comment = builder.comment;
    }

    /**
     * <p>
     * External Ids for this item.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Identifier}.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * <p>
     * Whether this schedule record is in active use or should not be used (such as was entered in error).
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Boolean}.
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * <p>
     * A broad categorization of the service that is to be performed during this appointment.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link CodeableConcept}.
     */
    public List<CodeableConcept> getServiceCategory() {
        return serviceCategory;
    }

    /**
     * <p>
     * The specific service that is to be performed during this appointment.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link CodeableConcept}.
     */
    public List<CodeableConcept> getServiceType() {
        return serviceType;
    }

    /**
     * <p>
     * The specialty of a practitioner that would be required to perform the service requested in this appointment.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link CodeableConcept}.
     */
    public List<CodeableConcept> getSpecialty() {
        return specialty;
    }

    /**
     * <p>
     * Slots that reference this schedule resource provide the availability details to these referenced resource(s).
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Reference}.
     */
    public List<Reference> getActor() {
        return actor;
    }

    /**
     * <p>
     * The period of time that the slots that reference this Schedule resource cover (even if none exist). These cover the 
     * amount of time that an organization's planning horizon; the interval for which they are currently accepting 
     * appointments. This does not define a "template" for planning outside these dates.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Period}.
     */
    public Period getPlanningHorizon() {
        return planningHorizon;
    }

    /**
     * <p>
     * Comments on the availability to describe any extended information. Such as custom constraints on the slots that may be 
     * associated.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getComment() {
        return comment;
    }

    @Override
    public void accept(java.lang.String elementName, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, this);
            if (visitor.visit(elementName, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(meta, "meta", visitor);
                accept(implicitRules, "implicitRules", visitor);
                accept(language, "language", visitor);
                accept(text, "text", visitor);
                accept(contained, "contained", visitor, Resource.class);
                accept(extension, "extension", visitor, Extension.class);
                accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                accept(identifier, "identifier", visitor, Identifier.class);
                accept(active, "active", visitor);
                accept(serviceCategory, "serviceCategory", visitor, CodeableConcept.class);
                accept(serviceType, "serviceType", visitor, CodeableConcept.class);
                accept(specialty, "specialty", visitor, CodeableConcept.class);
                accept(actor, "actor", visitor, Reference.class);
                accept(planningHorizon, "planningHorizon", visitor);
                accept(comment, "comment", visitor);
            }
            visitor.visitEnd(elementName, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public Builder toBuilder() {
        Builder builder = new Builder(actor);
        builder.id = id;
        builder.meta = meta;
        builder.implicitRules = implicitRules;
        builder.language = language;
        builder.text = text;
        builder.contained.addAll(contained);
        builder.extension.addAll(extension);
        builder.modifierExtension.addAll(modifierExtension);
        builder.identifier.addAll(identifier);
        builder.active = active;
        builder.serviceCategory.addAll(serviceCategory);
        builder.serviceType.addAll(serviceType);
        builder.specialty.addAll(specialty);
        builder.planningHorizon = planningHorizon;
        builder.comment = comment;
        return builder;
    }

    public static Builder builder(List<Reference> actor) {
        return new Builder(actor);
    }

    public static class Builder extends DomainResource.Builder {
        // required
        private final List<Reference> actor;

        // optional
        private List<Identifier> identifier = new ArrayList<>();
        private Boolean active;
        private List<CodeableConcept> serviceCategory = new ArrayList<>();
        private List<CodeableConcept> serviceType = new ArrayList<>();
        private List<CodeableConcept> specialty = new ArrayList<>();
        private Period planningHorizon;
        private String comment;

        private Builder(List<Reference> actor) {
            super();
            this.actor = actor;
        }

        /**
         * <p>
         * The logical id of the resource, as used in the URL for the resource. Once assigned, this value never changes.
         * </p>
         * 
         * @param id
         *     Logical id of this artifact
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder id(Id id) {
            return (Builder) super.id(id);
        }

        /**
         * <p>
         * The metadata about the resource. This is content that is maintained by the infrastructure. Changes to the content 
         * might not always be associated with version changes to the resource.
         * </p>
         * 
         * @param meta
         *     Metadata about the resource
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder meta(Meta meta) {
            return (Builder) super.meta(meta);
        }

        /**
         * <p>
         * A reference to a set of rules that were followed when the resource was constructed, and which must be understood when 
         * processing the content. Often, this is a reference to an implementation guide that defines the special rules along 
         * with other profiles etc.
         * </p>
         * 
         * @param implicitRules
         *     A set of rules under which this content was created
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder implicitRules(Uri implicitRules) {
            return (Builder) super.implicitRules(implicitRules);
        }

        /**
         * <p>
         * The base language in which the resource is written.
         * </p>
         * 
         * @param language
         *     Language of the resource content
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder language(Code language) {
            return (Builder) super.language(language);
        }

        /**
         * <p>
         * A human-readable narrative that contains a summary of the resource and can be used to represent the content of the 
         * resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient 
         * detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what 
         * content should be represented in the narrative to ensure clinical safety.
         * </p>
         * 
         * @param text
         *     Text summary of the resource, for human interpretation
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder text(Narrative text) {
            return (Builder) super.text(text);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder contained(Resource... contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder contained(Collection<Resource> contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
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
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
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
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder modifierExtension(Extension... modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder modifierExtension(Collection<Extension> modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * External Ids for this item.
         * </p>
         * 
         * @param identifier
         *     External Ids for this item
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder identifier(Identifier... identifier) {
            for (Identifier value : identifier) {
                this.identifier.add(value);
            }
            return this;
        }

        /**
         * <p>
         * External Ids for this item.
         * </p>
         * 
         * @param identifier
         *     External Ids for this item
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier.addAll(identifier);
            return this;
        }

        /**
         * <p>
         * Whether this schedule record is in active use or should not be used (such as was entered in error).
         * </p>
         * 
         * @param active
         *     Whether this schedule is in active use
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        /**
         * <p>
         * A broad categorization of the service that is to be performed during this appointment.
         * </p>
         * 
         * @param serviceCategory
         *     High-level category
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder serviceCategory(CodeableConcept... serviceCategory) {
            for (CodeableConcept value : serviceCategory) {
                this.serviceCategory.add(value);
            }
            return this;
        }

        /**
         * <p>
         * A broad categorization of the service that is to be performed during this appointment.
         * </p>
         * 
         * @param serviceCategory
         *     High-level category
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder serviceCategory(Collection<CodeableConcept> serviceCategory) {
            this.serviceCategory.addAll(serviceCategory);
            return this;
        }

        /**
         * <p>
         * The specific service that is to be performed during this appointment.
         * </p>
         * 
         * @param serviceType
         *     Specific service
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder serviceType(CodeableConcept... serviceType) {
            for (CodeableConcept value : serviceType) {
                this.serviceType.add(value);
            }
            return this;
        }

        /**
         * <p>
         * The specific service that is to be performed during this appointment.
         * </p>
         * 
         * @param serviceType
         *     Specific service
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder serviceType(Collection<CodeableConcept> serviceType) {
            this.serviceType.addAll(serviceType);
            return this;
        }

        /**
         * <p>
         * The specialty of a practitioner that would be required to perform the service requested in this appointment.
         * </p>
         * 
         * @param specialty
         *     Type of specialty needed
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder specialty(CodeableConcept... specialty) {
            for (CodeableConcept value : specialty) {
                this.specialty.add(value);
            }
            return this;
        }

        /**
         * <p>
         * The specialty of a practitioner that would be required to perform the service requested in this appointment.
         * </p>
         * 
         * @param specialty
         *     Type of specialty needed
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder specialty(Collection<CodeableConcept> specialty) {
            this.specialty.addAll(specialty);
            return this;
        }

        /**
         * <p>
         * Slots that reference this schedule resource provide the availability details to these referenced resource(s).
         * </p>
         * 
         * @param actor
         *     Resource(s) that availability information is being provided for
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder actor(Reference... actor) {
            for (Reference value : actor) {
                this.actor.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Slots that reference this schedule resource provide the availability details to these referenced resource(s).
         * </p>
         * 
         * @param actor
         *     Resource(s) that availability information is being provided for
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder actor(Collection<Reference> actor) {
            this.actor.addAll(actor);
            return this;
        }

        /**
         * <p>
         * The period of time that the slots that reference this Schedule resource cover (even if none exist). These cover the 
         * amount of time that an organization's planning horizon; the interval for which they are currently accepting 
         * appointments. This does not define a "template" for planning outside these dates.
         * </p>
         * 
         * @param planningHorizon
         *     Period of time covered by schedule
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder planningHorizon(Period planningHorizon) {
            this.planningHorizon = planningHorizon;
            return this;
        }

        /**
         * <p>
         * Comments on the availability to describe any extended information. Such as custom constraints on the slots that may be 
         * associated.
         * </p>
         * 
         * @param comment
         *     Comments on availability
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        @Override
        public Schedule build() {
            return new Schedule(this);
        }
    }
}