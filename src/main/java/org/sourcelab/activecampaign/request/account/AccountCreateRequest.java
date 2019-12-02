package org.sourcelab.activecampaign.request.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.response.JacksonFactory;
import org.sourcelab.activecampaign.response.account.Account;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;

import java.io.IOException;

/**
 * Represents an account create request.
 */
public class AccountCreateRequest implements Request<String> {
    private final Account account;

    public AccountCreateRequest(final Account account) {
        this.account = account;
    }

    @Override
    public String getApiEndpoint() {
        return "accounts";
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public Object getRequestBody() {
        try {
            return JacksonFactory.newInstance().writeValueAsString(account);
        } catch (final JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public String parseResponse(final String response) throws IOException {
        return response;
    }
}
