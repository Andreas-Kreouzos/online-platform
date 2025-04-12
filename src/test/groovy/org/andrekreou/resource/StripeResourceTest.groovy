package org.andrekreou.resource

import io.quarkus.test.InjectMock
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.security.TestSecurity
import jakarta.ws.rs.core.MediaType
import org.andrekreou.service.IStripeService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import util.Fixtures

import static io.restassured.RestAssured.given
import static org.mockito.ArgumentMatchers.argThat
import static org.mockito.Mockito.times
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.containsString

@QuarkusTest
class StripeResourceTest {

    private static final String ERR_MSG = 'An unexpected error occurred!!!'

    @InjectMock
    IStripeService service

    @Test
    @TestSecurity(user = 'testUser', roles = 'trainer')
    @DisplayName('Successfully created a new product')
    void testCreateNewProduct() {
        def createProduct = Fixtures.createProduct()
        def productResponse = Fixtures.createProductResponse()

        when(service.createProduct(argThat { request ->
            request.properties == createProduct.properties
        })).thenReturn(productResponse)

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createProduct)
                .when()
                .post('/stripe/product')
                .then()
                .log().all()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body('id', equalTo(productResponse.id))

        verify(service, times(1)).createProduct(argThat { request ->
            request.properties == createProduct.properties
        })
    }

    @Test
    @TestSecurity(user = 'testUser', roles = 'trainer')
    @DisplayName('Create a new product should fail when an unexpected error occurs')
    void testCreateNewProductFailsDueToUnexpectedError() {
        def createProduct = Fixtures.createProduct()

        when(service.createProduct(argThat { request ->
            request.properties == createProduct.properties
        })).thenThrow(new RuntimeException(ERR_MSG))

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createProduct)
                .when()
                .post('/stripe/product')
                .then()
                .log().all()
                .statusCode(500)
                .contentType(MediaType.APPLICATION_JSON)
                .body('details', containsString(ERR_MSG))

        verify(service, times(1)).createProduct(argThat { request ->
            request.properties == createProduct.properties
        })
    }
}
