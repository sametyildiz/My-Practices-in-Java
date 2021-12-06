package my_practice.collections;

import java.util.Map;
import java.util.TreeMap;

public class MeetingRoomEfective extends MeetingRoom{
    @Override
    public boolean calculateAvaibility(String meetingRoom, int[] reservationInterval) {
        if(reservationInterval[0] < 0 || reservationInterval[1] > 24 || reservationInterval[1] <= reservationInterval[0])
            return false; //invalid input
        if(!reservationRecordAllRoom.containsKey(meetingRoom))
            reservationRecordAllRoom.put(meetingRoom, new TreeMap<>());

        TreeMap<Integer,Integer> reservationRecord = reservationRecordAllRoom.get(meetingRoom);
        int inputKey = reservationInterval[0], inputValue = reservationInterval[1]   ;

        if(reservationRecord.floorKey(inputKey) != null) { // key <= inputKey
            Map.Entry<Integer, Integer> floorEntry = reservationRecord.floorEntry(inputKey);
            if(inputKey <= floorEntry.getValue() )
                if (inputValue > floorEntry.getValue()) {// inputValue > value
                    inputKey = floorEntry.getKey();     // check greater key
                    reservationRecord.remove(inputKey);
                    if(reservationRecord.higherKey(inputKey) == null ) { // no greater key
                        reservationRecord.put(inputKey, inputValue);
                        return true;
                    }
                }else // inputValue < Value
                    return true;
            else if(reservationRecord.higherKey(inputKey) == null ) { // inputKey > Value && no greater key (There s no interaction)
                reservationRecord.put(inputKey, inputValue);
                return true;
            }
        }

        if(reservationRecord.higherKey(inputKey) != null) { // inputKey < key
            Map.Entry<Integer, Integer> higherEntry = reservationRecord.higherEntry(inputKey);

            if (inputValue < higherEntry.getKey()) // inputValue < key (There s no interaction)
                reservationRecord.put(inputKey, inputValue);
            else {//inputValue >= key
                if (inputValue > higherEntry.getValue()){   //inputKey < key && inputValue > value
                        reservationRecord.remove(higherEntry.getKey());
                        reservationRecord.put(inputKey, inputValue);
                    }
                else{ //inputKey < key && inputValue <= value
                        int oldValue = reservationRecord.remove(higherEntry.getKey());
                        reservationRecord.put(inputKey, oldValue);
                    }
            }
        }
        if(reservationRecord.isEmpty())
            reservationRecord.put( inputKey, inputValue);



        return true;
    }
}
