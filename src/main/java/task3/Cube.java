package task3;

public class Cube implements Figure {
    private final double face;

    Cube(double face) {
        this.face = face;
    }

    public double getFace() {return face;}

    @Override
    public double getVolume() {
        return Math.pow(getFace(), 3);
    }

    @Override
    public String toString() {
        return "Cube = " + getVolume();
    }
}
