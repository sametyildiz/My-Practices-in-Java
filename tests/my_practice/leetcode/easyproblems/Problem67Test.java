package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem67Test {
    private Problem67 solution;
    @BeforeEach
    void setUp() {
        solution = new Problem67();
    }

    @Test
    void addBinary() {

        Assertions.assertEquals(solution.addBinary("1010","0110"), "10000");
        Assertions.assertEquals(solution.addBinary("1010","1011"), "10101");

    }
}