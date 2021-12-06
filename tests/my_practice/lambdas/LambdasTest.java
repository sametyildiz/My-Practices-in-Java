package my_practice.lambdas;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;



class LambdasTest {
    private static Lambdas practice;

    @BeforeAll
    static void setUp() {
        practice = new Lambdas();
    }



    @AfterAll
    static void finishTheWorks() {
        practice.finishTheWorks();
    }

    static Stream<Arguments> workDefines(){
        return Stream.of(
                Arguments.of("Samet", (ExecuterWork) (workName, count) -> {
                    System.out.printf("Samet tarafından %d adet %s yapıldı.\n" , count , workName);
                    System.out.println("Good Jobs !");
                }),
                Arguments.of("Aysel", (ExecuterWork) (workName, count) ->{
                    System.out.printf("Aysot tarafından %d adet %s yapıldı.\n" , count , workName);
                    System.out.println("Hele Şükür !!!");
                })
        );
    }



    @Order(1)
    @ParameterizedTest
    @MethodSource("workDefines")
    void defineWorks(String workerName, ExecuterWork executerWork) {
        Assertions.assertDoesNotThrow(()-> practice.defineWorks(workerName, executerWork));
    }

    static Stream<Arguments> workList(){
        return Stream.of(
                Arguments.of("Samet", "Paketleme" , 130),
                Arguments.of("Aysel", "Çanta Dikimi" , 130),
                Arguments.of("Samet", "Astar Kesimi" , 130),
                Arguments.of("Aysel", "Astar Dikimi" , 130)
        );
    }

    @Order(2)
    @ParameterizedTest
    @MethodSource("workList")
    void addWorkToList(String workerName, String workName, int count) {
        Assertions.assertTrue(practice.addWorkToList(workerName , workName , count));
    }
}