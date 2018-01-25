package colorscheme;

public class ColorData {

    private int[][][] colors;

    public ColorData(int width, int height) {
        this.colors = new int[width][height][];
    }

    public int[][][] getColors() {
        return colors;
    }

    public void add(int x, int y, int[] color) {
        // TODO Add check for 4 components?
        colors[x][y] = color;
    }
}
