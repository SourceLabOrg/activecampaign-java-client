package org.sourcelab.activecampaign.apiv3.request.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
@JsonRootName("tag")
public class TagCreateDto {
    private String tag;
    private String tagType;
    private String description;

   public TagCreateDto setTag(final String tag) {
        this.tag = tag;
        return this;
    }

    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    public TagCreateDto setTagType(final String tagType) {
        this.tagType = tagType;
        return this;
    }

    @JsonProperty("tagType")
    public String getTagType() {
        return tagType;
    }

    public TagCreateDto setDescription(final String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "TagCreateDto{"
            + "tag='" + tag + '\''
            + ", tagType='" + tagType + '\''
            + ", description='" + description + '\''
            + '}';
    }
}
