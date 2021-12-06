package my_practice.cargo_company.users;

public enum UsersType {
    administrator("Administrator"),
    employee("Branch Employee"),
    transportationPersonnel("Transportation Personnel"),
    customer("Customer");

    private String type ;
    UsersType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
