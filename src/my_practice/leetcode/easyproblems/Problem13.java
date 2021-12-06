package my_practice.leetcode.easyproblems;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class Problem13 {

    public int romanToInt(String s) {
        int i = 0 , sum = 0;
        while (i < s.length()){
            sum += switch (s.charAt(i++)){
                    case 'I' -> {
                        if (i < s.length()) {
                            if (s.charAt(i) == 'V') {
                                i++;
                                yield 4;
                            } else if (s.charAt(i) == 'X') {
                                i++;
                                yield 9;
                            } else
                                yield 1;
                        }
                        else yield 1;
                    }
                    case 'V' -> 5;
                    case 'X' -> {
                        if (i < s.length()) {
                            if (s.charAt(i) == 'L') {
                                i++;
                                yield 40;
                            } else if (s.charAt(i) == 'C') {
                                i++;
                                yield 90;
                            } else
                            yield 10;
                }
                        else yield 10;
            }
                    case 'L' -> 50;
                    case 'C' -> {
                        if (i < s.length()) {
                            if (s.charAt(i) == 'D') {
                                i++;
                                yield 400;
                            } else if (s.charAt(i) == 'M') {
                                i++;
                                yield 900;
                            } else
                                yield 100;
                        }
                        else yield 100;
                    }
                    case 'D' -> 500;
                    case 'M' -> 1000;

                default -> 0;
            };


        }
        return sum;

    }



    /**
     * See <a href="https://leetcode.com/problems/roman-to-integer/discuss/1601917/Runtime%3A-3-ms-faster-than-99.79.-Memory-Usage%3A-38.9-MB-less-than-96.82.">the solution of the user nicked udhakrisenthil in leetcode</a>
     * */

    public int alfernativeSolution(String s){
        String symbols = "IVXLCDM";
        int[] values = {1, 5, 10, 50, 100, 500, 1000};

        int returnValue = 0;
        int previousIndex = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentIndex = symbols.indexOf(s.charAt(i));

            if (currentIndex < previousIndex) {
                returnValue -= values[currentIndex];
            } else {
                returnValue += values[currentIndex];
            }
            previousIndex = currentIndex;
        }

        return returnValue;
    }
}




