package org.sourcelab.activecampaign.exception;

import org.sourcelab.activecampaign.response.error.RequestErrorResponse;
import org.sourcelab.http.rest.exceptions.InvalidRequestException;

/**
 * Thrown when the API returns an error.
 */
public class ApiErrorException extends InvalidRequestException {
    private final RequestErrorResponse errorResponse;

    public ApiErrorException(final String message, final int errorCode) {
        super("", errorCode);
        throw new RuntimeException("Not implemented");
    }

    public ApiErrorException (final RequestErrorResponse requestErrorResponse) {
        super(requestErrorResponse.toString(), 422);
        this.errorResponse = requestErrorResponse;
    }

    public RequestErrorResponse getErrorResponse() {
        return errorResponse;
    }

    @Override
    public String toString() {
        return "ApiErrorException{"
            + "errorResponse=" + errorResponse
            + '}';
    }
}
