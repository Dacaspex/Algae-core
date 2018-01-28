package colorscheme;

import colorscheme.data.ColorSchemeDataTypes;
import fractal.data.FractalData;
import settings.RenderSettings;

public abstract class ColorScheme {

    public abstract ColorSchemeDataTypes[] getCompatibleTypes();

    public abstract ColorData getColorData(RenderSettings renderSettings, FractalData fractalData);

}
