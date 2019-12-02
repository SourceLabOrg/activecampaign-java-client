package org.sourcelab.activecampaign.response.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents an error returned from the API.
 */
public class RequestErrorResponse {
    private final List<Error> errors;

    @JsonCreator
    public RequestErrorResponse(
        @JsonProperty("errors") final List<Error> errors) {
        this.errors = Collections.unmodifiableList(new ArrayList<>(errors));
    }

    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "RequestErrorResponse{"
            + "errors=" + errors
            + '}';
    }
}
