package my_practice.cargo_company.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorTest {
    private Administrator administrator;
    @BeforeEach
    void setUp(){
        administrator = new Administrator("Samet","Yıldız");

    }
    @RepeatedTest(10)
    void testToString() {
        System.out.println(administrator.toString());
    }
}