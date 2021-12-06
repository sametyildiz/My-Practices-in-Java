package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem9Test {
    private Problem9 problem9;
    @BeforeEach
    void setUp() {
        problem9 = new Problem9();
    }

    @Test
    void isPalindrome() {
        Assertions.assertTrue(problem9.isPalindrome(121));
        Assertions.assertTrue(problem9.isPalindrome(1221));
        Assertions.assertFalse(problem9.isPalindrome(1421));
        Assertions.assertTrue(problem9.isPalindrome(11));
        Assertions.assertTrue(problem9.isPalindrome(1));
        Assertions.assertFalse(problem9.isPalindrome(-121));
    }
}