package my_practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackExampleTest {
    private StackExample test;

    @BeforeEach
    void setUp(){
        test = new StackExample();

    }

    @Test
    void printLists() {
        test.printLists();
    }
}