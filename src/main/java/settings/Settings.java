package settings;

import colorscheme.ColorScheme;
import colorscheme.GreyScaleColorScheme;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import exception.CoreException;
import fractal.Fractal;
import fractal.JuliaFractal;
import fractal.settings.JuliaFractalSettings;
import server.Server;
import server.response.ErrorResponse;

public class Settings {

    private JsonObject root;
    private RequestType requestType;

    public Settings(String data) {
        this.root = (new Gson()).fromJson(data, JsonObject.class);
    }

    /**
     * Initialises the settings. Reads the required properties to determine the next step
     * in the program
     */
    public void init() {

        try {

            requestType = RequestType.createFromSettings(root.get("request_type").getAsString());

        } catch (CoreException exception) {
            Server.getServer().send(
                    new ErrorResponse(exception)
            );
        }

    }

    public Fractal getFractal() {

        String identifier = root.get("fractal").getAsJsonObject()
                .get("identifier").getAsString();

        JsonObject fractalSettings = root.get("fractal").getAsJsonObject()
                .get("settings").getAsJsonObject();

        switch (identifier) {

            case "julia_fractal":
                return new JuliaFractal(
                        new JuliaFractalSettings().loadFromSettings(fractalSettings)
                );

            default:
                // TODO Replace exception
                throw new RuntimeException("Could not resolve fractal identifier");

        }

    }

    public ColorScheme getColorscheme() {

        String identifier = root.get("color_scheme").getAsJsonObject()
                .get("identifier").getAsString();

//        JsonObject colorSchemeSettings = root.get("color_scheme").getAsJsonObject()
//                .get("settings").getAsJsonObject();

        switch (identifier) {

            case "grey_scale_color_scheme":
                return new GreyScaleColorScheme();

            default:
                // TODO Replace exception
                throw new RuntimeException("Could not resolve fractal identifier");

        }

    }

    public RenderSettings getRenderSettings() {

        int width = root.get("render_settings").getAsJsonObject()
                .get("width").getAsInt();
        int height = root.get("render_settings").getAsJsonObject()
                .get("height").getAsInt();

        return new RenderSettings(width, height);
    }

    /**
     * @return Request type
     */
    public RequestType getRequestType() {
        return requestType;
    }
}
