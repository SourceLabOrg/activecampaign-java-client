package org.sourcelab.activecampaign.reseller.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.client.response.JacksonFactory;
import org.sourcelab.activecampaign.reseller.response.AccountPlansResponse;

import java.io.IOException;

/**
 *
 */
public class AccountPlansRequest extends AbstractRequest<AccountPlansRequest, AccountPlansResponse> {
    private static final Logger logger = LoggerFactory.getLogger(AccountPlansRequest.class);

    public AccountPlansRequest() {
        super("account_plans");
    }

    @Override
    public AccountPlansResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountPlansResponse.class);
    }

    public AccountPlansRequest withAccount(final String account) {
        return setParam("account", account);
    }
}
