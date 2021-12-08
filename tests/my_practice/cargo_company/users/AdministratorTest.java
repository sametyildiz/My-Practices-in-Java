package my_practice.cargo_company.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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

    @Test
    void printBranches() {

        administrator.removeBranch(4745);

        administrator.printBranches();
    }

    @Test
    void printBranchInfo() {

        administrator.addPersonelToBranch(4745, "Samet2", "Yıldız", UsersType.employee);
        administrator.addPersonelToBranch(4745, "Samet3", "Yıldız", UsersType.employee);
        administrator.addPersonelToBranch(4745, "Samet4", "Yıldız", UsersType.transportationPersonnel);
        administrator.addPersonelToBranch(4745, "Samet5", "Yıldız", UsersType.transportationPersonnel);
        administrator.addPersonelToBranch(4745, "Samet6", "Yıldız", UsersType.transportationPersonnel);

        administrator.printBranchInfo(4745);
    }
}