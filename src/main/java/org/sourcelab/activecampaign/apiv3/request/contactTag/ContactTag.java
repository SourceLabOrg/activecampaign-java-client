package org.sourcelab.activecampaign.apiv3.request.contactTag;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
@JsonRootName("contactTag")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactTag {
    private final Long contact;
    private final Long tag;

    @JsonCreator
    public ContactTag(
        @JsonProperty("contact") final Long contact,
        @JsonProperty("tag") final Long tag
    ) {
        this.contact = contact;
        this.tag = tag;
    }

    public Long getContact() {
        return contact;
    }

    public Long getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "ContactTag{"
            + "contact=" + contact
            + ", tag=" + tag
            + '}';
    }
}
