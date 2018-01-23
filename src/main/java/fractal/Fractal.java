package fractal;

import fractal.data.FractalData;
import fractal.settings.FractalSettings;
import settings.RenderSettings;

public abstract class Fractal {

    protected FractalSettings fractalSettings;

    protected Fractal(FractalSettings fractalSettings) {
        this.fractalSettings = fractalSettings;
    }

    public abstract FractalData getFractalData(RenderSettings renderSettings);

}
