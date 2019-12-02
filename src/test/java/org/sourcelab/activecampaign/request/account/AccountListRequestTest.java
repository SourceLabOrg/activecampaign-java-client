package org.sourcelab.activecampaign.request.account;

import org.junit.jupiter.api.Test;
import org.sourcelab.activecampaign.response.account.AccountListResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AccountListRequestTest {

    @Test
    void testParsingResponse() throws IOException {
        final String input = "{\n" +
            "\t\"accounts\": [{\n" +
            "\t\t\"name\": \"My Account Name 1575283515866\",\n" +
            "\t\t\"accountUrl\": \"https:\\/\\/www.test.com\\/blah\",\n" +
            "\t\t\"createdTimestamp\": \"2019-12-02T04:45:17-06:00\",\n" +
            "\t\t\"updatedTimestamp\": \"2019-12-02T04:45:17-06:00\",\n" +
            "\t\t\"contactCount\": \"0\",\n" +
            "\t\t\"dealCount\": \"0\",\n" +
            "\t\t\"links\": {\n" +
            "\t\t\t\"notes\": \"https:\\/\\/spowis.api-us1.com\\/api\\/3\\/accounts\\/1\\/notes\",\n" +
            "\t\t\t\"accountCustomFieldData\": \"https:\\/\\/spowis.api-us1.com\\/api\\/3\\/accounts\\/1\\/accountCustomFieldData\",\n" +
            "\t\t\t\"accountContacts\": \"https:\\/\\/spowis.api-us1.com\\/api\\/3\\/accounts\\/1\\/accountContacts\",\n" +
            "\t\t\t\"emailActivities\": \"https:\\/\\/spowis.api-us1.com\\/api\\/3\\/accounts\\/1\\/emailActivities\",\n" +
            "\t\t\t\"contactEmails\": \"https:\\/\\/spowis.api-us1.com\\/api\\/3\\/accounts\\/1\\/contactEmails\"\n" +
            "\t\t},\n" +
            "\t\t\"id\": \"1\"\n" +
            "\t}],\n" +
            "\t\"meta\": {\n" +
            "\t\t\"total\": \"1\"\n" +
            "\t}\n" +
            "}";

        final AccountListResponse parsed = new AccountListRequest()
            .parseResponse(input);

        throw new RuntimeException("write this test");
    }
}