package my_practice.cargo_company.users;

public class Employee extends Users {

    public Employee(String name, String surname) {
        super(name, surname, UsersType.employee);
    }

}
