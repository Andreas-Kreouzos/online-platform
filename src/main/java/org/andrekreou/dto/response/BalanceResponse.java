package org.andrekreou.dto.response;

import java.util.List;

/**
 * Contains the balance transaction response received from Stripe
 */
public class BalanceResponse {

    private String object;
    private List<BalanceTransactionResponse> data;
    private boolean hasMore;
    private String url;

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
     * @return The data
     */
    public List<BalanceTransactionResponse> getData() {
        return data;
    }

    /**
     * Sets the value of data
     *
     * @param data The new value to set
     */
    public void setData(List<BalanceTransactionResponse> data) {
        this.data = data;
    }

    /**
     * @return The hasMore
     */
    public boolean isHasMore() {
        return hasMore;
    }

    /**
     * Sets the value of hasMore
     *
     * @param hasMore The new value to set
     */
    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
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
