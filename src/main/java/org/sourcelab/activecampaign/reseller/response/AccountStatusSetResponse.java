package org.sourcelab.activecampaign.reseller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account Status Set response.
 */
public class AccountStatusSetResponse {
    private final int resultCode;
    private final String resultMessage;

    public AccountStatusSetResponse(
        @JsonProperty("result_code") final int resultCode,
        @JsonProperty("result_message") final String resultMessage
    ) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public boolean isSuccess() {
        return getResultCode() == 1;
    }

    @Override
    public String toString() {
        return "AccountStatusSetResponse{"
            + "resultCode=" + resultCode
            + ", resultMessage='" + resultMessage + '\''
            + '}';
    }
}
