package colorscheme;

import colorscheme.data.ColorSchemeDataTypes;
import colorscheme.data.GreyScaleData;
import fractal.data.FractalData;
import settings.RenderSettings;

public class GreyScaleColorScheme extends ColorScheme {

    @Override
    public ColorSchemeDataTypes[] getCompatibleTypes() {
        return new ColorSchemeDataTypes[]{

        };
    }

    @Override
    public ColorData getColorData(RenderSettings renderSettings, FractalData fractalData) {

        // Get the required data
        float[][] greyScaleData = ((GreyScaleData) fractalData).getGreyScaleData();
        ColorData colorData = new ColorData(renderSettings.getWidth(), renderSettings.getHeight());

        for (int x = 0; x < renderSettings.getWidth(); x++) {
            for (int y = 0; y < renderSettings.getHeight(); y++) {

                // Convert the single grey scale value into a 3d colour value
                colorData.add(x, y, convertToColor(greyScaleData[x][y]));

            }
        }

        return colorData;
    }

    /**
     * Maps a value between 0 and 1 to 0 and 255. This value is put into a array with size 3,
     * mimicking a colour.
     *
     * @param value The normalized value between 0 and 1
     * @return RGB colour array
     */
    private int[] convertToColor(float value) {
        return new int[]{
                Math.min((int) (value * 255), 255),
                Math.min((int) (value * 255), 255),
                Math.min((int) (value * 255), 255)
        };
    }
}
