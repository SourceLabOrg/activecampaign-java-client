package org.sourcelab.activecampaign.reseller.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.client.response.JacksonFactory;
import org.sourcelab.activecampaign.reseller.response.AccountScoringResponse;
import org.sourcelab.activecampaign.reseller.response.AccountStatusSetResponse;

import java.io.IOException;

/**
 *
 */
public class AccountScoringRequest extends AbstractRequest<AccountScoringRequest, AccountScoringResponse> {

    public AccountScoringRequest() {
        super("account_scoring");
    }

    public AccountScoringRequest withAccount(final String account) {
        return setParam("account", account);
    }

    public AccountScoringRequest withActive() {
        return withStatus(RequestedStatus.ACTIVE);
    }

    public AccountScoringRequest withInactive() {
        return withStatus(RequestedStatus.INACTIVE);
    }

    public AccountScoringRequest withStatus(final RequestedStatus status) {
        if (RequestedStatus.INACTIVE.equals(status)) {
            // 0 == inactive
            return setParam("status", "0");
        } else {
            // 1 == active
            return setParam("status", "1");
        }
    }

    @Override
    public AccountScoringResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountScoringResponse.class);
    }
}
