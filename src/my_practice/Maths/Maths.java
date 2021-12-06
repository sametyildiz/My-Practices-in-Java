package my_practice.Maths;

public class Maths {
    String str ;
    /**
     * Parse the given mathematical equation with operation priority
     * @param input String equation
     * @return result of the equation
     */
    float MathematicalEquation(String input){
        if(input == null || input.isBlank() || input.isEmpty() )
            return Float.NaN;
        str = input.trim();
        float [] numbers = new float[str.length()];
        char[] operators = new char[str.length()];
        boolean[] isPrioriy = new boolean[str.length()];
        int i = 0 , j = 0 ;
        while(true){
            int index = i;
            i = skipChars(i);
            numbers[j]=Float.parseFloat(str.substring(index , i));

            i = skipSpace(++i);
            if(i >= str.length())
                break;

            operators[j]=str.charAt(i);
            if(operators[j] == '*' ||
            operators[j] == '/' ||
            operators[j] == '%')
                isPrioriy[j] = true;

            i= skipSpace(++i);

            j++;
        }
        int k = 0;
        for(; k < operators.length && operators[k] != '\0'; k++){
            if(!isPrioriy[k] && operators[k] == '-'){
                numbers[k+1] *= -1;
                continue;
            }
            else if(isPrioriy[k]){
                numbers[k+1] = switch(operators[k]) {
                    case '*' -> numbers[k] * numbers[k + 1];
                    case '/' -> numbers[k] / numbers[k + 1];
                    case '%' -> Math.floorMod((int)numbers[k] ,(int) numbers[k+1]);
                    default -> 0;
                };
                isPrioriy[k]=false;
                numbers[k]=0;
            }
            else
                continue;
        }
        return sum(numbers , k);
    }

    int skipChars(int i){
        while( i < str.length() && str.charAt(i) != ' ' ){
            i++;
        }
        return i;
    }
    int skipSpace(int i){
        while( i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        return i;
    }
    float sum(float[] numbers , int lastIndex){
        float sum = 0F;
        for(int f = 0 ; f <= lastIndex ; f++)
            sum += numbers[f];
    return sum;
    }



    int factorial(int num){
//        if(num == 0 || num == 1)
//            return 1;
//        return num * factorial(num - 1);
        return num == 0 || num == 1 ? 1 : num * factorial(num - 1);
    }

    int fibonnaci_1stSolve(int index){
//        if(index <= 2)
//            return 1;
//        return fibonnaci_1stSolve( index - 1) + (fibonnaci_1stSolve(index - 2));
        return index <= 2 ? 1 : fibonnaci_1stSolve( index - 1) + (fibonnaci_1stSolve(index - 2));
    }

    int fibonnaci_2ndSolve(int index ){
        int[] numbers = new int[Integer.max(index + 1 , 2)];
        numbers[0]=0;numbers[1]=1;
        return calculateFibo2(index , numbers);

    }
    private int calculateFibo2(int index , int[] numbers) {
        if (index >= 2 && numbers[index] == 0 )
            numbers[index] = calculateFibo2(index - 2 , numbers) + calculateFibo2(index - 1 , numbers);
        return numbers[index];
    }


    int fibonnaci_3rdSolve(int index){
        int[] numbers = {0,1};
        return calculateFibo3(numbers , index);
    }
    private int calculateFibo3(int[] numbers, int index){
        if(index < 2)
            return numbers[index];
        else{
            int i = 2;
            while (i <= index){
                int tmp = numbers[1];
                numbers[1] += numbers[0];
                numbers[0] = tmp;
                i++;
            }
            return numbers[1];
        }
    }
    //recurvise solution
    int fibonnaci_4thSolve(int index){
        return switch (index){
            case 0 -> 0;
            case 1 -> 1;
            default -> {
                int[] numbers = calculateFibo4(index);
                yield numbers[0] + numbers [1];
            }
        };
    }

    int[] calculateFibo4(int index){
        if(index == 2)
            return new int[]{0 , 1};
        else{
            int[] numbers = calculateFibo4( index - 1);
            int tmp = numbers[1];
            numbers[1] += numbers[0];
            numbers[0] = tmp;
            return numbers;
        }


    }




}
