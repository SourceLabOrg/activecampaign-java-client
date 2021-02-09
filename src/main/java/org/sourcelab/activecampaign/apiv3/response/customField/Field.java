package org.sourcelab.activecampaign.apiv3.response.customField;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Field {
    private final Long id;
    private final String title;
    private final String description;
    private final String type;
    private final Boolean isRequired;
    private final String perstags;
    private final String defaultValue;

    // Related links
    private final Map<String, String> links;

    @JsonCreator
    public Field(
        @JsonProperty("id") final Long id,
        @JsonProperty("title") final String title,
        @JsonProperty("descript") final String description,
        @JsonProperty("type") final String type,
        @JsonProperty("isrequired") final String isRequired,
        @JsonProperty("perstags") final String perstags,
        @JsonProperty("defval")  final String defaultValue,
        @JsonProperty("links")  final Map<String,String> links
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.isRequired = "1".equals(isRequired);
        this.perstags = perstags;
        this.defaultValue = defaultValue;

        if (links == null) {
            this.links = Collections.emptyMap();
        } else {
            this.links = Collections.unmodifiableMap(new HashMap<>(links));
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public String getPerstags() {
        return perstags;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Field{"
            + "id=" + id
            + ", title='" + title + '\''
            + ", description='" + description + '\''
            + ", type='" + type + '\''
            + ", isRequired=" + isRequired
            + ", perstags='" + perstags + '\''
            + ", defaultValue='" + defaultValue + '\''
            + ", links=" + links
            + '}';
    }
}
