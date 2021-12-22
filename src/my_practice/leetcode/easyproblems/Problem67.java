package my_practice.leetcode.easyproblems;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class Problem67 {
    public String addBinary(String a, String b) {
       // return Long.toBinaryString(addBinary(Long.parseLong(a, 2) , Long.parseLong(b, 2))); //bitwise solution
        return stringOfSumBinary(new StringBuilder(""), a, b, 0).toString();
    }

    private StringBuilder stringOfSumBinary(StringBuilder str, String a, String b, int res){
        if(a.isEmpty() && b.isEmpty())
            return res == 0 ? str : str.insert(0 , res);
        int num = res;
        num += !a.isEmpty() ? Integer.parseInt(String.valueOf(a.charAt(a.length() - 1))): 0;
        num += !b.isEmpty() ? Integer.parseInt(String.valueOf(b.charAt(b.length() - 1))): 0;
        res = num / 2;
        num = num % 2;
        str.insert(0 , num);
        a = !a.isEmpty() ? a.substring(0, a.length() - 1) : "";
        b = !b.isEmpty() ? b.substring(0, b.length() - 1) : "";
        return stringOfSumBinary(str, a, b, res);
    }

    private long addBinary(long a, long b){
        long r = a ^ b;
        long c = (a & b ) << 1;

        if ( c != 0)
            return addBinary(r, c);

        return r;
    }

}
