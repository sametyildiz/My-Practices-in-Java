package my_practice.cargo_company.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersTypeTest {


    @Test
    void testToString() {
        Assertions.assertTrue("Administrator".equals(UsersType.administrator.toString()));
        Assertions.assertTrue("Customer".equals( UsersType.customer.toString()));
        Assertions.assertTrue("Transportation Personnel".equals(UsersType.transportationPersonnel.toString()));
        Assertions.assertTrue("Branch Employee".equals(UsersType.employee.toString()));
    }
}