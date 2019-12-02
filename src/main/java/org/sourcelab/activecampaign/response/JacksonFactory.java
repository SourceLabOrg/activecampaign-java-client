package org.sourcelab.activecampaign.response;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Map;

import static com.fasterxml.jackson.databind.DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;

/**
 * Creates properly configured Jackson Json Mapper instances.
 */
public final class JacksonFactory {

    /**
     * Holds our jackson singleton mapper.  ObjectMapper is defined as being
     * ThreadSafe so this should be OK to stash as a static and shared.
     */
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Defines a "type safe" Map[String, String] deserialization type for Jackson.
     */
    public static final MapType mapTypeStringString = mapper.getTypeFactory()
        .constructMapType(Map.class, String.class, String.class);

    /*
     * Statically configure the instance.
     */
    static {
        // Configure mapper
        mapper
            .enable(SerializationFeature.WRAP_ROOT_VALUE)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)

            // Deserialize empty array to null
            .enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)

            // Deserialize into Jdk8 ZonedDateTime
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            // Dont adjust to local timezone.
            .disable(ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
    }

    /**
     * Creates properly configured Jackson Object Mapper instances.
     * @return ObjectMapper instance.
     */
    public static ObjectMapper newInstance() {
        return mapper;
    }
}