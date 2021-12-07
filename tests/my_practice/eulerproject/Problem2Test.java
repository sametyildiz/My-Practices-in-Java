package my_practice.eulerproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Problem2Test {
    private Problem2 problem2;
    @BeforeEach
    void setUp() {
        problem2 = new Problem2();
    }

    @Test
    void evenFibonacciNumbersSum() {
        Assertions.assertEquals(problem2.evenFibonacciNumbersSum(4000000), 4613732);
    }
}