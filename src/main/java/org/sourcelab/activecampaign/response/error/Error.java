package org.sourcelab.activecampaign.response.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class Error {
    private final String title;
    private final String detail;
    private final String code;
    private final Source source;

    @JsonCreator
    public Error(
        @JsonProperty("title") final String title,
        @JsonProperty("detail") final String detail,
        @JsonProperty("code") final String code,
        @JsonProperty("source") final Source source
    ) {
        this.title = title;
        this.detail = detail;
        this.code = code;
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getCode() {
        return code;
    }

    public Source getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "Error{"
            + "title='" + title + '\''
            + ", detail='" + detail + '\''
            + ", code='" + code + '\''
            + ", source=" + source
            + '}';
    }
}
