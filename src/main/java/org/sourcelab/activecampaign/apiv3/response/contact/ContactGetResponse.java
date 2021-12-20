/**
 * Copyright 2021 Unicornify https://github.com/unicornify/activecampaign-java-client
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

package org.sourcelab.activecampaign.apiv3.response.contact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.sourcelab.activecampaign.apiv3.request.contact.Contact;
import org.sourcelab.activecampaign.apiv3.request.contact.ContactBuilder;

import java.util.List;
import java.util.Map;

/**
 * Represents the API response from updating a Contact.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactGetResponse {
    private final Contact contact;

    /**
     * Constructor.
     */
    @JsonCreator
    public ContactGetResponse(
            @JsonProperty("fieldValues") final List<Contact.FieldValue> fieldValues,
            @JsonProperty("contact") final Map<String, Object> contactValues
    ) {
        // Build contact
        final ContactBuilder builder = Contact.newBuilder()
                .withPhone((String) contactValues.get("phone"))
                .withFirstName((String) contactValues.get("firstName"))
                .withLastName((String) contactValues.get("lastName"))
                .withEmail((String) contactValues.get("email"))
                .withId((String) contactValues.get("id"));

        fieldValues.forEach((fieldValue) -> builder.withField(fieldValue.getField(), fieldValue.getValue()));

        this.contact = builder.build();
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "ContactCreateResponse{"
                + ", contact=" + contact
                + '}';
    }
}
