package my_practice.collections;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class GasStation {

    public int calculateStops(int depo ,int distance , List<int[]> stations){
        PriorityQueue<int[]> possibleStops = new PriorityQueue<>((x,y)-> -Integer.compare(x[1], y[1]));
        int sumOfGas = depo , count = 0;

        while (sumOfGas < distance) {
            Iterator<int[]> it = stations.iterator();
                while (it.hasNext()){
                    int[] stop = it.next();
                    if (sumOfGas > stop[0]) {
                        possibleStops.add(stop);
                        it.remove();
                    }
                }



                    if(!possibleStops.isEmpty()){
                        sumOfGas += possibleStops.poll()[1];
                        count++;
                    }
                    else
                        return -1;

                }
            return count;
            }

}
