package colorscheme;

import colorscheme.data.GreyScaleData;
import fractal.data.FractalData;
import logging.Logger;
import settings.RenderSettings;

import java.util.Arrays;

public class GreyScaleColorScheme extends ColorScheme {

    @Override
    public ColorData getColorData(RenderSettings renderSettings, FractalData fractalData) {

        float[][] greyScaleData = ((GreyScaleData) fractalData).getGreyscaleData();
        ColorData colorData = new ColorData(renderSettings.getWidth(), renderSettings.getHeight());

        for (int x = 0; x < renderSettings.getWidth(); x++) {
            for (int y = 0; y < renderSettings.getHeight(); y++) {

                // Convert the single grey scale value into a 3d colour value
                colorData.add(x, y, convertToColor(greyScaleData[x][y]));

            }
        }

        return colorData;
    }

    private int[] convertToColor(float value) {
        return new int[]{
                Math.min((int) (value * 255), 255),
                Math.min((int) (value * 255), 255),
                Math.min((int) (value * 255), 255)
        };
    }
}
