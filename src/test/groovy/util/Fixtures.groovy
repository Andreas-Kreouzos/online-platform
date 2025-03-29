package util

import org.andrekreou.dto.request.CreateProductRequest

class Fixtures {

    static def createProduct() {
        CreateProductRequest request = new CreateProductRequest()
        request.setProductName('testName')
        request.setProductDescription('testDescription')
        request
    }
}
