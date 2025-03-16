package org.andrekreou.response;

/**
 * Contains the fee details that is being applied from Stripe
 */
public class FeeDetail {

    private int amount;
    private String application;
    private String currency;
    private String description;
    private String type;

    /**
     * @return The amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the value of amount
     *
     * @param amount The new value to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return The application
     */
    public String getApplication() {
        return application;
    }

    /**
     * Sets the value of application
     *
     * @param application The new value to set
     */
    public void setApplication(String application) {
        this.application = application;
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
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of description
     *
     * @param description The new value to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of type
     *
     * @param type The new value to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
