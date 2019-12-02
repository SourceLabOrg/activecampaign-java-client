package org.sourcelab.activecampaign.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;

import java.io.IOException;

/**
 * Simple request to validate that the credentials configured are valid.
 */
public class LoginRequest implements Request<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(LoginRequest.class);

    @Override
    public String getApiEndpoint() {
        return "/";
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public Object getRequestBody() {
        return "";
    }

    @Override
    public Boolean parseResponse(final String s) throws IOException {
        // If the request is valid, we just return true.
        // If the request is invalid, we'll throw an exception.
        return true;
    }
}
