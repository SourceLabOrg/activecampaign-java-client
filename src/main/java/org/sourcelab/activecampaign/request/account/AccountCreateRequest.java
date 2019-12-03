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

package org.sourcelab.activecampaign.request.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.response.JacksonFactory;
import org.sourcelab.activecampaign.response.account.Account;
import org.sourcelab.activecampaign.response.account.AccountResponse;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;

import java.io.IOException;
import java.util.Objects;

/**
 * Represents an account create request.
 */
public class AccountCreateRequest implements Request<AccountResponse> {
    private final Account account;

    /**
     * Constructor.
     * @param account The account instance to create.
     */
    public AccountCreateRequest(final Account account) {
        Objects.requireNonNull(account);
        this.account = account;
    }

    @Override
    public String getApiEndpoint() {
        return "accounts";
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public Object getRequestBody() {
        try {
            return JacksonFactory.newInstance().writeValueAsString(account);
        } catch (final JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public AccountResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountResponse.class);
    }
}
