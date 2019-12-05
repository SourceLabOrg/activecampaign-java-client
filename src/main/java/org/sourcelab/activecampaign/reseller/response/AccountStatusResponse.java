package org.sourcelab.activecampaign.reseller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account Status Response.
 */
public class AccountStatusResponse {
    private final AccountStatus accountStatus;
    private final String accountStatusString;
    private final int resultCode;
    private final String resultMessage;

    @JsonCreator
    public AccountStatusResponse(
        @JsonProperty("status") final String accountStatusString,
        @JsonProperty("result_code") final int resultCode,
        @JsonProperty("result_message") final String resultMessage
    ) {
        this.accountStatus = AccountStatus.valueOf(accountStatusString.toUpperCase());
        this.accountStatusString = accountStatusString;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public String getAccountStatusString() {
        return accountStatusString;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    @Override
    public String toString() {
        return "AccountStatusResponse{"
            + "accountStatus=" + accountStatus
            + ", accountStatusString='" + accountStatusString + '\''
            + ", resultCode=" + resultCode
            + ", resultMessage='" + resultMessage + '\''
            + '}';
    }
}
