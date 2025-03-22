package org.andrekreou.validation;

import org.andrekreou.dto.RetrieveTransaction;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Contains the methods for validating {@link RetrieveTransaction}
 */
public class ValidParametersValidator implements ConstraintValidator<ValidParameters, RetrieveTransaction> {

    private static final String ERR_MSG = "Transaction ID is mandatory.";

    @Override
    public boolean isValid(RetrieveTransaction retrieveTransaction, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (retrieveTransaction.getTransactionId() == null) {
            context.buildConstraintViolationWithTemplate(ERR_MSG)
                    .addPropertyNode("Missing Parameter Violation:")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
