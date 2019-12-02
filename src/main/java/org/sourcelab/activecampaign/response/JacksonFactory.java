package org.sourcelab.activecampaign.response;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Map;

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
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
    }

    /**
     * Creates properly configured Jackson Object Mapper instances.
     * @return ObjectMapper instance.
     */
    public static ObjectMapper newInstance() {
        return mapper;
    }
}