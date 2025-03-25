package org.andrekreou.mapper;

import org.andrekreou.dto.response.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 *  Provides a consistent way of handling {@link ConstraintViolationException} instances by
 *  extracting the violation messages and return a response with just the message list.
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(prepareMessage(exception)).build();
    }

    private ErrorResponse prepareMessage(ConstraintViolationException exception) {
        List<String> violations = fetchOrderedViolations(exception);
        return buildErrorResponse(violations);
    }

    private List<String> fetchOrderedViolations(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream()
                .map(this::buildViolationMessage)
                .sorted()
                .toList();
    }

    private ErrorResponse buildErrorResponse(List<String> violations) {
        return new ErrorResponse(violations);
    }

    private String buildViolationMessage(ConstraintViolation<?> violation) {
        return findViolationField(violation) + " " + violation.getMessage();
    }

    private String findViolationField(ConstraintViolation<?> violation) {
        return StreamSupport.stream(violation.getPropertyPath().spliterator(), false)
                .map(Path.Node::getName)
                .reduce((first, second) -> second).orElse(null);
    }
}
