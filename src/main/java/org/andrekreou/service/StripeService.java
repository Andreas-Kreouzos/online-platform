package org.andrekreou.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andrekreou.client.StripeClient;
import org.andrekreou.dto.RetrieveTransaction;
import org.andrekreou.exception.ResourceNotFoundException;
import org.andrekreou.response.BalanceTransaction;
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
    public BalanceTransaction retrieveTransaction(RetrieveTransaction retrieveTransaction) {
        try {
            return stripeClient.retrieveBalanceTransaction(retrieveTransaction.getTransactionId());
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("No entity found for transaction id: " + retrieveTransaction.getTransactionId());
        }
    }
}
