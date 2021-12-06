package my_practice.cargo_company.branches;



import my_practice.cargo_company.adress.Adress;
import my_practice.cargo_company.users.Employee;
import my_practice.cargo_company.users.Transporter;
import my_practice.cargo_company.users.Users;
import my_practice.cargo_company.users.UsersType;

import java.util.HashMap;
import java.util.Map;

public class Branch {
    private final Map<String, Employee> branchEmployees;
    private final Map<String, Transporter> branchTransporters;

    private final String branchName;
    private final Adress adress;
    private final int branchCode;

    public Branch(String branchName, Adress adress, int branchCode) {
        this.branchName = branchName;
        this.adress = adress;
        this.branchCode = branchCode;

        branchEmployees = new HashMap<>();
        branchTransporters = new HashMap<>();
    }

    public <T extends Users> boolean addPersonnel(T personnel){
        if(personnel instanceof Employee employee)
            branchEmployees.put(employee.getID() , employee );

        else if(personnel instanceof Transporter transporter)
            branchTransporters.put(transporter.getID() , transporter );
        else return false;

        return true;
    }

    public boolean removePersonnel(int ID, UsersType usersType){
        switch (usersType){
            case employee -> branchEmployees.remove(ID);
            case transportationPersonnel -> branchTransporters.remove(ID);
            default ->{ return false;}
        }
        return true;
    }
    //TODO
    public void printBranchInfo(){
        System.out.println(this);
        System.out.println("******************************");
        System.out.println("******************************");

    }

    @Override
    public String toString() {
        return String.format("%11s : %s \n" +
                             "%11s : %d \n" +
                             "%11s :\n %s \n" ,"Branch Name" , branchName,
                                               "Branch Code" , branchCode,
                                               "Adress"      , adress  );
    }

    public void printPersonnelList(Class<? extends Users>  type){
        HashMap<String , ?> personnels ;
        if(type.isAssignableFrom(Employee.class))
            personnels = (HashMap<String, ?>) branchEmployees;
        else if (type.isAssignableFrom(Employee.class))
            personnels = (HashMap<String, ?>) branchTransporters;
        else throw new NullPointerException();

        personnels.forEach((key, value) -> System.out.printf("%s -> %s\n" , key , value));

    }
}
