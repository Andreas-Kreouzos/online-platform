package org.andrekreou.mapper;

import jakarta.ws.rs.core.Response;
import org.andrekreou.exception.StripeApiException;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

/**
 * Provides a consistent way of handling {@link StripeApiException} instances
 */
public class StripeApiExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    @Override
    public RuntimeException toThrowable(Response response) {
        try {
            String errorMessage = response.readEntity(String.class);
            return new StripeApiException(response.getStatus(), errorMessage);
        } catch (Exception e) {
            return new StripeApiException(response.getStatus(), "Stripe API Error: Unable to parse response");
        }
    }
}
