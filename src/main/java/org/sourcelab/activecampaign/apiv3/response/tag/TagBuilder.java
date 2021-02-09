package org.sourcelab.activecampaign.apiv3.response.tag;

import java.util.HashMap;

/**
 *
 */
public final class TagBuilder {
    private Long id;
    private String tagType;
    private String tag;
    private String description;

    public TagBuilder() {
    }

    public TagBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public TagBuilder withTagType(String tagType) {
        this.tagType = tagType;
        return this;
    }

    public TagBuilder withTag(String tag) {
        this.tag = tag;
        return this;
    }

    public TagBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Tag build() {
        return new Tag(id, tagType, tag, description, new HashMap<>());
    }
}
