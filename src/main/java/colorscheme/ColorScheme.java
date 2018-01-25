package colorscheme;

import fractal.data.FractalData;
import settings.RenderSettings;

public abstract class ColorScheme {

    public abstract ColorData getColorData(RenderSettings renderSettings, FractalData fractalData);

}
