package org.sourcelab.activecampaign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.http.rest.configuration.BasicConfiguration;

/**
 * ActiveCampaign API Configuration class.
 */
public class ApiConfig extends BasicConfiguration<ApiConfig> {
    private static final Logger logger = LoggerFactory.getLogger(ApiConfig.class);

    private static String API_HOST_TEMPLATE = "https://%s.api-us1.com/api/3/";

    /**
     * Constructor.
     * @param accountName ActiveCampaign account name.
     */
    public ApiConfig(final String accountName) {
        super(
            String.format(API_HOST_TEMPLATE, accountName)
        );
    }

    /**
     * Configure ActiveCampaign API Token.
     * @param apiToken api token.
     * @return Configuration instance.
     */
    public ApiConfig withApiToken(final String apiToken) {
        withRequestHeader("Api-Token", apiToken);
        return this;
    }
}
