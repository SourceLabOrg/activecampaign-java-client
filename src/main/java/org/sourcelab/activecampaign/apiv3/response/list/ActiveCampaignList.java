package org.sourcelab.activecampaign.apiv3.response.list;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActiveCampaignList {
    private final String stringId;
    private final String name;
    private final Long id;

    @JsonCreator
    public ActiveCampaignList(
        @JsonProperty("stringId") final String stringId,
        @JsonProperty("name") final String name,
        @JsonProperty("id") final Long id) {
        this.stringId = stringId;
        this.name = name;
        this.id = id;
    }

    public String getStringId() {
        return stringId;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ActiveCampaignList{"
            + "stringId='" + stringId + '\''
            + ", name='" + name + '\''
            + ", id=" + id
            + '}';
    }
}
