package my_practice.iterator_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class CityTraveller {

    private static List<Cities> map = new ArrayList<>(Arrays.asList(Cities.values()));
    private ListIterator<Cities> iterator;
    private boolean backForward = true;
    public Cities startPoint ;
    public CityTraveller(Cities startPoint){
        iterator = map.listIterator()  ; // Field da tanımlayınca java.util.ConcurrentModificationException
        this.startPoint = findStartPoint(startPoint);
        this.startPoint.changeLocation();
    }

    public Cities travel(boolean direction, Cities locationNow){
        String str = "In The %s City of The Travel\n";
        if(direction) {//forward
            if (!iterator.hasNext()) {
                System.out.printf(str , "Last");
            } else {
                locationNow.changeLocation();
                if (!backForward) {
                    iterator.next();
                    backForward = true;
                }
                locationNow = iterator.next();
                locationNow.changeLocation();

            }
        }
        else{
            if(iterator.hasPrevious() && backForward){
                iterator.previous();
                backForward = false;
                }
            if(!iterator.hasPrevious()) {
                System.out.printf(str , "First");
            }else{
                locationNow.changeLocation();
                locationNow = iterator.previous();
                locationNow.changeLocation();}
        }
        return locationNow;
    }

    public Cities findStartPoint(Cities city){
        while (iterator.hasNext()){
            Cities tmp = iterator.next();
            if(tmp.equals(city))
                break;
        }
        return city;
    }


    public static void printMap(){
        System.out.printf("%12s\n" , "City Tour");
        for(int i = 0 ; i < map.size() ; i++){
            String str, blank = map.get(i).location ? ">>>" : "" ;
            str = String.format("%3s%d.%s\n" , blank ,i+1 ,map.get(i));
            System.out.print(str);
        }
        System.out.println("\n");
    }

    public void limitTest(){
        while (iterator.hasPrevious()){
            iterator.previous();
        }
    }


}
enum Cities {
    ISTANBUL,
    ANKARA,
    ESKISEHIR,
    IZMIR,
    BODRUM;
    public boolean location = false;

    public void changeLocation(){
        this.location = !location;
    }


}