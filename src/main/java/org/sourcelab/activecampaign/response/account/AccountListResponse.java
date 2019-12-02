package org.sourcelab.activecampaign.response.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.sourcelab.activecampaign.response.Meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the response returned from the accounts list api resource.
 */
public class AccountListResponse {
    private final List<Account> accounts;
    private final Meta meta;

    /**
     * Constructor.
     * @param accounts
     * @param meta
     */
    @JsonCreator
    public AccountListResponse(
        @JsonProperty("accounts") final List<Account> accounts,
        @JsonProperty("meta") final Meta meta
    ) {
        this.accounts = Collections.unmodifiableList(new ArrayList<>(accounts));
        this.meta = meta;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Meta getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return "AccountListResponse{"
            + "accounts=" + accounts
            + ", meta=" + meta
            + '}';
    }
}
