package my_practice.eulerproject;

import java.util.Arrays;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {
    public int largestPrimeFactor(long number){
        boolean[] primeNumbers = primeNumbers((int) Math.sqrt(number));
        int prime=2;
        while (true) {
            if(primeNumbers[prime]){
                while (number % prime == 0)
                    number /= prime;
                if(number > 1)
                    prime++;
                else break;
            }
            else prime++;
        }
        return prime;
    }
    public boolean[] primeNumbers(int limit){
        boolean[] primes = new boolean[limit + 1];
        Arrays.fill(primes , true);
        int i = 4 , j = 6 ;
        while ( i < primes.length ){
            primes[i]=false;
            i += 2;
            if(j < primes.length) {
                primes[j] = false;
                j += 3;
            }
        }
        return primes;
    }


}
