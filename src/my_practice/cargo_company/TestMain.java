package my_practice.cargo_company;

import my_practice.cargo_company.users.Administrator;

public class TestMain {
    public static void main(String[] args) {
        Administrator administrator = new Administrator("Samet","Yıldız");
        administrator.printBranches();

        administrator.addBranch("Esatpaşa Şubesi" , 34705 , "2D",1);

        administrator.printBranches();


    }
}
