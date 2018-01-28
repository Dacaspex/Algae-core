package fractal.data;

import colorscheme.data.GreyScaleData;
import util.math.Complex;

import java.util.ArrayList;

public class JuliaFractalData extends FractalData implements GreyScaleData {

    private int imageWidth;
    private int imageHeight;

    private DataSet[] pixelData;

    private int maxSequenceLength;

    public JuliaFractalData(int imageWidth, int imageHeight) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.maxSequenceLength = 0;
        this.pixelData = new DataSet[imageWidth * imageHeight];
    }

    public void addPixelData(int x, int y, ArrayList<Complex> sequence) {

        DataSet dataSet = new DataSet();
        dataSet.last = sequence.get(sequence.size() - 1);
        dataSet.sequenceLength = sequence.size();

        pixelData[y * imageWidth + x] = dataSet;

        if (sequence.size() > maxSequenceLength) {
            maxSequenceLength = sequence.size();
        }
    }

    @Override
    public float[][] getGreyScaleData() {

        float[][] greyscaleData = new float[imageWidth][imageHeight];

        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                greyscaleData[x][y] =
                        (float) pixelData[y * imageWidth + x].sequenceLength / (float) maxSequenceLength;
            }
        }

        return greyscaleData;
    }

    private class DataSet {

        Complex last;
        int sequenceLength;

    }
}
