package org.andrekreou.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Contains the product creation response received from Stripe
 */
public class CreateProductResponse {

    private String id;
    private String object;
    private boolean active;
    private List<String> attributes;
    private long created;

    @JsonProperty("default_price")
    private String defaultPrice;

    private String description;
    private List<String> images;
    private boolean livemode;

    @JsonProperty("marketing_features")
    private List<String> marketingFeatures;

    private Map<String, Object> metadata;
    private String name;

    @JsonProperty("package_dimensions")
    private String packageDimensions;

    private Boolean shippable;

    @JsonProperty("statement_descriptor")
    private String statementDescriptor;

    @JsonProperty("tax_code")
    private String taxCode;

    private String type;

    @JsonProperty("unit_label")
    private String unitLabel;

    private long updated;
    private String url;

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
     * @return The active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of active
     *
     * @param active The new value to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return The attributes
     */
    public List<String> getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of attributes
     *
     * @param attributes The new value to set
     */
    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
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
     * @return The defaultPrice
     */
    public String getDefaultPrice() {
        return defaultPrice;
    }

    /**
     * Sets the value of defaultPrice
     *
     * @param defaultPrice The new value to set
     */
    public void setDefaultPrice(String defaultPrice) {
        this.defaultPrice = defaultPrice;
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
     * @return The images
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * Sets the value of images
     *
     * @param images The new value to set
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

    /**
     * @return The livemode
     */
    public boolean isLivemode() {
        return livemode;
    }

    /**
     * Sets the value of livemode
     *
     * @param livemode The new value to set
     */
    public void setLivemode(boolean livemode) {
        this.livemode = livemode;
    }

    /**
     * @return The marketingFeatures
     */
    public List<String> getMarketingFeatures() {
        return marketingFeatures;
    }

    /**
     * Sets the value of marketingFeatures
     *
     * @param marketingFeatures The new value to set
     */
    public void setMarketingFeatures(List<String> marketingFeatures) {
        this.marketingFeatures = marketingFeatures;
    }

    /**
     * @return The metadata
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of metadata
     *
     * @param metadata The new value to set
     */
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of name
     *
     * @param name The new value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The packageDimensions
     */
    public String getPackageDimensions() {
        return packageDimensions;
    }

    /**
     * Sets the value of packageDimensions
     *
     * @param packageDimensions The new value to set
     */
    public void setPackageDimensions(String packageDimensions) {
        this.packageDimensions = packageDimensions;
    }

    /**
     * @return The shippable
     */
    public Boolean getShippable() {
        return shippable;
    }

    /**
     * Sets the value of shippable
     *
     * @param shippable The new value to set
     */
    public void setShippable(Boolean shippable) {
        this.shippable = shippable;
    }

    /**
     * @return The statementDescriptor
     */
    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    /**
     * Sets the value of statementDescriptor
     *
     * @param statementDescriptor The new value to set
     */
    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    /**
     * @return The taxCode
     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * Sets the value of taxCode
     *
     * @param taxCode The new value to set
     */
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
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

    /**
     * @return The unitLabel
     */
    public String getUnitLabel() {
        return unitLabel;
    }

    /**
     * Sets the value of unitLabel
     *
     * @param unitLabel The new value to set
     */
    public void setUnitLabel(String unitLabel) {
        this.unitLabel = unitLabel;
    }

    /**
     * @return The updated
     */
    public long getUpdated() {
        return updated;
    }

    /**
     * Sets the value of updated
     *
     * @param updated The new value to set
     */
    public void setUpdated(long updated) {
        this.updated = updated;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of url
     *
     * @param url The new value to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
