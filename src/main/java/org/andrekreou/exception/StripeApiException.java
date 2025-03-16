package org.andrekreou.exception;

/**
 * Custom exception for handling errors received from Stripe services
 */
public class StripeApiException extends RuntimeException {

    private final int statusCode;
    private final String responseBody;

    public StripeApiException(int statusCode, String responseBody) {
        super("Stripe API Error: " + responseBody);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    /**
     * @return The statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @return The responseBody
     */
    public String getResponseBody() {
        return responseBody;
    }
}
