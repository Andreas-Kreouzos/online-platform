package org.andrekreou.service;

import org.andrekreou.dto.request.CreateProductRequest;
import org.andrekreou.dto.request.RetrieveTransactionRequest;
import org.andrekreou.client.StripeClient;
import org.andrekreou.dto.response.BalanceTransactionResponse;
import org.andrekreou.dto.response.CreateProductResponse;

/**
 * Handles the communication with Stripe service
 */
public interface IStripeService {

    /**
     * Responsible for calling the {@link StripeClient} with the necessary {@link RetrieveTransactionRequest} to
     * retrieve the transaction details based on the transaction ID.
     *
     * @param retrieveTransactionRequest the object to be used for the call
     * @return a {@link BalanceTransactionResponse} that contains the transaction details
     */
    BalanceTransactionResponse retrieveTransaction(RetrieveTransactionRequest retrieveTransactionRequest);

    /**
     * Responsible for calling the {@link StripeClient} with the necessary {@link CreateProductRequest} to
     * create a new product.
     *
     * @param createProductRequest the object to be used for the call
     * @return a {@link CreateProductResponse} that contains the product creation details
     */
    CreateProductResponse createProduct(CreateProductRequest createProductRequest);
}
