package server.jobs;

import rendering.ImageRenderer;
import server.Server;
import server.response.Response;
import settings.Settings;

public class ImageRenderJob implements Job{

    private Settings settings;

    private ImageRenderer renderer;

    public ImageRenderJob(Settings settings) {

        this.settings = settings;
        this.renderer = new ImageRenderer();

    }

    @Override
    public void start() {
        renderer.render(
                settings.getFractal(),
                settings.getRenderSettings()
        );

        Server.getServer().send(new Response().addProperty("message", "done"));
    }

    @Override
    public void stop() {

    }
}
