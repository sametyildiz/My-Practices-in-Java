package my_practice.parenthesis;

//Samet YILDIZ

public class CheckParenthesis {

    boolean checkParenthesis( String str){
         if(str instanceof String){
             int firstParent = 0;
             int secondParent = 0;
             int check = 0;
             while(check < str.length() && secondParent <= firstParent ){
                 if(str.charAt(check) == '(')//check firstParenthesis
                    firstParent++;
                 else if(str.charAt(check) == ')')//check secondParenthesis
                     secondParent++;
                 check++;
             }
             if(firstParent == secondParent)
                 return true;
         }

        return false;
    }

    void printChecked(String str){
        checkParenthesis("dd");
        System.out.println(str  + " is checked : " + checkParenthesis(str));
    }


    public static void main(String[] args) {
        CheckParenthesis checking = new CheckParenthesis();
        String str = null;//false
        checking.printChecked(str);
        str = "(a+b)*ac+d)";//false
        checking.printChecked(str);
        str = "((a + b + c ) * t) + b";//true
        checking.printChecked(str);
        str = "";//true
        checking.printChecked(str);
        str = ") a + b ) + (c * d)*( a - c )";//false
        checking.printChecked(str);
        str = "a + b + c" ;
        checking.printChecked(str);
        str = ")(";
        checking.printChecked(str);



    }

}
