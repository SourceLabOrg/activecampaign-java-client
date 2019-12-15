package org.sourcelab.activecampaign.apiv3.response.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Defines a user.
 */
public class User {
    private final long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String signature;

    // Related links
    private final Map<String, String> links;

    @JsonCreator
    public User(
        @JsonProperty("id") final long id,
        @JsonProperty("username") final String username,
        @JsonProperty("firstname") final String firstName,
        @JsonProperty("lastname") final String lastName,
        @JsonProperty("email") final String email,
        @JsonProperty("phone") final String phone,
        @JsonProperty("signature") final String signature,
        @JsonProperty("links") final Map<String, String> links) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.signature = signature;

        if (links == null) {
            this.links = Collections.emptyMap();
        } else {
            this.links = Collections.unmodifiableMap(new HashMap<>(links));
        }
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSignature() {
        return signature;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "User{"
            + "id=" + id
            + ", username='" + username + '\''
            + ", firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", email='" + email + '\''
            + ", phone='" + phone + '\''
            + ", signature='" + signature + '\''
            + '}';
    }
}
