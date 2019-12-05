package org.sourcelab.activecampaign.reseller.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Reseller Account Request.
 */
public abstract class AbstractRequest<Self, T> implements Request<T> {
    private static final Logger logger = LoggerFactory.getLogger(AbstractRequest.class);

    // Param holder
    private final Map<String, String> params = new HashMap<>();

    protected AbstractRequest(final String apiAction) {
        setParam("api_action", apiAction);
    }

    @Override
    public String getApiEndpoint() {
        return "";
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public Object getRequestBody() {
        // return copy of our parameters
        return new HashMap<>(params);
    }

    @SuppressWarnings("unchecked")
    protected Self setParam(final String name, String value) {
        if (value == null) {
            params.remove(name);
        } else {
            params.put(name, value);
        }
        return (Self) this;
    }
}
