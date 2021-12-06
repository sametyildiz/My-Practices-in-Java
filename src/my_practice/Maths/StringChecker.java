package my_practice.Maths;

public class StringChecker {

    public String solution(String s){
        int i = 0; String c = "";
        while(i < s.length()){
            c = String.valueOf(s.charAt(i));
            s = s.substring(++i);
            if( s.contains(c)){
                break;
            }
        }
        return c;
    }

}
