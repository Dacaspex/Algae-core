package rendering;

import colorscheme.ColorData;
import colorscheme.ColorScheme;
import fractal.Fractal;
import fractal.data.FractalData;
import server.Server;
import server.response.Response;
import settings.RenderSettings;

import java.awt.image.BufferedImage;

public class ImageRenderer {

    public BufferedImage render(
            Fractal fractal,
            ColorScheme colorScheme,
            RenderSettings renderSettings) {

        long start = System.currentTimeMillis();
        FractalData fractalData = fractal.getFractalData(renderSettings);
        long end = System.currentTimeMillis();

        Server.getServer().send(new Response().addProperty("time fractal", " " + (end - start)));

        start = System.currentTimeMillis();
        ColorData colorData = colorScheme.getColorData(renderSettings, fractalData);
        end = System.currentTimeMillis();

        Server.getServer().send(new Response().addProperty("time color", " " + (end - start)));

        start = System.currentTimeMillis();
        BufferedImage image = ImageEncoder.getImage(renderSettings, colorData);
        end = System.currentTimeMillis();

        Server.getServer().send(new Response().addProperty("time image", " " + (end - start)));

        return image;
    }

}
