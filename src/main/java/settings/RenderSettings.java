package settings;

/**
 * Data class for all render settings
 */
public class RenderSettings {

    /**
     * Width of the image in pixels
     */
    private int width;

    /**
     * Height of the image in pixels
     */
    private int height;

    /**
     * Constructor
     *
     * @param width  Width of the image in pixels
     * @param height Height of the image in pixels
     */
    public RenderSettings(int width, int height) {

        this.width = width;
        this.height = height;

    }

    /**
     * @return Width of the image in pixels
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return Height of the image in pixels
     */
    public int getHeight() {
        return height;
    }
}
