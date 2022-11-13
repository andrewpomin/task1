package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Main3Test {
    static Collection<Figure> collection = new ArrayList<>();
    static Collection<Figure> expected = new ArrayList<>();
    static Cube cube;
    static Sphere sphere;
    static Cylinder cylinder;

    @BeforeEach
    void init() {
        cube = new Cube(3);
        collection.add(cube);

        sphere = new Sphere(2.5);
        collection.add(sphere);

        cylinder = new Cylinder(1.5, 3);
        collection.add(cylinder);

        expected.add(sphere);
        expected.add(cube);
        expected.add(cylinder);
    }

    @Test
    void sortByVolume() {
        assertAll(
                () -> assertNotNull(Main3.sortByVolume(collection)),
                () -> assertEquals(expected, Main3.sortByVolume(collection))
        );
    }
}