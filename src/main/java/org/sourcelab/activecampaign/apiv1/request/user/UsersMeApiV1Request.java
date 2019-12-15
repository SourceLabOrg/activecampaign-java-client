package org.sourcelab.activecampaign.apiv1.request.user;

import org.sourcelab.activecampaign.apiv1.response.user.UsersMeResponse;
import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.http.rest.request.GetRequest;
import org.sourcelab.http.rest.request.body.RequestBodyContent;
import org.sourcelab.http.rest.request.body.UrlEncodedFormBodyContent;

import java.io.IOException;

/**
 * Returns information about the current API user.
 */
public class UsersMeApiV1Request implements GetRequest<UsersMeResponse> {

    @Override
    public String getApiEndpoint() {
        return "admin/api.php";
    }

    @Override
    public RequestBodyContent getRequestBody() {
        return new UrlEncodedFormBodyContent()
            .addParameter("api_action", "user_me");
    }

    @Override
    public UsersMeResponse parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, UsersMeResponse.class);
    }
}
