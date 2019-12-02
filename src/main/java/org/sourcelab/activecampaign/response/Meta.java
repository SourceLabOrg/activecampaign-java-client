package org.sourcelab.activecampaign.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Meta response object.
 */
public class Meta {
    private final int total;

    @JsonCreator
    public Meta(
        @JsonProperty("total") final int total
    ) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Meta{"
            + "total=" + total
            + '}';
    }
}
