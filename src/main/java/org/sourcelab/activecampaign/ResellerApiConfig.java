package org.sourcelab.activecampaign;

import org.sourcelab.http.rest.configuration.BasicConfiguration;

/**
 * Reseller API configuration.
 */
public class ResellerApiConfig extends BasicConfiguration<ApiConfig> {

    private static String DEFAULT_API_HOST = "https://www.activecampaign.com";
    private final String apiToken;

    /**
     * Constructor.
     * @param apiToken ActiveCampaign Reseller API token.
     */
    public ResellerApiConfig(final String apiToken) {
        super(DEFAULT_API_HOST);
        this.apiToken = apiToken;
    }

    public String getApiToken() {
        return apiToken;
    }
}
