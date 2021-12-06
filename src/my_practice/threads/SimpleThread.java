package my_practice.threads;

public class SimpleThread extends Thread{

    public SimpleThread(Runnable target, String name) {
        super(target, name);
    }

    public SimpleThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        Runnable runnable = ()
                -> {
            try {
                synchronized (this){
                wait(10L);}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(super.getName() + " -> Run Method by overrided." );
        };
        runnable.run();
    }
}
