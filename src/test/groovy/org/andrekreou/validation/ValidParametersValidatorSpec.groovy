package org.andrekreou.validation

import jakarta.validation.ConstraintValidatorContext
import org.andrekreou.dto.request.RetrieveTransactionRequest
import spock.lang.Specification
import spock.lang.Subject

class ValidParametersValidatorSpec extends Specification {

    @Subject
    ValidParametersValidator validator

    ConstraintValidatorContext context
    ConstraintValidatorContext.ConstraintViolationBuilder violationBuilder
    ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilder

    def setup() {
        validator = new ValidParametersValidator()
        context = Mock()
        violationBuilder = Mock()
        nodeBuilder = Mock()
    }

    def 'Successfully return true for transaction ID #transactionId'() {
        given: 'the provided request dto'
        def retrieveTransactionRequest = new RetrieveTransactionRequest(transactionId: '123')

        when: 'the validator gets invoked'
        def result = validator.isValid(retrieveTransactionRequest, context)

        then: 'the result matches the expected outcome'
        result
    }

    def 'Successfully return false for null transaction ID'() {
        given: 'the provided request dto'
        def retrieveTransactionRequest = new RetrieveTransactionRequest(transactionId: null)

        and: 'a context'
        context.buildConstraintViolationWithTemplate(_) >> violationBuilder
        violationBuilder.addPropertyNode(_) >> nodeBuilder
        nodeBuilder.addConstraintViolation() >> null

        when: 'the validator gets invoked'
        def result = validator.isValid(retrieveTransactionRequest, context)

        then: 'the result matches the expected outcome'
        !result
    }
}