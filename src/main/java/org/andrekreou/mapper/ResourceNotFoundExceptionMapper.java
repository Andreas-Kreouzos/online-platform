package org.andrekreou.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.andrekreou.dto.ErrorResponse;
import org.andrekreou.exception.ResourceNotFoundException;

import java.util.List;

/**
 *  Provides a consistent way of handling {@link ResourceNotFoundException} instances
 */
@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {
    @Override
    public Response toResponse(ResourceNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponse(List.of(exception.getMessage())))
                .build();
    }
}
