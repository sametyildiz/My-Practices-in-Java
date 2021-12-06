package my_practice.cargo_company.users;

import com.my_practice.cargo_company.utils.Tools;

import java.util.Objects;

public  class Users {
    private String ID;
    private String name, surname;
    private UsersType usersType;

    public Users(String name, String surname, UsersType usersType) {
        this.name = name;
        this.surname = surname;
        this.usersType = usersType;
        this.ID = giveID();
    }

    @Override
    public String toString() {
        return String.format(
                "ID        : %s\n" +
                "Name      : %s\n" +
                "Surname   : %s\n" +
                "User Type : %s \n" ,ID , name , surname , usersType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users that = (Users) o;
        return ID.equals(that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    String giveID() {
        return getUsersType().toString().substring(0,3).toUpperCase().concat((Tools.randomID(8)));
    }

    public UsersType getUsersType() {
        return usersType;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
