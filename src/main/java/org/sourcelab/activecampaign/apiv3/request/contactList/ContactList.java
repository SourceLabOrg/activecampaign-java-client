package org.sourcelab.activecampaign.apiv3.request.contactList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *
 */
@JsonRootName("contactList")
public class ContactList {
    @JsonProperty("contact")
    private final long contactId;

    @JsonProperty("list")
    private final long listId;

    @JsonProperty("status")
    private final int status;

    @JsonCreator
    public ContactList(
        @JsonProperty("contact") final long contactId,
        @JsonProperty("list") final long listId,
        @JsonProperty("status") final boolean subscribe) {
        this.contactId = contactId;
        this.listId = listId;
        this.status = subscribe ? 1 : 2;
    }

    public long getContactId() {
        return contactId;
    }

    public long getListId() {
        return listId;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ContactList{"
            + "contactId=" + contactId
            + ", listId='" + listId + '\''
            + ", status=" + status
            + '}';
    }
}
