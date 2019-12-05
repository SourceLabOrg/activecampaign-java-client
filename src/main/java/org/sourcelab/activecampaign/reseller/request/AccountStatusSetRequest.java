package org.sourcelab.activecampaign.reseller.request;

import org.sourcelab.activecampaign.client.response.JacksonFactory;
import org.sourcelab.activecampaign.reseller.response.AccountStatusSetResponse;

import java.io.IOException;

/**
 *
 */
public class AccountStatusSetRequest extends AbstractRequest<AccountStatusSetRequest, AccountStatusSetResponse> {

    public AccountStatusSetRequest() {
        super("account_status_set");
    }

    public AccountStatusSetRequest withAccount(final String account) {
        return setParam("account", account);
    }

    public AccountStatusSetRequest withActive() {
        return withStatus(RequestedStatus.ACTIVE);
    }

    public AccountStatusSetRequest withInactive() {
        return withStatus(RequestedStatus.INACTIVE);
    }

    public AccountStatusSetRequest withStatus(final RequestedStatus status) {
        if (RequestedStatus.INACTIVE.equals(status)) {
            // 1 == inactive
            return setParam("status", "1");
        } else {
            // 0 == active
            return setParam("status", "0");
        }
    }

    public AccountStatusSetRequest withMessage(final String message) {
        return setParam("message", message);
    }

    @Override
    public AccountStatusSetResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountStatusSetResponse.class);
    }
}
