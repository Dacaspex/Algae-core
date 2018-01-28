package fractal;

import fractal.data.JuliaFractalData;
import fractal.settings.FractalSettings;
import fractal.settings.JuliaFractalSettings;
import settings.RenderSettings;
import util.math.Complex;
import util.math.Point;

import java.util.ArrayList;

public class JuliaFractal extends Fractal {

    public JuliaFractal(FractalSettings fractalSettings) {
        super(fractalSettings);
    }

    @Override
    public JuliaFractalData getFractalData(RenderSettings renderSettings) {

        JuliaFractalSettings fractalSettings = (JuliaFractalSettings) this.fractalSettings;
        JuliaFractalData data = new JuliaFractalData(renderSettings.getWidth(), renderSettings.getHeight());

        Point[][] points = fractalSettings.getScale().getPointsOnScreen(
                renderSettings.getWidth(),
                renderSettings.getHeight()
        );

        // Loop through every point on the screen
        for (int x = 0; x < points.length; x++) {
            for (int y = 0; y < points[x].length; y++) {

                // Get complex number associated with the coordinates on the screen
                Complex complex = new Complex(points[x][y].x, points[x][y].y);

                // Get the escape sequence
                ArrayList<Complex> sequence = getSequence(
                        complex,
                        fractalSettings.getConstant(),
                        fractalSettings.getMaxIterations(),
                        fractalSettings.getEscapeValue()
                );

                // Save the sequence with the coordinates on the screen
                data.addPixelData(x, y, sequence);
            }
        }

        return data;
    }

    public ArrayList<Complex> getSequence(Complex complex, Complex constant, int maxIterations, float escapeValue) {

        ArrayList<Complex> sequence = new ArrayList<>();
        Complex currentValue = complex;

        // Perform calculation for the Julia Set
        for (int i = 0; i < maxIterations && currentValue.getModulus() < escapeValue; i++) {
            currentValue = currentValue.power(2).add(constant);
            sequence.add(currentValue.clone());
        }

        return sequence;
    }
}
