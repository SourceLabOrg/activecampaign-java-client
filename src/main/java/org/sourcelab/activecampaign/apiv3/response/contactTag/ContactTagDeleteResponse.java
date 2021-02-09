package org.sourcelab.activecampaign.apiv3.response.contactTag;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 *
 */
public class ContactTagDeleteResponse {
    private final Long id;
    private final Long contactId;
    private final Long tagId;
    private Map<String, String> links;

    @JsonCreator
    public ContactTagDeleteResponse(
        @JsonProperty("id") final Long id,
        @JsonProperty("contact") final Long contactId,
        @JsonProperty("tag") final Long tagId,
        @JsonProperty("links") final Map<String, String> links) {
        this.id = id;
        this.contactId = contactId;
        this.tagId = tagId;
        this.links = links;
    }

    public Long getId() {
        return id;
    }

    public Long getContactId() {
        return contactId;
    }

    public Long getTagId() {
        return tagId;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "ContactTagCreateResponse{"
            + "id=" + id
            + ", contactId=" + contactId
            + ", tagId=" + tagId
            + ", links=" + links
            + '}';
    }
}
