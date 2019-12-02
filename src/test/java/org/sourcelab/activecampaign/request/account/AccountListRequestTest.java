package org.sourcelab.activecampaign.request.account;

import org.junit.jupiter.api.Test;
import org.sourcelab.activecampaign.request.AbstractRequestTest;
import org.sourcelab.activecampaign.response.account.Account;
import org.sourcelab.activecampaign.response.account.AccountListResponse;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountListRequestTest extends AbstractRequestTest {

    /**
     * Test parsing a mocked response.
     */
    @Test
    void testParsingResponse() throws IOException {
        final String input = readFile("accountsList.json");
        final AccountListResponse parsed = new AccountListRequest()
            .parseResponse(input);

        // Validate accounts
        assertEquals(1, parsed.getAccounts().size(), "Should have a single account");

        final Account account = parsed.getAccounts().get(0);
        assertEquals(1L, account.getId());
        assertEquals("My Account Name 1575283515866", account.getName());
        assertEquals("https://www.test.com/blah", account.getAccountUrl());
        assertEquals(0L, account.getDealCount());
        assertEquals(0L, account.getContactCount());

        // 2019-12-02T04:45:17-06:00
        assertNotNull(account.getCreatedTimestamp());
        assertEquals(ZonedDateTime.parse("2019-12-02T04:45:17-06:00"), account.getCreatedTimestamp());

        // 2019-03-02T04:55:22-06:00
        assertNotNull(account.getUpdatedTimestamp());
        assertEquals(ZonedDateTime.parse("2019-03-02T04:55:22-06:00"), account.getUpdatedTimestamp());

        // Validate links
        assertEquals(5,account.getLinks().size());
        assertEquals("https://accountName.api-us1.com/api/3/accounts/1/notes", account.getLinks().get("notes"));
        assertEquals("https://accountName.api-us1.com/api/3/accounts/1/accountCustomFieldData", account.getLinks().get("accountCustomFieldData"));
        assertEquals("https://accountName.api-us1.com/api/3/accounts/1/accountContacts", account.getLinks().get("accountContacts"));
        assertEquals("https://accountName.api-us1.com/api/3/accounts/1/emailActivities", account.getLinks().get("emailActivities"));
        assertEquals("https://accountName.api-us1.com/api/3/accounts/1/contactEmails", account.getLinks().get("contactEmails"));

        // Validate meta
        assertEquals(1, parsed.getMeta().getTotal(), "Should have a single result");
    }
}