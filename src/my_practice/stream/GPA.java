package my_practice.stream;

import java.util.*;
import java.util.stream.Collectors;

public class GPA {
    private final Map<String, List<Map.Entry<Lessons , Integer>>> noteList;
    private final List<Map.Entry<String , Double >>graduatedList;
    private final int sumP;
    public GPA() {
        noteList = new HashMap<>() ;
        graduatedList = new ArrayList<>();
        sumP = Arrays.stream(Lessons.values()).mapToInt(e -> e.power).sum();
    }

    public void addTheGPA(String name, Lessons lessons , int point){
        if(!noteList.containsKey(name))
            noteList.put(name, new ArrayList<>());
        noteList.get(name).add( new AbstractMap.SimpleEntry<>(lessons, point));
    }

    private double calculateGPA(String name){
        double sum = noteList.get(name).stream().mapToDouble(e -> e.getKey().power * e.getValue()).sum();
        return sum / sumP;
    }

    private List<Map.Entry<String,Double>> addGraduated(){
        return noteList.keySet().stream().filter(entries -> calculateGPA(entries) >= 50)
                .map(entries -> new AbstractMap.SimpleEntry<>(entries, calculateGPA(entries))).collect(Collectors.toList());

    }

    public void printGraduateds(){
        graduatedList.addAll(addGraduated());
        //graduatedList.sort( (x,y) -> x.getValue() > y.getValue() ? 1 : x.getValue() < y.getValue() ? -1 : 0);
        //graduatedList.sort( (x,y) -> x.getValue().compareTo(y.getValue()));
        //graduatedList.sort(Comparator.comparing(Map.Entry::getValue));
        graduatedList.sort(Map.Entry.comparingByValue());
        graduatedList.forEach(entry-> System.out.printf("%7s -> %.2f\n", entry.getKey(), entry.getValue()));
    }



}
enum Lessons {
    ENGLISH(4),
    MATHEMATICS(4),
    LITERACY(3),
    BIOLOGY(3),
    GEOGRAPHY(2);

    public final int power;

    Lessons(int power) {
        this.power = power;
    }
}