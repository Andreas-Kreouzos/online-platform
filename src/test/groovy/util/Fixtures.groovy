package util

import org.andrekreou.dto.request.CreateProductRequest

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
}
