package org.sourcelab.activecampaign.response.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Map;

/**
 * Account object.
 */
@JsonRootName(value = "account")
public class Account {
    private final Long id;
    private final String name;
    private final String accountUrl;

    // Related
    private final long contactCount;
    private final long dealCount;

    // Related links
    private Map<String, String> links;

    // Timestamps
    private final ZonedDateTime createdTimestamp;
    private final ZonedDateTime updatedTimestamp;

    /**
     * Constructor, tho use of Builder is recommended.
     *
     * @param id
     * @param name
     * @param accountUrl
     * @param contactCount
     * @param dealCount
     * @param createdTimestamp
     * @param updatedTimestamp
     */
    @JsonCreator
    public Account(
        @JsonProperty("id") final Long id,
        @JsonProperty("name") final String name,
        @JsonProperty("accountUrl") final String accountUrl,
        @JsonProperty("contactCount") final long contactCount,
        @JsonProperty("dealCount") final long dealCount,
        @JsonProperty("createdTimestamp") final ZonedDateTime createdTimestamp,
        @JsonProperty("updatedTimestamp") final ZonedDateTime updatedTimestamp,
        @JsonProperty("links") final Map<String, String> links
    ) {
        this.id = id;
        this.name = name;
        this.accountUrl = accountUrl;
        this.contactCount = contactCount;
        this.dealCount = dealCount;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
        if (links == null) {
            this.links = Collections.emptyMap();
        } else {
            this.links = Collections.unmodifiableMap(links);
        }

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public long getContactCount() {
        return contactCount;
    }

    public long getDealCount() {
        return dealCount;
    }

    public ZonedDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public ZonedDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public Map<String, String> getLinks() {
        return links;
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
            + "id=" + id
            + ", name='" + name + '\''
            + ", accountUrl='" + accountUrl + '\''
            + ", contactCount=" + contactCount
            + ", dealCount=" + dealCount
            + ", links=" + links
            + ", createdTimestamp=" + createdTimestamp
            + ", updatedTimestamp=" + updatedTimestamp
            + '}';
    }

    /**
     * Builder for Account.
     */
    public static final class Builder {
        private Long id = null;
        private String name;
        private String accountUrl;

        // Related
        private long contactCount = 0L;
        private long dealCount = 0L;

        // Timestamps
        private ZonedDateTime createdTimestamp = null;
        private ZonedDateTime updatedTimestamp = null;

        private Builder() {
        }

        public Builder withId(final Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAccountUrl(String accountUrl) {
            this.accountUrl = accountUrl;
            return this;
        }

        public Builder withContactCount(long contactCount) {
            this.contactCount = contactCount;
            return this;
        }

        public Builder withDealCount(long dealCount) {
            this.dealCount = dealCount;
            return this;
        }

        public Account build() {
            return new Account(id, name, accountUrl, contactCount, dealCount, createdTimestamp, updatedTimestamp, Collections.EMPTY_MAP);
        }
    }
}
