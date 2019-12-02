package org.sourcelab.activecampaign.response.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents source error object.
 */
public class Source {
    private final String pointer;

    @JsonCreator
    public Source(
        @JsonProperty("pointer") final String pointer
    ) {
        this.pointer = pointer;
    }

    public String getPointer() {
        return pointer;
    }

    @Override
    public String toString() {
        return "Source{"
            + "pointer='" + pointer + '\''
            + '}';
    }
}
