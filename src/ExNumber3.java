import java.util.Scanner;

public class ExNumber3 {
    public static void main (String[] args){
        printArray(primeNumber(getNumber()));
    }

    public static int getNumber(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter a number");
        int number = scanner.nextInt();
        return number;
    }

    public static int[] primeNumber(int number){
        int part = 2;
        int i = 0;
        int count =0;
        int[] array=new int[30];
        while (number>=part){
            if (number%part==0){
                array[i]=part;
                number= number/part;
                count++;
                i++;
            }
            else {
                part++;
            }
        }
        int[] newArray = new int[count];
        for (i=0; i<newArray.length; i++){
            newArray[i]= array[i];
        }
        return newArray;
    }
    public static void printArray(int[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}