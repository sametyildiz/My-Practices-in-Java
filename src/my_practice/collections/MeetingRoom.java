package my_practice.collections;



import java.util.*;

public class MeetingRoom {

    protected Map<String, TreeMap<Integer , Integer>> reservationRecordAllRoom;


    public MeetingRoom(){
        reservationRecordAllRoom = new TreeMap<>();
    }

    public boolean calculateAvaibility( String meetingRoom ,int [] reservationInterval){
        if(!reservationRecordAllRoom.containsKey(meetingRoom))
            reservationRecordAllRoom.put(meetingRoom, new TreeMap<>());

        Map<Integer,Integer> reservationRecord = reservationRecordAllRoom.get(meetingRoom);

        if(reservationInterval[0] < 0 || reservationInterval[1] > 24 || reservationInterval[1] <= reservationInterval[0])
            return false; //invalid input
        else if(reservationRecord.containsKey(reservationInterval[0]) && reservationRecord.get(reservationInterval[0]) == reservationInterval[1])// Key = inputKey && inputValue = Value
            return true;
        else if(reservationRecord.isEmpty()) {
            reservationRecord.put(reservationInterval[0], reservationInterval[1]);
            return true;
        }
        else {
            Set<Integer> keys = new TreeSet<>();
            keys.addAll(reservationRecord.keySet());

            Iterator iterator = keys.iterator();
            Integer key  , inputKey = reservationInterval[0] , inputValue = reservationInterval[1];
            while(iterator.hasNext()) {
                key = (Integer) iterator.next();

                int compareKeys = Integer.compare(inputKey, key);
                int compareInputKeyAndValue = Integer.compare(inputKey, reservationRecord.get(key));
                int compareKeyAndInputValue = Integer.compare(key, inputValue);
                int compareValues = Integer.compare(inputValue, reservationRecord.get(key));

                if ((compareInputKeyAndValue == 1 || compareKeyAndInputValue == 1 ) && !iterator.hasNext()) { // inputKey > Value || Key > inputValue (There s no interaction)
                    reservationRecord.put(inputKey,inputValue);
                }
                else if (compareKeys == -1 && compareValues == 1) { // inputKey < Key && Value < inputValue
                    reservationRecord.remove(key);
                    reservationRecord.put(inputKey, inputValue);
                } else if ( compareKeyAndInputValue != 1 && compareKeys == -1 ) { //inputKey < key && value >= inputValue && key <= inputValue
                    int newValue = reservationRecord.remove(key);
                    reservationRecord.put(inputKey, newValue);
                    inputValue = newValue;
                } else if ( compareInputKeyAndValue != 1 && compareValues == 1) { // Key <= inputKey && Value < inputValue
                    reservationRecord.replace(key, inputValue);
                    inputKey = key;
                }
                else if( compareKeys != -1 && compareValues != 1 ){ // key <= inputkey && inputValue <= Value
                    break;

                }

            }
            return true;
        }
    }



    public Map<Integer,Integer> availablePeriots(String meetingRoom){
        if(!reservationRecordAllRoom.containsKey(meetingRoom))
            throw new NullPointerException(String.format("No exist a Meeting Room named %s." , meetingRoom));
        Map<Integer,Integer> reservationRecord = reservationRecordAllRoom.get(meetingRoom);


        Map<Integer,Integer> avaibility = new TreeMap<>();
        int i = 0 , firstHour = 0;
        Queue<Integer> keys = new PriorityQueue<>(){{addAll(reservationRecord.keySet());}};
        int key = keys.remove();
            while (i < 25)
                if(i == key){
                    avaibility.put(firstHour, key);
                    i = reservationRecord.get(key);
                    firstHour = i;
                    if(!keys.isEmpty())
                        key = keys.remove();
                    else if(firstHour !=24 ){
                        avaibility.put(firstHour, 24);
                    }
                    else break;
                }else i++;

        return avaibility;

    }


    public void printReservations(String meetingRoom){
        if(!reservationRecordAllRoom.containsKey(meetingRoom))
            throw new NullPointerException(String.format("No exist a Meeting Room named %s." , meetingRoom));
        Map<Integer,Integer> reservationRecord = reservationRecordAllRoom.get(meetingRoom);
        System.out.printf("Reserved Periots on Room  : %s: %s\n", meetingRoom, reservationRecord);
        System.out.printf("Available Periots on Room : %s: %s\n", meetingRoom , availablePeriots(meetingRoom));
        System.out.println();
    }



}
