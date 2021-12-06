package my_practice.cargo_company.adress;

public class Adress {
    private String aparmentNo;
    private int doorNo;
    private ZipCode zipCode;


    /*
    TODO check the zipCode == Null in employee
     */

    public Adress(int zipCode, String aparmentNo, int doorNo) {
        this.zipCode = ZipCodeArhcive.getAdressInfo(zipCode);
        this.aparmentNo = aparmentNo;
        this.doorNo = doorNo;
    }
    public Adress(String city, String state, String neighborhood, String aparmentNo, int doorNo) {
        int newZipCode = ZipCodeArhcive.addNewZipCode(city, state, neighborhood);
        this.zipCode = ZipCodeArhcive.getAdressInfo(newZipCode);
        this.aparmentNo = aparmentNo;
        this.doorNo = doorNo;
    }

    @Override
    public String toString() {
        return zipCode.toString() + "\n" +
                "Apartment No : " + aparmentNo + "\n" +
                "Door No      : " + doorNo;
    }
}
