package my_practice.collections;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;

public class StackExample {
    public Stack<Integer> stackTest;
    public ArrayDeque<Integer> dequeTest;
    public PriorityQueue<Integer> queueTest;

    public StackExample(){
        stackTest = new Stack<>();
        dequeTest = new ArrayDeque<>();
        queueTest = new PriorityQueue<>();
        int i = 0;
        while (i < 20){
            int number = (int)(Math.random()*100 + 1);
            stackTest.add(number);
            dequeTest.add(number);
            queueTest.add(number);
            i++;
        }
    }

    public void printLists(){
        System.out.println("Stack!!!");
        while (!stackTest.isEmpty())
            System.out.println(stackTest.pop());

        System.out.println("Deque!!!");
        while (!dequeTest.isEmpty())
            System.out.println(dequeTest.pop());

        System.out.println("PriorityQueue!!!");
        while (!queueTest.isEmpty())
            System.out.println(queueTest.poll());

    }


}
