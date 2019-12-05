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

import org.sourcelab.activecampaign.reseller.request.AccountListRequest;
import org.sourcelab.activecampaign.reseller.request.AccountNameCheckRequest;
import org.sourcelab.activecampaign.reseller.request.AccountPlansRequest;
import org.sourcelab.activecampaign.reseller.request.AccountScoringRequest;
import org.sourcelab.activecampaign.reseller.request.AccountStatusRequest;
import org.sourcelab.activecampaign.reseller.request.AccountStatusSetRequest;
import org.sourcelab.activecampaign.reseller.response.AccountListResponse;
import org.sourcelab.activecampaign.reseller.response.AccountNameCheckResponse;
import org.sourcelab.activecampaign.reseller.response.AccountPlansResponse;
import org.sourcelab.activecampaign.reseller.response.AccountScoringResponse;
import org.sourcelab.activecampaign.reseller.response.AccountStatusResponse;
import org.sourcelab.activecampaign.reseller.response.AccountStatusSetResponse;

/**
 * Active Campaign Reseller API client.
 */
public class ActiveCampaignResellerClient extends AbstractClient {
    /**
     * Constructor.
     *
     * @param apiConfig API Configuration properties.
     */
    public ActiveCampaignResellerClient(final ResellerApiConfig apiConfig) {
        super(apiConfig);
    }

    /**
     * List all accounts under your reseller account.
     * @return List of accounts.
     */
    public AccountListResponse accountList(final AccountListRequest request) {
        return submitRequest(request);
    }

    /**
     * Check if the request account name is available.
     * @param account name of account to check.
     * @return Response.
     */
    public AccountNameCheckResponse accountNameCheck(final String account) {
        return submitRequest(new AccountNameCheckRequest(account));
    }

    public AccountPlansResponse accountPlans(final AccountPlansRequest request) {
        return submitRequest(request);
    }

    public AccountStatusResponse accountStatus(final String account) {
        return submitRequest(new AccountStatusRequest(account));
    }

    public AccountStatusSetResponse accountStatusSet(final AccountStatusSetRequest request) {
        return submitRequest(request);
    }

    public AccountScoringResponse accountScoring(final AccountScoringRequest request) {
        return submitRequest(request);
    }
}
