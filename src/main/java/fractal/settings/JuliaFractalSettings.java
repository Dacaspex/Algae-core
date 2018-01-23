package fractal.settings;

import com.google.gson.JsonObject;
import util.math.Complex;
import util.math.Point;
import util.math.Scale;

public class JuliaFractalSettings implements FractalSettings {

    private Complex constant;
    private int maxIterations;
    private float escapeValue;
    private Scale scale;

    public Complex getConstant() {
        return constant;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public float getEscapeValue() {
        return escapeValue;
    }

    public Scale getScale() {
        return scale;
    }

    @Override
    public JuliaFractalSettings loadFromSettings(JsonObject settings) {

        // TODO Error handling?

        constant = new Complex(
                settings.get("constant").getAsJsonObject().get("real").getAsFloat(),
                settings.get("constant").getAsJsonObject().get("imaginary").getAsFloat()
        );
        maxIterations = settings.get("max_iterations").getAsInt();
        escapeValue = settings.get("escape_value").getAsFloat();

        JsonObject scaleRoot = settings.get("scale").getAsJsonObject();

        scale = new Scale(
                new Point(
                        scaleRoot.get("center").getAsJsonObject().get("x").getAsFloat(),
                        scaleRoot.get("center").getAsJsonObject().get("y").getAsFloat()
                ),
                scaleRoot.get("zoom_level").getAsFloat()
        );

        return this;
    }

    @Override
    public void validate() {

        // TODO

    }
}
