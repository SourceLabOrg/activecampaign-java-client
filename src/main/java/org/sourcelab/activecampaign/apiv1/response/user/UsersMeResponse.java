package org.sourcelab.activecampaign.apiv1.response.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the response from a UsersMe request.
 */
public class UsersMeResponse {
    private final long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String apiKey;
    private final String apiUrl;

    @JsonCreator
    public UsersMeResponse(
        @JsonProperty("id") final long id,
        @JsonProperty("username") final String username,
        @JsonProperty("first_name") final String firstName,
        @JsonProperty("last_name") final String lastName,
        @JsonProperty("email") final String email,
        @JsonProperty("apikey") final String apiKey,
        @JsonProperty("apiurl") final String apiUrl) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
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

    public String getApiKey() {
        return apiKey;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    @Override
    public String toString() {
        return "UsersMeResponse{"
            + "id=" + id
            + ", username='" + username + '\''
            + ", firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", email='" + email + '\''
            + ", apiKey='" + apiKey + '\''
            + ", apiUrl='" + apiUrl + '\''
            + '}';
    }
}
