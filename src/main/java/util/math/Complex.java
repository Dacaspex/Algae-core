package util.math;

public class Complex {

    private final double real;
    private final double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
        this(0, 0);
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getModulus() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }

    public double getArgument() {

        if (real > 0) {

            return Math.atan(imaginary / real);

        } else if (real < 0 && imaginary >= 0) {

            return Math.atan(imaginary / real) + Math.PI;

        } else if (real < 0 && imaginary < 0) {

            return Math.atan(imaginary / real) - Math.PI;

        } else if (real == 0 && imaginary > 0) {

            return Math.PI / 2;

        } else if (real == 0 && imaginary < 0) {

            return -(Math.PI / 2);

        } else {

            return Integer.MAX_VALUE;

        }

    }

    public Complex add(Complex c) {
        return new Complex(
                this.real + c.getReal(),
                this.imaginary + c.getImaginary()
        );
    }

    public Complex subtract(Complex c) {
        return new Complex(
                this.real - c.getReal(),
                this.imaginary - c.getImaginary()
        );
    }

    public Complex multiply(Complex complex) {
        double real = this.real * complex.getReal() - this.imaginary * complex.getImaginary();
        double imaginary = this.real * complex.getImaginary() + this.imaginary * complex.getReal();

        return new Complex(real, imaginary);
    }

    public Complex multiply(double k) {
        return new Complex(
                k * real,
                k * imaginary
        );
    }

    public Complex power(double power) {
        Complex result = this;
        for (int i = 0; i < power - 1; i++) {
            result = result.multiply(result);
        }

        return result;
    }

    public String toString() {
        String glue = "";
        if (imaginary >= 0) {
            glue = "+";
        }

        return real + glue + imaginary + "i";
    }

}