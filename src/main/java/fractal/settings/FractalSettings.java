package fractal.settings;

import com.google.gson.JsonObject;
import fractal.settings.exceptions.ValidationException;

public interface FractalSettings {

    FractalSettings loadFromSettings(JsonObject settings);

    void validate() throws ValidationException;

}
