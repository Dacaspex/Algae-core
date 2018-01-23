package fractal.data;

import util.math.Complex;
import util.math.Point;

import java.util.ArrayList;
import java.util.HashMap;

public class JuliaFractalData implements FractalData {

    private HashMap<Point, ArrayList<Complex>> pixelData;

    public JuliaFractalData() {
        this.pixelData = new HashMap<>();
    }

    public void addPixelData(Point point, ArrayList<Complex> sequence) {
        pixelData.put(point, sequence);
    }
}
