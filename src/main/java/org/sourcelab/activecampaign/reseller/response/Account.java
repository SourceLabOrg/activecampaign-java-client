package org.sourcelab.activecampaign.reseller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reseller Account.
 */
public class Account {
    private final String account;
    private final String cname;
    private final String planId;
    private final String clientName;
    private final String notification;
    private final int subscribers;
    private final int emailSent;
    private final String expire;
    private final boolean expired;
    private final String resellerStatus;
    private final boolean cancelled;
    private final boolean foreverFree;

    /**
     * Constructor.
     */
    @JsonCreator
    public Account(
        @JsonProperty("account") final String account,
        @JsonProperty("cname") final String cname,
        @JsonProperty("planid") final String planId,
        @JsonProperty("client_name") final String clientName,
        @JsonProperty("notification") final String notification,
        @JsonProperty("subscribers") final int subscribers,
        @JsonProperty("emails_sent") final int emailSent,
        @JsonProperty("expire") final String expire,
        @JsonProperty("expired") final boolean expired,
        @JsonProperty("reseller_status") final String resellerStatus,
        @JsonProperty("cancelled") final boolean cancelled,
        @JsonProperty("foreverfree") final boolean foreverFree
    ) {
        this.account = account;
        this.cname = cname;
        this.planId = planId;
        this.clientName = clientName;
        this.notification = notification;
        this.subscribers = subscribers;
        this.emailSent = emailSent;
        this.expire = expire;
        this.expired = expired;
        this.resellerStatus = resellerStatus;
        this.cancelled = cancelled;
        this.foreverFree = foreverFree;
    }

    public String getAccount() {
        return account;
    }

    public String getCname() {
        return cname;
    }

    public String getPlanId() {
        return planId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getNotification() {
        return notification;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public int getEmailSent() {
        return emailSent;
    }

    public String getExpire() {
        return expire;
    }

    public boolean isExpired() {
        return expired;
    }

    public String getResellerStatus() {
        return resellerStatus;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public boolean isForeverFree() {
        return foreverFree;
    }

    @Override
    public String toString() {
        return "Account{"
            + "account='" + account + '\''
            + ", cname='" + cname + '\''
            + ", planId='" + planId + '\''
            + ", clientName='" + clientName + '\''
            + ", notification='" + notification + '\''
            + ", subscribers=" + subscribers
            + ", emailSent=" + emailSent
            + ", expire='" + expire + '\''
            + ", expired=" + expired
            + ", resellerStatus='" + resellerStatus + '\''
            + ", cancelled=" + cancelled
            + ", foreverFree=" + foreverFree
            + '}';
    }
}
