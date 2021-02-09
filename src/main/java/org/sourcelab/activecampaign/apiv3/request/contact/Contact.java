package org.sourcelab.activecampaign.apiv3.request.contact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.activecampaign.apiv3.response.customField.Field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@JsonRootName(value = "contact")
public class Contact {
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final List<FieldValue> fieldValues;

    public static ContactBuilder newBuilder() {
        return new ContactBuilder();
    }

    @JsonCreator
    public Contact(
        @JsonProperty("email") final String email,
        @JsonProperty("firstName") final String firstName,
        @JsonProperty("lastName") final String lastName,
        @JsonProperty("phone") final String phone,
        final List<FieldValue> fieldValues
    ) {
        
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        if (fieldValues == null) {
            this.fieldValues = Collections.emptyList();
        } else {
            this.fieldValues = Collections.unmodifiableList(new ArrayList<>(fieldValues));
        }
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public List<FieldValue> getFieldValues() {
        return fieldValues;
    }

    @Override
    public String toString() {
        return "Contact{"
            + "email='" + email + '\''
            + ", firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", phone='" + phone + '\''
            + ", fieldValues=" + fieldValues
            + '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FieldValue {
        private final long field;
        private final String value;

        @JsonCreator
        public FieldValue(
            @JsonProperty("field") final long field,
            @JsonProperty("value") final String value
        ) {
            this.field = field;
            this.value = value;
        }

        public long getField() {
            return field;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "FieldValue{"
                + "field=" + field
                + ", value='" + value + '\''
                + '}';
        }
    }
}
