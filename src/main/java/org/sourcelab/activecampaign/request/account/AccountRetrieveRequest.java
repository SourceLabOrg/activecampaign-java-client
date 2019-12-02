package org.sourcelab.activecampaign.request.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.response.JacksonFactory;
import org.sourcelab.activecampaign.response.account.AccountRetrieveResponse;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;

import java.io.IOException;

/**
 * Represents an account retrieve request.
 */
public class AccountRetrieveRequest implements Request<AccountRetrieveResponse> {
    private static final Logger logger = LoggerFactory.getLogger(AccountRetrieveRequest.class);

    private final long id;

    /**
     * Constructor.
     * @param id of Account to retrieve.
     */
    public AccountRetrieveRequest(final long id) {
        this.id = id;
    }

    @Override
    public String getApiEndpoint() {
        return "accounts/" + id;
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
    public AccountRetrieveResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountRetrieveResponse.class);
    }
}
