package my_practice.cargo_company.users;

public class Transporter extends Users{
    public Transporter(String name, String surname) {
        super(name, surname, UsersType.transportationPersonnel);
    }
}
