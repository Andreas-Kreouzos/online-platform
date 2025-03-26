package api.org.andrekreou

import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.security.TestSecurity
import jakarta.ws.rs.core.MediaType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import static io.restassured.RestAssured.given
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
class StripeE2ETest {

    @Test
    @TestSecurity(user = "andrekreou", roles = "admin")
    @DisplayName("Successfully call retrieve transaction")
    void testSuccessfullyRetrieveTransaction() {
        String id = 'txn_3R2xAKFZLv1HNLFS1SQXtbmq'

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam('id', id)
                .when()
                .get('/stripe/transaction')
                .then()
                .log().all()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("id", equalTo(id))
                .body("currency", equalTo('eur'))
                .body("status", equalTo('available'))
    }
}
