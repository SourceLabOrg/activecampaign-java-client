package org.sourcelab.activecampaign.apiv3.response.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class UsersMeResponse
{
    private final User user;

    @JsonCreator
    public UsersMeResponse(
        @JsonProperty("user") final User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UsersMeResponse{"
            + "user=" + user
            + '}';
    }
}
