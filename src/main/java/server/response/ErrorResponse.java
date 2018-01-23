package server.response;

import com.google.gson.JsonObject;
import exception.CoreException;

/**
 * Response for errors
 */
public class ErrorResponse extends Response {

    /**
     * Constructor
     *
     * @param exception The exception to send to the front end
     */
    public ErrorResponse(CoreException exception) {

        super();

        data.addProperty("response_type", "error");

        // Build error object
        JsonObject error = new JsonObject();
        error.addProperty("message", exception.getMessage());
        error.addProperty("identifier", exception.getIdentifier());

        data.add("error", error);

    }
}
