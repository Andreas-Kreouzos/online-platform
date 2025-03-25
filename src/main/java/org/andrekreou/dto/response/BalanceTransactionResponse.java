package org.andrekreou.dto.response;

import org.andrekreou.dto.FeeDetail;

import java.util.List;

/**
 * Contains the balance transaction information from Stripe
 */
public class BalanceTransactionResponse {

    private String id;
    private String object;
    private int amount;
    private long availableOn;
    private long created;
    private String currency;
    private String description;
    private Double exchangeRate;
    private int fee;
    private List<FeeDetail> feeDetails;
    private int net;
    private String reportingCategory;
    private String source;
    private String status;
    private String type;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of id
     *
     * @param id The new value to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The object
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the value of object
     *
     * @param object The new value to set
     */
    public void setObject(String object) {
        this.object = object;
    }

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
     * @return The availableOn
     */
    public long getAvailableOn() {
        return availableOn;
    }

    /**
     * Sets the value of availableOn
     *
     * @param availableOn The new value to set
     */
    public void setAvailableOn(long availableOn) {
        this.availableOn = availableOn;
    }

    /**
     * @return The created
     */
    public long getCreated() {
        return created;
    }

    /**
     * Sets the value of created
     *
     * @param created The new value to set
     */
    public void setCreated(long created) {
        this.created = created;
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
     * @return The exchangeRate
     */
    public Double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the value of exchangeRate
     *
     * @param exchangeRate The new value to set
     */
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * @return The fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * Sets the value of fee
     *
     * @param fee The new value to set
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

    /**
     * @return The feeDetails
     */
    public List<FeeDetail> getFeeDetails() {
        return feeDetails;
    }

    /**
     * Sets the value of feeDetails
     *
     * @param feeDetails The new value to set
     */
    public void setFeeDetails(List<FeeDetail> feeDetails) {
        this.feeDetails = feeDetails;
    }

    /**
     * @return The net
     */
    public int getNet() {
        return net;
    }

    /**
     * Sets the value of net
     *
     * @param net The new value to set
     */
    public void setNet(int net) {
        this.net = net;
    }

    /**
     * @return The reportingCategory
     */
    public String getReportingCategory() {
        return reportingCategory;
    }

    /**
     * Sets the value of reportingCategory
     *
     * @param reportingCategory The new value to set
     */
    public void setReportingCategory(String reportingCategory) {
        this.reportingCategory = reportingCategory;
    }

    /**
     * @return The source
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of source
     *
     * @param source The new value to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of status
     *
     * @param status The new value to set
     */
    public void setStatus(String status) {
        this.status = status;
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
