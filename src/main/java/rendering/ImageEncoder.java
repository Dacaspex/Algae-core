package rendering;

import colorscheme.ColorData;
import logging.Logger;
import settings.RenderSettings;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageEncoder {

    public static BufferedImage getImage(RenderSettings renderSettings, ColorData colorData) {

        BufferedImage image = new BufferedImage(
                renderSettings.getWidth(),
                renderSettings.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        int[][][] colors = colorData.getColors();

        for (int x = 0; x < renderSettings.getWidth(); x++) {
            for (int y = 0; y < renderSettings.getHeight(); y++) {

                int[] color = colors[x][y];

                image.setRGB(x, y, new Color(color[0], color[1], color[2]).getRGB());

            }
        }

        return image;
    }
}
