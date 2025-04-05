package org.andrekreou.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * The object needed, to create a new product.
 */
public class CreateProductRequest {

    @NotBlank(message = "Product name must not be blank")
    private String productName;

    @NotBlank(message = "Product description must not be blank")
    private String productDescription;

    @NotBlank(message = "Product name must not be blank")
    private String currency;

    @NotNull
    private Integer amount;

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

    /**
     * @return The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of currency
     *
     * @param currency The new value to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return The amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets the value of amount
     *
     * @param amount The new value to set
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
