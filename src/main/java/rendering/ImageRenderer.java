package rendering;

import fractal.Fractal;
import fractal.data.FractalData;
import settings.RenderSettings;

import java.awt.image.BufferedImage;

public class ImageRenderer {

    public BufferedImage render(
            Fractal fractal,
            RenderSettings renderSettings) {

        FractalData fractalData = fractal.getFractalData(renderSettings);

        return null;
    }

}
