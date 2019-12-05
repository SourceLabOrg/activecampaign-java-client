package org.sourcelab.activecampaign.reseller.request;

import org.sourcelab.activecampaign.client.response.JacksonFactory;
import org.sourcelab.activecampaign.reseller.response.AccountStatusResponse;

import java.io.IOException;

/**
 *
 */
public class AccountStatusRequest extends AbstractRequest<AccountStatusRequest, AccountStatusResponse> {
    public AccountStatusRequest(final String account) {
        super("account_status");
        setParam("account", account);
    }

    @Override
    public AccountStatusResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountStatusResponse.class);
    }
}
