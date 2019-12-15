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

package org.sourcelab.activecampaign.reseller.request;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.reseller.response.AccountCancelResponse;

import java.io.IOException;

/**
 * Allows you to cancel an active account.
 */
public class AccountCancelRequest  extends AbstractRequest<AccountCancelRequest, AccountCancelResponse> {

    public AccountCancelRequest() {
        super("account_cancel");
    }

    public AccountCancelRequest withAccount(final String account) {
        return setParam("account", account);
    }

    public AccountCancelRequest withReason(final String reason) {
        return setParam("reason", reason);
    }

    public AccountCancelRequest withRetainData(final boolean shouldRetainData) {
        if (shouldRetainData) {
            return setParam("retaindata", "1");
        } else {
            return setParam("retaindata", "0");
        }
    }

    public AccountCancelRequest withRetainingData() {
        return withRetainData(true);
    }

    public AccountCancelRequest withDeletingData() {
        return withRetainData(false);
    }

    @Override
    public AccountCancelResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountCancelResponse.class);
    }
}

