package my_practice.thread_practices.fileCopyPaste;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private String name ;
    private int counter;
    public MyThreadFactory(String name){
        counter = 1;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r , name + "-" + counter++);
    }
}
