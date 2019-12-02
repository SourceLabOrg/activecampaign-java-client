package org.sourcelab.activecampaign.request.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.response.JacksonFactory;
import org.sourcelab.activecampaign.response.account.AccountListResponse;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;

import java.io.IOException;

/**
 * Represents an account list request.
 */
public class AccountListRequest implements Request<AccountListResponse> {
    private static final Logger logger = LoggerFactory.getLogger(AccountListRequest.class);

    @Override
    public String getApiEndpoint() {
        return "accounts";
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
    public AccountListResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountListResponse.class);
    }
}
