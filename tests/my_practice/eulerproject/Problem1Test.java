package my_practice.eulerproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {
    private Problem1 problem1;
    @BeforeEach
    void setUp() {
        problem1 = new Problem1();
    }

    @Test
    void solution() {
        Assertions.assertEquals(problem1.solution(10,3 ,5) , 23);
        Assertions.assertEquals(problem1.solution(20,3 ,5) , 78);
        Assertions.assertEquals(problem1.solution(1000,3 ,5) , 233168);
    }
}