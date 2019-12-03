package org.sourcelab.activecampaign.reseller.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class AccountListRequest implements Request<String> {

    @Override
    public String getApiEndpoint() {
        return "";
    }

    @Override
    public RequestMethod getRequestMethod() {
        return null;
    }

    @Override
    public Object getRequestBody() {
        final Map<String, String> params = new HashMap<>();
        params.put("api_action", "account_list");
        return params;
    }

    @Override
    public String parseResponse(final String response) throws IOException {
        return response;
    }
}
