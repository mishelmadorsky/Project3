public class ExNumber1 {

    public static void main(String[] args) {
        int  [] number = {11,13,11,44};
        System.out.println(arrayOfNumbers(number));
    }

    public static boolean aCorrectAlternatingNumber(int number){
        while (number % 10 !=0){
            if ((number % 10) % 2 == 0){
                number = number/10;
                if ((number % 10) % 2 == 0){
                    return false;
                }
            }
            else if ((number % 10) % 2 != 0){
                number = number/10;
                if ((number % 10) % 2 != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static int arrayOfNumbers(int[] array) {
        int[] array1 = new int[array.length];
        int index = -1;
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            array1[i] = sumInt(array[i]);
        }
        for (int i = 0; i < array1.length; i++) {
            if (min == 0) {
                if (aCorrectAlternatingNumber(array[i])) {
                    min = array1[i];
                    index = i;
                }
            } else {
                if (aCorrectAlternatingNumber(array[i])) {
                    if (array1[i] < min) {
                        min = array1[i];
                        index = i;
                    }
                }
            }
        }
        return index;
    }
    public static int sumInt (int num){
        int sum= 0;
        while (num%10!=0){
            sum = num%10 +sum;
            num= num/10;
        }
        return sum;
    }
}