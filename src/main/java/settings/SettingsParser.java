package settings;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import server.Server;
import server.response.ErrorResponse;
import settings.exceptions.InvalidRequestTypeException;

public class SettingsParser {

    private JsonObject root;

    private RequestType requestType;

    public void parse(String data) {

        root = (new Gson()).fromJson(data, JsonObject.class);

        try {
            requestType = RequestType.createFromSettings(root.get("request_type").getAsString());
        } catch (InvalidRequestTypeException exception) {
            Server.getServer().send(new ErrorResponse(exception.getMessage()));
            return;
        }

    }

    /**
     * @return Request type
     */
    public RequestType getRequestType() {
        return requestType;
    }
}
