package task3;

public class Sphere implements Figure {
    private static final double PI = 3.14159265359;
    private final double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4 * PI * Math.pow(radius, 3)) / 3;
    }

    @Override
    public String toString() {
        return "Sphere = " + getVolume();
    }
}
