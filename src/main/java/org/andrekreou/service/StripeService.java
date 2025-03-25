package org.andrekreou.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andrekreou.client.StripeClient;
import org.andrekreou.dto.request.CreateProductRequest;
import org.andrekreou.dto.request.RetrieveTransactionRequest;
import org.andrekreou.dto.response.CreateProductResponse;
import org.andrekreou.exception.ResourceNotFoundException;
import org.andrekreou.dto.response.BalanceTransactionResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * @see IStripeService
 */
@ApplicationScoped
public class StripeService implements IStripeService {

    @Inject
    @RestClient
    StripeClient stripeClient;

    /**
     * @see IStripeService#retrieveTransaction 
     */
    @Override
    public BalanceTransactionResponse retrieveTransaction(RetrieveTransactionRequest retrieveTransactionRequest) {
        try {
            return stripeClient.retrieveBalanceTransaction(retrieveTransactionRequest.getTransactionId());
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("No entity found for transaction id: " + retrieveTransactionRequest.getTransactionId());
        }
    }

    /**
     * @see IStripeService#createProduct
     */
    @Override
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest) {
        return stripeClient.create(createProductRequest.getProductName(), createProductRequest.getProductDescription());
    }
}
