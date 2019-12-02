package org.sourcelab.activecampaign.response.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Account object.
 */
@JsonRootName(value = "account")
public class Account {
    private final String name;
    private final String accountUrl;

    @JsonCreator
    public Account(
        @JsonProperty("name") final String name,
        @JsonProperty("accountUrl") final String accountUrl) {
        this.name = name;
        this.accountUrl = accountUrl;
    }

    public String getName() {
        return name;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    /**
     * New Account Builder instance.
     * @return account builder instance.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Account{"
            + "name='" + name + '\''
            + ", accountUrl='" + accountUrl + '\''
            + '}';
    }

    /**
     * Builder instance for Account.
     */
    public static final class Builder {
        private String name;
        private String accountUrl;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAccountUrl(String accountUrl) {
            this.accountUrl = accountUrl;
            return this;
        }

        public Account build() {
            return new Account(name, accountUrl);
        }
    }
}
