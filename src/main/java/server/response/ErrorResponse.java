package server.response;

/**
 * Response for errors
 */
public class ErrorResponse extends Response {

    /**
     * Constructor
     *
     * @param message The error message
     */
    public ErrorResponse(String message) {

        super();

        data.addProperty("response_type", "error");
        data.addProperty("error", message);

    }
}
