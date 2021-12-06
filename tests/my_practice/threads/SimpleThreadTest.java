package my_practice.threads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;

class SimpleThreadTest {
    private SimpleThread simpleThread1;
    private SimpleThread simpleThread2;
    private SimpleThread simpleThread3;

    private Thread[] threadsList;
    @BeforeEach
    void setUp() {
        Runnable simpleRunnable = ()-> {
            System.out.println(Thread.currentThread().getName());
        };

        simpleThread1 = new SimpleThread(simpleRunnable ,"Thread-1");
        simpleThread2 = new SimpleThread(simpleRunnable ,"Thread-2");
        simpleThread3 = new SimpleThread("Thread-3");
        System.out.println(Thread.currentThread().getName());

        threadsList = new Thread[10];
        for(int i = 0 ; i < threadsList.length ; i++)
            threadsList[i] = new SimpleThread("Thread - " + i);
    }



    @RepeatedTest(10)
    void run() throws InterruptedException {
        simpleThread2.start();
        simpleThread1.start();

        simpleThread3.start();

        simpleThread1.join();
        simpleThread2.join();
        simpleThread3.join();
        System.out.println("**********************************");
    }

    @RepeatedTest(5)
    void parallelTest(){
        Arrays.stream(threadsList).parallel().forEach( f -> {
            f.start();
            try {
                f.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("**********************************");
    }
}