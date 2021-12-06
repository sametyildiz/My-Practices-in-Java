package my_practice.lambdas;

import java.util.*;
// Do not implements ExecuterWork !!!

public class Lambdas  {
    private final Map<String, List<Map.Entry<String,Integer>>> dailyWorks;
    private final Map<String, ExecuterWork> howToDo;

    public Lambdas(){
        dailyWorks = new HashMap<>();
        howToDo = new HashMap<>();
    }


    public void defineWorks(String workerName, ExecuterWork executerWork){
            dailyWorks.put(workerName, new ArrayList<>());
            howToDo.put(workerName, executerWork);
    }


    public boolean addWorkToList(String workerName, String workName, int count){
        if(dailyWorks.containsKey(workerName)){
            dailyWorks.get(workerName).add( new AbstractMap.SimpleEntry<>(workName,count) );
        return true;
        }
        else;
            return false;

    }

    public void finishTheWorks(){
        for(Map.Entry<String, List<Map.Entry<String, Integer>>> worksList : dailyWorks.entrySet()){
            ExecuterWork executerWork = howToDo.get(worksList.getKey());

            for(Map.Entry<String, Integer> works : worksList.getValue()){
                executerWork.doTheWork(works.getKey(), works.getValue());
            }

        }

    }



}
