package org.sourcelab.activecampaign.request.account;

import org.junit.jupiter.api.Test;
import org.sourcelab.activecampaign.request.AbstractRequestTest;
import org.sourcelab.activecampaign.response.account.Account;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountRetrieveRequestTest extends AbstractRequestTest {
    /**
     * Test parsing a mocked response.
     */
    @Test
    void testParsingResponse() throws IOException {
        final String input = readFile("accountsRetrieve.json");
        final Account account = new AccountRetrieveRequest(1L)
            .parseResponse(input)
            .getAccount();

        assertEquals(1L, account.getId());
        assertEquals("Example Account", account.getName());
        assertEquals("https://www.example.com", account.getAccountUrl());
        assertEquals(0L, account.getDealCount());
        assertEquals(0L, account.getContactCount());

        // 2019-12-02T04:45:17-06:00
        assertNotNull(account.getCreatedTimestamp());
        assertEquals(ZonedDateTime.parse("2019-05-15T15:58:16-05:00"), account.getCreatedTimestamp());

        // 2019-03-02T04:55:22-06:00
        assertNotNull(account.getUpdatedTimestamp());
        assertEquals(ZonedDateTime.parse("2019-05-15T15:58:16-05:00"), account.getUpdatedTimestamp());

        // Validate links
        assertEquals(0,account.getLinks().size());
    }
}