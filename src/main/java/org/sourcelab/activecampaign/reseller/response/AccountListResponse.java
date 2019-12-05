package org.sourcelab.activecampaign.reseller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Reseller account list response.
 */
public class AccountListResponse {
    private final List<Account> accounts;

    /**
     * Constructor.
     */
    @JsonCreator
    public AccountListResponse(@JsonProperty("accounts") final List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "AccountListResponse{"
            + "accounts=" + accounts
            + '}';
    }
}
