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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.exception.InvalidCredentialsException;
import org.sourcelab.activecampaign.client.request.LoginRequest;
import org.sourcelab.activecampaign.client.request.account.AccountCreateRequest;
import org.sourcelab.activecampaign.client.request.account.AccountDeleteRequest;
import org.sourcelab.activecampaign.client.request.account.AccountListRequest;
import org.sourcelab.activecampaign.client.request.account.AccountRetrieveRequest;
import org.sourcelab.activecampaign.client.request.account.AccountUpdateRequest;
import org.sourcelab.activecampaign.client.response.account.Account;
import org.sourcelab.activecampaign.client.response.account.AccountListResponse;
import org.sourcelab.activecampaign.client.response.account.AccountResponse;

/**
 * ActiveCampaign API client.
 */
public class ActiveCampaignClient extends AbstractClient {
    private static final Logger logger = LoggerFactory.getLogger(ActiveCampaignClient.class);

    /**
     * Constructor.
     * @param apiConfig API Configuration properties.
     */
    public ActiveCampaignClient(final ApiConfig apiConfig) {
        super(apiConfig);
    }

    /**
     * Method to validate if the APi credentials provided are valid.
     *
     * @return true if the credentials are accepted, false if not.
     */
    public boolean loginTest() {
        try {
            return submitRequest(new LoginRequest());
        } catch (final InvalidCredentialsException exception) {
            return false;
        }
    }

    /**
     * Retrieve all existing accounts.
     * @return all accounts.
     */
    public AccountListResponse accountList() {
        return submitRequest(new AccountListRequest());
    }

    public AccountResponse accountsRetrieve(final Long id) {
        return submitRequest(new AccountRetrieveRequest(id));

    }

    /**
     * Create a new Account.
     * @param account the account to create.
     * @return Account create response.
     */
    public AccountResponse accountCreate(final Account account) {
        return submitRequest(new AccountCreateRequest(account));
    }

    /**
     * Update an existing account instance.
     * @param account defines the account to update.
     * @return Account update response.
     */
    public AccountResponse accountUpdate(final Account account) {
        return submitRequest(new AccountUpdateRequest(account));
    }

    /**
     * Update an existing account instance.
     * @param id defines the account to delete.
     * @return Account update response.
     */
    public boolean accountDelete(final long id) {
        return submitRequest(new AccountDeleteRequest(id));
    }

    /**
     * Update an existing account instance.
     * @param account defines the account to delete.
     * @return Account update response.
     */
    public boolean accountDelete(final Account account) {
        return submitRequest(new AccountDeleteRequest(account));
    }
}
