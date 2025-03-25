package org.andrekreou.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

/**
 * The object needed, to create a new product.
 */
public class CreateProductRequest {

    @NotBlank(message = "Product name must not be blank")
    private String productName;

    @NotBlank(message = "Product description must not be blank")
    private String productDescription;

    /**
     * @return The productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of productName
     *
     * @param productName The new value to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return The productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the value of productDescription
     *
     * @param productDescription The new value to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
