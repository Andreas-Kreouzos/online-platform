package org.andrekreou.mapper

import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.ws.rs.core.Response
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator
import spock.lang.Specification
import spock.lang.Subject
import util.ValidatedBean

class ConstraintViolationExceptionMapperSpec extends Specification {

    @Subject
    ConstraintViolationExceptionMapper mapper

    Validator validator

    def setup() {
        validator = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory()
                .getValidator()
        mapper = new ConstraintViolationExceptionMapper()
    }

    def 'Mapper transforms the constraint violation exception correctly'(){
        given: 'a validated bean with violations'
        Set<ConstraintViolation<ValidatedBean>> violations = validator.validate(new ValidatedBean(age: -1))

        and: 'an exception with violations'
        def exception = new ConstraintViolationException(new HashSet<>(violations))

        when: 'the mapper converts the exception to a response'
        def response = mapper.toResponse(exception)

        then: 'the response is 400'
        response.status == Response.Status.BAD_REQUEST.statusCode

        and: 'with the proper violated messages'
        response.getEntity().errors.size() == 3
        response.getEntity().errors[0] == 'age must be greater than or equal to 0'
        response.getEntity().errors[1] == 'blank must not be blank'
        response.getEntity().errors[2] == 'id must not be null'
    }

    def 'Mapper handles constraint violation exception with no violations correctly'(){
        given: 'an exception with no violations'
        def exception = new ConstraintViolationException(Collections.emptySet())

        when: 'the mapper converts the exception to a response'
        def response = mapper.toResponse(exception)

        then: 'the response is 400'
        response.status == Response.Status.BAD_REQUEST.statusCode

        and: 'with empty error messages'
        response.getEntity().errors.isEmpty()
    }
}
