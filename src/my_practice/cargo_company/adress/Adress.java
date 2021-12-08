package my_practice.cargo_company.adress;

import java.util.Scanner;

public class Adress {
    private final Scanner scanner = new Scanner(System.in);
    private String aparmentNo;
    private int doorNo;
    private ZipCode zipCode;


    /*
    TODO check the zipCode == Null in employee
     */

        public Adress(int zipCode, String aparmentNo, int doorNo) {
            if(ZipCodeArhcive.checkZipCode(zipCode)){
                this.zipCode = ZipCodeArhcive.getAdressInfo(zipCode);
            }
            else{
                String[] adress = getAdressInfo();
                this.zipCode = ZipCodeArhcive.addNewZipCode(zipCode, adress[0], adress[1], adress[2]);
            }
            this.aparmentNo = aparmentNo;
            this.doorNo = doorNo;
    }
    private String[] getAdressInfo(){
            //String city, String state, String neighborhood
        String[] adress = new String[3];
        System.out.print("City : ");
        adress[0] = scanner.nextLine();
        System.out.print("\nState : ");
        adress[1] = scanner.nextLine();
        System.out.print("\nNeighborhood : ");
        adress[2] = scanner.nextLine();
        return adress;
    }

    @Override
    public String toString() {
        return zipCode.toString() + "\n" +
                "Apartment No : " + aparmentNo + "\n" +
                "Door No      : " + doorNo;
    }
}
