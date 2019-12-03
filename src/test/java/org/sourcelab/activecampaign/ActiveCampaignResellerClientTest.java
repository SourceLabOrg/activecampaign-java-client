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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test of Reseller API.
 */
@Tag("IntegrationTest")
class ActiveCampaignResellerClientTest {
    private static final Logger logger = LoggerFactory.getLogger(ActiveCampaignClientTest.class);

    /**
     * Set during class bootstrap.
     */
    private static ResellerApiConfig apiConfig = null;
    private static ActiveCampaignResellerClient apiClient = null;

    @BeforeAll
    static void setup() throws IOException {
        final InputStream inputStream = ActiveCampaignClientTest.class.getClassLoader().getResourceAsStream("test_reseller_credentials.properties");

        // Load properties
        final Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        final String resellerApiToken = properties.getProperty("api_token");

        if (resellerApiToken == null) {
            throw new RuntimeException(
                "To run the integration tests you must create a resource file named test_reseller_credentials.properties which contains the properties:\n"
                    + " api_token\n\n"
            );
        }

        apiConfig = new ResellerApiConfig(resellerApiToken);
        apiClient = new ActiveCampaignResellerClient(apiConfig);
    }

    /**
     * Cleanup.
     */
    @AfterAll
    static void tearDown() {
        if (apiClient != null) {
            apiClient.close();
            apiClient = null;
        }
    }

}