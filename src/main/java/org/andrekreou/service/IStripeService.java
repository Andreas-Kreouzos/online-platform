package org.andrekreou.service;

import org.andrekreou.dto.RetrieveTransaction;
import org.andrekreou.client.StripeClient;
import org.andrekreou.response.BalanceTransaction;

/**
 * Handles the communication with Stripe service
 */
public interface IStripeService {

    /**
     * Responsible for calling the {@link StripeClient} with the necessary {@link RetrieveTransaction} to
     * retrieve the transaction details based on the transaction ID.
     *
     * @param retrieveTransaction the object to be used for the call
     * @return a {@link BalanceTransaction} that contains the transaction details
     */
    BalanceTransaction retrieveTransaction(RetrieveTransaction retrieveTransaction);

}
