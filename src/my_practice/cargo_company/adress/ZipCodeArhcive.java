package my_practice.cargo_company.adress;



import my_practice.cargo_company.utils.Tools;

import java.util.HashMap;
import java.util.Map;

public class ZipCodeArhcive {
    private static final Map<Integer , ZipCode> zipCodeMap = new HashMap<>(){{
        put(34704 , new ZipCode(34704 , "İstanbul" , "Ataşehir", "Örnek Mah."));
        put(34734 , new ZipCode(34734, "İstanbul" , "Kadiköy", "Caferağa Mah." ));
        put(34722 , new ZipCode(34722, "İstanbul" , "Üsküdar", "Bağlarbaşı Mah."));
    }};


    static ZipCode getAdressInfo(int zipCode){
        return zipCodeMap.getOrDefault(zipCode, null);
    }

    static int addNewZipCode(String city, String state, String neighborhood){
        int newZipCode = zipCodeGenerator();
        zipCodeMap.put(newZipCode , new ZipCode( newZipCode, city, state, neighborhood ) );
        return newZipCode;
    }

    private static boolean checkZipCode(int zipCode){
        return zipCodeMap.containsKey(zipCode);
    }

    private static int zipCodeGenerator(){
        int newZipCode = Integer.parseInt(Tools.randomID(5));
        return checkZipCode(newZipCode) ? zipCodeGenerator() : newZipCode;
    }


}
