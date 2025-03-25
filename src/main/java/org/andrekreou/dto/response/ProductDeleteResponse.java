package org.andrekreou.dto.response;

/**
 * Contains the product deletion response received from Stripe
 */
public class ProductDeleteResponse {

    private String id;
    private String object;
    private boolean deleted;

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
     * @return The deleted
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of deleted
     *
     * @param deleted The new value to set
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
