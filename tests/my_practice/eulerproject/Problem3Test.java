package my_practice.eulerproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {
    private Problem3 problem3;
    @BeforeEach
    void setUp() {
        problem3 = new Problem3();
    }

    @Test
    void largestPrimeFactor() {
        Assertions.assertEquals(problem3.largestPrimeFactor(13195L) , 29);
        Assertions.assertEquals(problem3.largestPrimeFactor(600851475143L ) , 6857);

    }

    @Test
    void primeNumbers() {
        boolean[] primes = problem3.primeNumbers(100);
        for(int i = 2 ; i < primes.length ; i++){
            if(primes[i])
                System.out.printf("%d " , i);
        }
    }
}