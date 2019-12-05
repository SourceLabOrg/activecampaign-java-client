package org.sourcelab.activecampaign.reseller.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.client.response.JacksonFactory;
import org.sourcelab.activecampaign.reseller.response.AccountNameCheckResponse;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Reseller Account Name Check Request.
 */
public class AccountNameCheckRequest extends AbstractRequest<AccountNameCheckRequest, AccountNameCheckResponse> {
    private static final Logger logger = LoggerFactory.getLogger(AccountNameCheckRequest.class);

    public AccountNameCheckRequest(final String account) {
        super("account_name_check");
        setParam("account", account);
    }

    @Override
    public AccountNameCheckResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountNameCheckResponse.class);
    }
}
