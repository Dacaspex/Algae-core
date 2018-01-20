package server.response;

import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Response {

    protected JsonObject data;

    public Response() {

        data = new JsonObject();

        data.addProperty(
                "response_time",
                new SimpleDateFormat("HH:mm:ss.SSS").format(Calendar.getInstance().getTime())
        );

    }

    public Response addProperty(String property, String value) {
        data.addProperty(property, value);
        return this;
    }

    public String getJson() {
        return data.toString();
    }

}
