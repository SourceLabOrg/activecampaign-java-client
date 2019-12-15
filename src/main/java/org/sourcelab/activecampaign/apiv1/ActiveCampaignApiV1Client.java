package org.sourcelab.activecampaign.apiv1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.AbstractClient;
import org.sourcelab.activecampaign.apiv1.request.user.UsersMeApiV1Request;
import org.sourcelab.activecampaign.apiv1.response.user.UsersMeResponse;
import org.sourcelab.activecampaign.exception.InvalidCredentialsException;
import org.sourcelab.http.rest.RestResponse;

/**
 *
 */
public class ActiveCampaignApiV1Client extends AbstractClient {
    private static final Logger logger = LoggerFactory.getLogger(ActiveCampaignApiV1Client.class);

    /**
     * Constructor.
     *
     * @param apiConfig API Configuration properties.
     */
    public ActiveCampaignApiV1Client(final ApiV1Config apiConfig) {
        super(apiConfig);
    }

    /**
     * Retrieve the logged-in user
     * @return details about the currently logged in user.
     */
    public UsersMeResponse usersMe() {
        return submitRequest(new UsersMeApiV1Request());
    }

    @Override
    protected void validateResponseForInvalidCredentials(final RestResponse restResponse) throws InvalidCredentialsException {
        // Nothing to do.
    }
}
