package org.andrekreou.dto.request;

import jakarta.ws.rs.QueryParam;
import org.andrekreou.validation.ValidParameters;

/**
 * The object needed, to create a retrieve transaction request to the external system.
 */
@ValidParameters
public class RetrieveTransactionRequest {

    @QueryParam("id")
    private String transactionId;

    /**
     * Default constructor required for displaying validation error messages
     */
    public RetrieveTransactionRequest() {
    }

    /**
     * @return The transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of transactionId
     *
     * @param transactionId The new value to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
