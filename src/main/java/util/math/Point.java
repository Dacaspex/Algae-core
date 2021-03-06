package util.math;

import java.awt.geom.Point2D;

public class Point extends Point2D.Double {

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public static Point getCenterPoint(double width, double height) {
        return new Point(width / 2, height / 2);
    }
}
