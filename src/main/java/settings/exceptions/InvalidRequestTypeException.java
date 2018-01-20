package settings.exceptions;

/**
 * Exception for when an invalid request type is found in the json
 */
public class InvalidRequestTypeException extends Exception {

    /**
     * Constructor
     *
     * @param request Request found in json
     */
    public InvalidRequestTypeException(String request) {
        super("Invalid request found in json. Found: " + request);
    }
}
