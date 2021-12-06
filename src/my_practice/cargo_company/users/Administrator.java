package my_practice.cargo_company.users;

import com.my_practice.cargo_company.adress.Adress;
import com.my_practice.cargo_company.branches.Branch;
import com.my_practice.cargo_company.utils.Tools;

import java.util.HashMap;
import java.util.Map;


public class Administrator extends Users {
    private Map<Integer,Branch> branches = new HashMap(){{
        int branchCode1 = uniqueBranchCode(), branchCode2 = uniqueBranchCode(), branchCode3 = uniqueBranchCode();
        put(branchCode1,new Branch("Örnek Mah. Şubesi" , new Adress(34704,  "23/A-B" , 1 ), branchCode1 ));
        put(branchCode2,new Branch("Caferağa Şubesi" , new Adress(34734,  "2" , 1 ), branchCode2 ));
        put(branchCode3,new Branch("Bağlarbaşı Şubesi" , new Adress(34722,  "45A" , 1 ), branchCode3));
    }};
    public Administrator(String name, String surname) {
        super(name, surname , UsersType.administrator);
    }

    public void addBranch(String brachName ,int zipCode, String aparmentNo, int doorNo){
        int brachCode = uniqueBranchCode();
        branches.put( brachCode,new Branch(brachName , new Adress(zipCode, aparmentNo, doorNo) , brachCode));
    }
    public void removeBranch(int branchCode){
        branches.remove(branchCode);
    }

    private int uniqueBranchCode (){
        int branchCode = Integer.parseInt(Tools.randomID(4));
        return branches.containsKey(branchCode) ? uniqueBranchCode() : branchCode;

    }

}
