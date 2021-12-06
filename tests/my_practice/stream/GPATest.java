package my_practice.stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GPATest {
    private static GPA gpa;

    @BeforeAll
    static void setUp() {
        gpa = new GPA();
    }


    static Stream<Arguments> noteList() {
        return Stream.of(
                Arguments.of("Ali", Lessons.ENGLISH, 50),
                Arguments.of("Ali", Lessons.MATHEMATICS, 90),
                Arguments.of("Ali", Lessons.LITERACY, 60),
                Arguments.of("Ali", Lessons.GEOGRAPHY, 30),
                Arguments.of("Ali", Lessons.BIOLOGY, 70),

                Arguments.of("Veli", Lessons.ENGLISH, 70),
                Arguments.of("Veli", Lessons.MATHEMATICS, 65),
                Arguments.of("Veli", Lessons.LITERACY, 83),
                Arguments.of("Veli", Lessons.GEOGRAPHY, 78),
                Arguments.of("Veli", Lessons.BIOLOGY, 60),

                Arguments.of("Mehmet", Lessons.ENGLISH, 45),
                Arguments.of("Mehmet", Lessons.MATHEMATICS, 60),
                Arguments.of("Mehmet", Lessons.LITERACY, 34),
                Arguments.of("Mehmet", Lessons.GEOGRAPHY, 68),
                Arguments.of("Mehmet", Lessons.BIOLOGY, 25),

                Arguments.of("Hasan", Lessons.ENGLISH, 48),
                Arguments.of("Hasan", Lessons.MATHEMATICS, 70),
                Arguments.of("Hasan", Lessons.LITERACY, 60),
                Arguments.of("Hasan", Lessons.GEOGRAPHY, 30),
                Arguments.of("Hasan", Lessons.BIOLOGY, 50)
        );
    }

    @Order(1)
    @ParameterizedTest
    @MethodSource("noteList")
    void addTheGPA(String name, Lessons lessons, int note) {
        Assertions.assertDoesNotThrow(() -> gpa.addTheGPA(name, lessons, note));

    }



    @AfterAll
    static void addGraduated() {

        gpa.printGraduateds();
    }
}