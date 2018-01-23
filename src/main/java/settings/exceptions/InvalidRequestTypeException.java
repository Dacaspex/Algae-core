package settings.exceptions;

import exception.CoreException;

/**
 * Exception for when an invalid request type is found in the json
 */
public class InvalidRequestTypeException extends CoreException {

    private static final String identifier = "invalid.request.type";

    /**
     * Constructor
     *
     * @param request Request found in json
     */
    public InvalidRequestTypeException(String request) {
        super("Invalid request found in json. Found: " + request, identifier);
    }
}
