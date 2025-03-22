package org.andrekreou.validation;

import org.andrekreou.dto.RetrieveTransaction;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for validation of {@link RetrieveTransaction}
 * fields based on the constraints provided by {@link ValidParametersValidator}
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidParametersValidator.class)
public @interface ValidParameters {

    /**
     * Returns the default error message when the api is called with absent query parameters.
     *
     * @return A string detailing the default error message for invalid provided values
     */
    String message() default "Transaction ID is mandatory.";

    /**
     * Facilitates the specification of validation groups, enabling partial validation of constrained objects
     *
     * @return an array of Class objects, allowing for the specification of groups for grouped validation
     */
    Class<?>[] groups() default {};

    /**
     * Serves to attach custom metadata to the annotation, which validation clients can utilize
     *
     * @return an array of Class objects that extend Payload, used for carrying metadata for constraint validation
     */
    Class<? extends Payload>[] payload() default {};
}

