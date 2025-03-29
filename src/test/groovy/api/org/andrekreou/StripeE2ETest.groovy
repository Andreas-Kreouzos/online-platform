package api.org.andrekreou

import groovy.json.JsonSlurper
import io.quarkus.test.junit.QuarkusTest
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.htmlunit.WebClient
import org.htmlunit.html.HtmlForm
import org.htmlunit.html.HtmlPage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertTrue

@QuarkusTest
class StripeE2ETest {

    WebClient webClient

    @ConfigProperty(name = 'stripe.admin.username')
    String username

    @ConfigProperty(name = 'stripe.admin.password')
    String password

    @BeforeEach
    void setup() {
        webClient = new WebClient()
        webClient.getOptions().setCssEnabled(false)
        webClient.getOptions().setRedirectEnabled(true)
        webClient.getCookieManager().setCookiesEnabled(true)
    }

    @Test
    @DisplayName("Successfully call retrieve transaction")
    void testSuccessfullyRetrieveTransaction() {
        //given: a valid transaction ID
        String transactionId = 'txn_3R2xAKFZLv1HNLFS1SQXtbmq'

        //when: calling the secured resource
        HtmlPage loginPage = webClient.getPage("http://localhost:8080/stripe/transaction?id=${transactionId}")

        //and: the login form of Keycloak gets loaded
        HtmlForm loginForm = loginPage.getForms().get(0)

        //and: providing the appropriate user credentials
        loginForm.getInputByName("username").type(username)
        loginForm.getInputByName("password").type(password)

        //and: submitting the form
        def loginResponse = loginForm.getButtonByName("login").click()

        //then: the endpoint response gets returned
        String response = loginResponse.getWebResponse().getContentAsString()

        //and: parse the response
        def parsedJson = new JsonSlurper().parseText(response)

        //and: the expected field values are matched with the actual ones
        assertEquals(transactionId, parsedJson.id)
        assertEquals('eur', parsedJson.currency)
        assertEquals('available', parsedJson.status)
    }

    @Test
    @DisplayName("Retrieve transaction failed due to incorrect password")
    void testCannotAccessSecuredEndpointDueToLoginFailWithWrongPassword() {
        //given: a valid transaction ID
        String transactionId = 'txn_3R2xAKFZLv1HNLFS1SQXtbmq'

        //and: an incorrect password
        String wrongPassword = 'wrong_password'

        //and: a Keycloak error message
        String errorMessage = 'Invalid username or password.'

        //when: calling the secured resource
        HtmlPage loginPage = webClient.getPage("http://localhost:8080/stripe/transaction?id=${transactionId}")

        //and: the login form of Keycloak gets loaded
        HtmlForm loginForm = loginPage.getForms().get(0)

        //and: providing incorrect user credentials
        loginForm.getInputByName('username').type(username)
        loginForm.getInputByName('password').type(wrongPassword)

        //and: submitting the form
        HtmlPage errorPage = loginForm.getButtonByName('login').click()

        //then: the page of Keycloak gets returned as text
        String pageContent = errorPage.asNormalizedText()

        //and: contains the appropriate error message
        assertTrue(pageContent.contains(errorMessage))
    }

}
