package org.sourcelab.activecampaign.reseller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class AccountNameCheckResponse {
    private final int resultCode;
    private final String resultMessage;

    @JsonCreator
    public AccountNameCheckResponse(
        @JsonProperty("result_code") final int resultCode,
        @JsonProperty("result_message") final String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public boolean isAvailable() {
        return !getResultMessage().toLowerCase().contains("taken");
    }

    public boolean isTaken() {
        return !isAvailable();
    }

    public String getResultMessage() {
        return resultMessage;
    }

    @Override
    public String toString() {
        return "AccountNameCheckResponse{"
            + "resultCode=" + resultCode
            + ", resultMessage='" + resultMessage + '\''
            + '}';
    }
}
