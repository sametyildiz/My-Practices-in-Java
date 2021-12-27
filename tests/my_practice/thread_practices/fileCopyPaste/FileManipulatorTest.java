package my_practice.thread_practices.fileCopyPaste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FileManipulatorTest {
    private FileManipulator manipulator;
    private ExecutorService copy,paste;
    private String read ;
    @BeforeEach
    void setUp() throws ExecutionException, InterruptedException {
        manipulator = new FileManipulator();
        copy = Executors.newSingleThreadExecutor(new MyThreadFactory("READER"));
        paste = Executors.newFixedThreadPool(5, new MyThreadFactory("WRITER"));

        read = copy.submit(() -> manipulator.readFile()).get();

    }

    @Test
    void copyPaste() throws ExecutionException, InterruptedException {
        for(int i = 1 ; i <=5 ; i++){
            paste.execute(()-> {
                try {
                    manipulator.writeToFile(read, "copy by " + Thread.currentThread().getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        paste.shutdown();
    }


    @Test
    void readFile() {
        Assertions.assertDoesNotThrow(()-> System.out.println( manipulator.readFile()));
        Assertions.assertDoesNotThrow(()-> manipulator.writeToFile(manipulator.readFile(), "copy1"));
    }
}