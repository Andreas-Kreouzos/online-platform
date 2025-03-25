package org.andrekreou.validation;

import org.andrekreou.dto.request.RetrieveTransactionRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Contains the methods for validating {@link RetrieveTransactionRequest}
 */
public class ValidParametersValidator implements ConstraintValidator<ValidParameters, RetrieveTransactionRequest> {

    private static final String ERR_MSG = "Transaction ID is mandatory.";

    @Override
    public boolean isValid(RetrieveTransactionRequest retrieveTransactionRequest, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (retrieveTransactionRequest.getTransactionId() == null) {
            context.buildConstraintViolationWithTemplate(ERR_MSG)
                    .addPropertyNode("Missing Parameter Violation:")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
