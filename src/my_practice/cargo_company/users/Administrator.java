package my_practice.cargo_company.users;

import my_practice.cargo_company.adress.Adress;
import my_practice.cargo_company.branches.Branch;
import my_practice.cargo_company.utils.Tools;

import java.util.HashMap;
import java.util.Map;


public class Administrator extends Users {
  private final Map<Integer,Branch> branches ;

  public Administrator(String name, String surname) {
      super(name, surname , UsersType.administrator);
      branches = new HashMap<>();
      int branchCode1 = 4648, branchCode2 = 6743, branchCode3 = 4745;
      branches.put(branchCode1, new Branch("Örnek Mah. Şubesi" , new Adress(34704,  "23/A-B" , 1 ), branchCode1 ));
      branches.put(branchCode2, new Branch("Caferağa Şubesi" , new Adress(34734,  "2" , 1 ), branchCode2 ));
      branches.put(branchCode3, new Branch("Bağlarbaşı Şubesi" , new Adress(34722,  "45A" , 1 ), branchCode3));
    }

    public void addBranch(String brachName ,int zipCode, String aparmentNo, int doorNo){
        int brachCode = uniqueBranchCode();
        branches.put( brachCode,new Branch(brachName , new Adress(zipCode, aparmentNo, doorNo) , brachCode));
    }
    public boolean removeBranch(int branchCode){
          if(!branches.containsKey(branchCode))
              return false;
          branches.remove(branchCode);
          return true;
    }

    public void printBranches() {
        branches.forEach((key, value) -> System.out.printf("%s\n", value));
    }
    public void printBranchInfo(int branchCode){
        branches.get(branchCode).printBranchInfo();
    }
    public void addPersonelToBranch(int branchCode, String name, String surname, UsersType usersType){
      branches.get(branchCode).addPersonnel(
              switch (usersType){
                  case employee -> new Employee(name,surname);
                  case transportationPersonnel -> new Transporter(name,surname);
                  default -> null;
              }
      );
    }

    private int uniqueBranchCode (){
        int branchCode = Integer.parseInt(Tools.randomID(4));
        return branches.containsKey(branchCode) ? uniqueBranchCode() : branchCode;

    }



}
