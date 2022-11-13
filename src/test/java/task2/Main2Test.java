package task2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Main2Test {
    static List<String> list = new ArrayList<>();
    static List<String> expected = new ArrayList<>();

    @BeforeAll
    static void init() {
        list.add("#one");
        list.add("#one");
        list.add("#two#two #two#four");
        list.add("#one");
        list.add("#two");
        list.add("#three");
        list.add("#three");
        list.add("#four");
        list.add("#five");
        list.add("#four");
        list.add("#five");
        list.add("#six");
        list.add("#four");
        list.add("#four");
        list.add("#three");

        expected.add("#four - 5");
        expected.add("#one - 3");
        expected.add("#three - 3");
        expected.add("#two - 2");
        expected.add("#five - 2");
    }

    @Test
    void getTop5() {
        assertAll(
                () -> assertNotNull(list),
                () -> assertNotNull(expected),
                () -> assertEquals(expected, Main2.getTop5(list))
        );
    }
}