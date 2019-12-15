package org.sourcelab.activecampaign.apiv3.request.user;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.apiv3.response.user.UsersMeResponse;
import org.sourcelab.http.rest.request.GetRequest;

import java.io.IOException;

/**
 * Returns information about the current API user.
 */
public class UsersMeRequest implements GetRequest<UsersMeResponse> {

    @Override
    public String getApiEndpoint() {
        return "api/3/users/me";
    }

    @Override
    public UsersMeResponse parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, UsersMeResponse.class);
    }
}
