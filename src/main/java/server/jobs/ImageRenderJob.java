package server.jobs;

import rendering.ImageRenderer;
import server.Server;
import server.response.Response;
import settings.Settings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRenderJob implements Job {

    private Settings settings;

    private ImageRenderer renderer;

    public ImageRenderJob(Settings settings) {

        this.settings = settings;
        this.renderer = new ImageRenderer();

    }

    @Override
    public void start() {
        BufferedImage image = renderer.render(
                settings.getFractal(),
                settings.getColorscheme(),
                settings.getRenderSettings()
        );

        File file = new File("image.png");

        try {
            ImageIO.write(image, "png", file);
        } catch (IOException exception) {
            // TODO Create better error handling
            throw new RuntimeException("Could not write to image file");
        }

        Server.getServer().send(new Response().addProperty("message", "done"));
    }

    @Override
    public void stop() {

    }
}
