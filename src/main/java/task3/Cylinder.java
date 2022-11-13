package task3;

public class Cylinder implements Figure {
    private static final double PI = 3.14159265359;
    private final double radius;
    private final double height;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return height * PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Cylinder " + getVolume();
    }
}
