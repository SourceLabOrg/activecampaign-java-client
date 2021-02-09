package org.sourcelab.activecampaign.apiv3.request.contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 */
public class ContactBuilder {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    private Map<Long, String> fields = new HashMap<>();

    public ContactBuilder withId(final long id) {
        this.id = id;
        return this;
    }

    public ContactBuilder withId(final String id) {
        return withId(Long.parseLong(id));
    }

    public ContactBuilder withEmail(final String email) {
        this.email = email;
        return this;
    }

    public ContactBuilder withFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder withLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactBuilder withPhone(final String phone) {
        this.phone = phone;
        return this;
    }

    public ContactBuilder withFields(final Map<Long, String> fields) {
        Objects.requireNonNull(fields);
        this.fields.putAll(fields);
        return this;
    }

    public ContactBuilder withField(final Long fieldId, final String value) {
        fields.put(fieldId, value);
        return this;
    }

    public Contact build() {
        final List<Contact.FieldValue> fieldValues = new ArrayList<>();
        fields.forEach((key, value) -> fieldValues.add(new Contact.FieldValue(key, value)));

        return new Contact(
            email,
            firstName,
            lastName,
            phone,
            fieldValues
        );
    }
}
