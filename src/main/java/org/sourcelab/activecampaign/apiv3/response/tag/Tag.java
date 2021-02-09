package org.sourcelab.activecampaign.apiv3.response.tag;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("tag")
public class Tag {
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    private final Long id;
    private final String tagType;
    private final String tag;
    private final String description;
    private final Map<String, String> links;

    public static TagBuilder newBuilder() {
        return new TagBuilder();
    }

    @JsonCreator
    public Tag(
        @JsonProperty("id") final Long id,
        @JsonProperty("tagType") final String tagType,
        @JsonProperty("tag") final String tag,
        @JsonProperty("description") final String description,
        @JsonProperty("links") final Map<String, String> links
    ) {

        this.id = id;
        this.tagType = tagType;
        this.tag = tag;
        this.description = description;
        if (links == null) {
            this.links = Collections.emptyMap();
        } else {
            this.links = Collections.unmodifiableMap(new HashMap<>(links));
        }
    }

    public Long getId() {
        return id;
    }

    public String getTagType() {
        return tagType;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Tag{"
            + "id=" + id
            + ", tagType='" + tagType + '\''
            + ", tag'" + tag + '\''
            + ", description='" + description + '\''
            + ", links=" + links
            + '}';
    }
}
