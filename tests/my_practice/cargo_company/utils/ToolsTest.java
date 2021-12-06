package my_practice.cargo_company.utils;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class ToolsTest {

    @RepeatedTest(10)
    void randomID() {
        System.out.println(Tools.randomID(8));
    }


}