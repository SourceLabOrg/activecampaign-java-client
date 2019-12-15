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
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.apiv1.ActiveCampaignApiV1Client;
import org.sourcelab.activecampaign.apiv1.ApiV1Config;
import org.sourcelab.activecampaign.apiv3.ActiveCampaignClient;
import org.sourcelab.activecampaign.apiv3.ApiConfig;
import org.sourcelab.activecampaign.apiv3.response.account.Account;
import org.sourcelab.activecampaign.apiv3.response.account.AccountListResponse;
import org.sourcelab.activecampaign.apiv3.response.account.AccountResponse;
import org.sourcelab.activecampaign.apiv3.response.user.UsersMeResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test of client API.
 */
@Tag("IntegrationTest")
class ActiveCampaignClientTest {
    private static final Logger logger = LoggerFactory.getLogger(ActiveCampaignClientTest.class);

    private static ActiveCampaignClient apiV3Client = null;

    @BeforeAll
    static void setup() throws IOException {
        final InputStream inputStream = ActiveCampaignClientTest.class.getClassLoader().getResourceAsStream("test_credentials.properties");

        // Load properties
        final Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        final String activeCampaignAccountName = properties.getProperty("account_name");
        final String activeCampaignApiToken = properties.getProperty("api_token");

        if ((activeCampaignAccountName == null || activeCampaignApiToken == null)) {
            throw new RuntimeException(
                "To run the integration tests you must create a resource file named test_credentials.properties which contains the properties:\n"
                + " account_name \n"
                + " api_token\n\n"
            );
        }

        /**
         * Set during class bootstrap.
         */
        ApiConfig apiConfig = new ApiConfig(activeCampaignAccountName, activeCampaignApiToken);
        apiV3Client = new ActiveCampaignClient(apiConfig);
    }

    /**
     * Cleanup.
     */
    @AfterAll
    static void tearDown() {
        if (apiV3Client != null) {
            apiV3Client.close();
            apiV3Client = null;
        }
    }

    /**
     * Smoke tests our API configuration is valid.
     */
    @Test
    void smokeTest() {
        final boolean isLoginValid = apiV3Client.loginTest();
        assertTrue(isLoginValid, "Response should be true.");
    }

    /**
     * Smoke test about me end point.
     */
    @Test
    void testAboutMe() {
        final UsersMeResponse response = apiV3Client.usersMe();
        logger.info("V3: {}", response);
        assertNotNull(response);
    }

    /**
     * Tests the accounts resource api end points.
     */
    @Test
    void testAccountsResource() {
        // Create a test account.
        final Account accountToCreate = Account.newBuilder()
            .withName("My Account Name " + System.currentTimeMillis())
            .withName("My Account Name 1575283515866")
            .withAccountUrl("https://www.test.com/blah")
            .build();

        // Make api request to create the account
        final AccountResponse resp = apiV3Client.accountCreate(accountToCreate);
        assertNotNull(resp);
        assertNotNull(resp.getAccount());
        assertNotNull(resp.getAccount().getId());

        final AccountListResponse response = apiV3Client.accountList();
        //logger.info("{}", response);

        final Optional<Account> createdAccountOptional = response.getAccounts()
            .stream()
            .filter((foundAccount) -> foundAccount.getName().equals(accountToCreate.getName()))
            .findFirst();
        assertTrue(createdAccountOptional.isPresent(), "Failed to find our test account " + accountToCreate.getName());
        Account createdAccount = createdAccountOptional.get();

        // Validate basic account fields
        assertNotNull(createdAccount.getId());
        assertEquals(accountToCreate.getName(), createdAccount.getName());
        assertEquals(accountToCreate.getAccountUrl(), createdAccount.getAccountUrl());

        // Re-retrieve
        createdAccount = apiV3Client.accountsRetrieve(createdAccount.getId()).getAccount();

        // Validate basic account fields
        assertNotNull(createdAccount.getId());
        assertEquals(accountToCreate.getName(), createdAccount.getName());
        assertEquals(accountToCreate.getAccountUrl(), createdAccount.getAccountUrl());

        // TODO test sideloading?

        // Attempt to update account
        final String updatedName = "My Updated Name " + System.currentTimeMillis();
        final Account toUpdateAccount = createdAccount
            .toBuilder()
            .withName(updatedName)
            .build();
        final Account updatedAccount = apiV3Client.accountUpdate(toUpdateAccount).getAccount();

        // Validate it was updated.
        assertEquals(createdAccount.getId(), updatedAccount.getId());
        assertEquals(updatedName, updatedAccount.getName());
        assertEquals(createdAccount.getAccountUrl(), updatedAccount.getAccountUrl());

        // Attempt to delete account.
        final boolean deleteResult = apiV3Client.accountDelete(updatedAccount);
        assertTrue(deleteResult);
    }

}