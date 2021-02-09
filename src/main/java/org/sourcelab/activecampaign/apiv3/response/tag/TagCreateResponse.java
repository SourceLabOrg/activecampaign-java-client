package org.sourcelab.activecampaign.apiv3.response.tag;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.sourcelab.activecampaign.apiv3.request.contact.Contact;
import org.sourcelab.activecampaign.apiv3.request.contact.ContactBuilder;

import java.util.List;
import java.util.Map;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagCreateResponse {
    private final Tag tag;

    @JsonCreator
    public TagCreateResponse(
        @JsonProperty("tag") final Tag tag
    ) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "TagCreateResponse{"
            + "tag=" + tag
            + '}';
    }
}
