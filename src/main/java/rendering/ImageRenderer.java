package rendering;

import colorscheme.ColorData;
import colorscheme.ColorScheme;
import fractal.Fractal;
import fractal.data.FractalData;
import settings.RenderSettings;

import java.awt.image.BufferedImage;

public class ImageRenderer {

    /**
     * Renders a image according to the given fractal, color scheme and render settings
     *
     * @param fractal        The fractal to create
     * @param colorScheme    The color scheme to use
     * @param renderSettings Other render settings
     * @return Image of the fractal
     */
    public BufferedImage render(
            Fractal fractal,
            ColorScheme colorScheme,
            RenderSettings renderSettings) {

        // Get the fractal data
        FractalData fractalData = fractal.getFractalData(renderSettings);

        // Convert fractal data into color data using the color scheme
        ColorData colorData = colorScheme.getColorData(renderSettings, fractalData);

        // Create the image from the color data
        BufferedImage image = ImageEncoder.getImage(renderSettings, colorData);

        return image;
    }

}
