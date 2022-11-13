package task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Main1Test {
    static int[] a;
    static int[] b;
    static int[] expected;

    @BeforeAll
    static void init() {
        a = new int[]{1, 6, -3, 4, 5, -7, 2, 8};
        b = Main1.sortPositive(a);
        expected = new int[]{8, 6, 5, 4, 2, 1};
    }

    @Test
    void sortPositive() {
        assertAll(
                () -> assertNotNull(a),
                () -> assertNotNull(b),
                () -> assertEquals(Arrays.toString(expected), Arrays.toString(b))
        );
    }

}