/**
 * Copyright 2019 SourceLab.org https://github.com/SourceLabOrg/activecampaign-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.sourcelab.activecampaign;

import org.sourcelab.http.rest.configuration.BasicConfiguration;
import org.sourcelab.http.rest.interceptor.RequestContext;
import org.sourcelab.http.rest.interceptor.RequestInterceptor;
import org.sourcelab.http.rest.request.RequestParameter;

import java.util.List;

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
            public List<RequestParameter> modifyRequestParameters(
                final List<RequestParameter> requestParameters,
                final RequestContext requestContext
            ) {
                requestParameters.add(new RequestParameter("api_key", apiToken));
                requestParameters.add(new RequestParameter("api_output", "json"));

                return requestParameters;
            }
        });
    }
}
