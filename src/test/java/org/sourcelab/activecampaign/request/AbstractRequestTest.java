package org.sourcelab.activecampaign.request;

import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

/**
 *
 */
public class AbstractRequestTest {
    /**
     * Utility method to help load mock responses from resources.
     * @param fileName file name to load from resources
     * @return The contents of the file, as a UTF-8 string.
     * @throws IOException on error reading from resource file.
     */
    public String readFile(final String fileName) throws IOException {
        final URL inputFile = getClass().getClassLoader().getResource("mockResponses/" + fileName);
        return IOUtils.toString(inputFile, Charsets.UTF_8);
    }
}
