package my_practice.cargo_company.utils;


import java.util.stream.IntStream;

public class Tools {

    public static String randomID(int size){
        StringBuilder str = new StringBuilder("");
        IntStream.range(1,size + 1).forEach(i ->str.append((int) (Math.random()*10)));

        return str.toString();

    }

}
