package org.sourcelab.activecampaign.apiv3.response.contact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.apiv3.request.contact.Contact;
import org.sourcelab.activecampaign.apiv3.request.contact.ContactBuilder;

import java.util.List;
import java.util.Map;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactCreateResponse {
    private final Contact contact;

    @JsonCreator
    public ContactCreateResponse(
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
