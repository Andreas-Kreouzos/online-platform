package org.andrekreou.client

import io.quarkus.test.junit.QuarkusTest
import org.andrekreou.exception.StripeApiException
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertNotNull
import static org.junit.jupiter.api.Assertions.assertThrows
import static org.junit.jupiter.api.Assertions.assertTrue

@QuarkusTest
class StripeClientTest {

    @RestClient
    StripeClient stripeClient

    @Test
    @DisplayName("200 OK response when successfully call the balance transactions retrieval")
    void testSuccessfulCallingBalanceTransactions() {
        //given: the number of transactions to be displayed
        def limit = 1

        //when: calling the balance transactions retrieval
        def response = stripeClient.retrieveBalanceTransactions(limit)
        println response

        //then: the response is not null
        assertNotNull(response)

        //and: one transaction gets indeed returned
        assertEquals(1, response.getData().size())
    }

    @Test
    @DisplayName("401 unauthorized response when used invalid secret key to call Stripe")
    void testUnauthorizedCallingWithInvalidSecretKey() {
        //given: an invalid secret key
        System.setProperty("stripe.sandbox.key", "wrong-key")

        //and: the number of transactions to be displayed
        def limit = 1

        //when: calling the balance transactions retrieval
        StripeApiException exception = assertThrows(StripeApiException.class, () -> {
            stripeClient.retrieveBalanceTransactions(limit)
        })

        //then: the response is not null
        assertEquals(401, exception.statusCode)
        assertTrue(exception.getResponseBody().contains("You did not provide an API key"))

        // and: revert the secret key to its original state
        System.clearProperty("stripe.sandbox.key")
    }
}
