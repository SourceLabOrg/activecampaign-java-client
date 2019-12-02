package org.sourcelab.activecampaign.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcelab.http.rest.exceptions.InvalidRequestException;

/**
 * Thrown if the API credentials for ActiveCampaign account are not valid.
 */
public class InvalidCredentialsException extends InvalidRequestException {
    private static final Logger logger = LoggerFactory.getLogger(InvalidCredentialsException.class);

    public InvalidCredentialsException(final String message, final int errorCode) {
        super(message, errorCode);
    }

    public InvalidCredentialsException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
