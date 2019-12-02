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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test.
 */
class ActiveCampaignClientTest {
    private static final Logger logger = LoggerFactory.getLogger(ActiveCampaignClientTest.class);

    /**
     * Set during class bootstrap.
     */
    private static ApiConfig apiConfig = null;
    private static ActiveCampaignClient apiClient = null;

    @BeforeAll
    static void setup() throws IOException {
        final InputStream inputStream = ActiveCampaignClientTest.class.getClassLoader().getResourceAsStream("test_credentials.properties");

        // Load properties
        final Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        final String activeCampaignAccountName = properties.getProperty("account_name");
        final String activeCampaignApiToken = properties.getProperty("api_token");

        if (activeCampaignAccountName == null || activeCampaignApiToken == null) {
            throw new RuntimeException(
                "To run the integration tests you must create a resource file named test_credentials.properties which contains the properties:\n"
                + " account_name \n"
                + " api_token\n\n"
            );
        }

        apiConfig = new ApiConfig(activeCampaignAccountName)
            .withApiToken(activeCampaignApiToken);
        apiClient = new ActiveCampaignClient(apiConfig);
    }

    /**
     * Smoke tests our API configuration is valid.
     */
    @Test
    void smokeTest() {
        final boolean isLoginValid = apiClient.loginTest();
        assertTrue(isLoginValid, "Response should be true.");
    }

}