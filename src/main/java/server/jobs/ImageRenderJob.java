package server.jobs;

import rendering.ImageRenderer;
import server.Server;
import settings.Settings;

import java.awt.image.BufferedImage;

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

        Server.getServer().saveImage(image);
    }

    @Override
    public void stop() {

    }
}
