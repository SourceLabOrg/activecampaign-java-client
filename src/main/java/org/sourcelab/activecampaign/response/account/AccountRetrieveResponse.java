package org.sourcelab.activecampaign.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an Account retrieve response.
 */
public class AccountRetrieveResponse {
    private final Account account;

    public AccountRetrieveResponse(
        @JsonProperty("account") final Account account
    ) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "AccountRetrieveRespose{"
            + "account=" + account
            + '}';
    }
}
