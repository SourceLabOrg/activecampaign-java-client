package org.sourcelab.activecampaign;

import org.sourcelab.http.rest.configuration.BasicConfiguration;
import org.sourcelab.http.rest.interceptor.RequestContext;
import org.sourcelab.http.rest.interceptor.RequestInterceptor;

import java.util.Map;

/**
 * Reseller API configuration.
 */
public class ResellerApiConfig extends BasicConfiguration<ApiConfig> {

    private static final String DEFAULT_API_HOST = "https://www.activecampaign.com/api.php";
    private final String apiToken;

    /**
     * Constructor.
     * @param apiToken ActiveCampaign Reseller API token.
     */
    public ResellerApiConfig(final String apiToken) {
        super(DEFAULT_API_HOST);
        this.apiToken = apiToken;

        useRequestInteceptor(new RequestInterceptor() {
            @Override
            public void modifyRequestParameters(final Map<String, String> requestParameters, final RequestContext requestContext) {
                requestParameters.put("api_key", apiToken);
                requestParameters.put("api_output", "json");
            }
        });
    }

    public String getApiToken() {
        return apiToken;
    }
}
