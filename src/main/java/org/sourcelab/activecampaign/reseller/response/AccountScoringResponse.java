package org.sourcelab.activecampaign.reseller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Account Scoring Response.
 */
public class AccountScoringResponse {
    private final int resultCode;
    private final String resultMessage;

    public AccountScoringResponse(
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
        return "AccountScoringResponse{"
            + "resultCode=" + resultCode
            + ", resultMessage='" + resultMessage + '\''
            + '}';
    }
}
