package util

import org.andrekreou.dto.request.CreateProductRequest
import org.andrekreou.dto.response.CreateProductResponse

class Fixtures {

    static def createProductWithoutPrice() {
        CreateProductRequest request = new CreateProductRequest()
        request.setProductName('testName')
        request.setProductDescription('testDescription')
        request
    }

    static def createProduct() {
        CreateProductRequest request = new CreateProductRequest()
        request.setProductName('testName')
        request.setProductDescription('testDescription')
        request.setCurrency('EUR')
        request.setAmount(1000)
        request
    }

    static def createProductResponse() {
        CreateProductResponse response = new CreateProductResponse()
        response.setId('testId')
        response
    }
}
