public class ExNumber2 {

    public static void main(String[] args) {
        int [] arr = {1,14,15,16,18,22,24};
        int []arr2 = {4,1,1,14,15,16};
        System.out.println(" the index of the number from one array that has the most brothers from array 2 is : " + indexOfNumber(arr,arr2));
    }

    public static int sum(int num) {
        int sum = 0;
        while (num%10 != 0) {
            sum= num%10 +sum;
            num=num/10;
        }
        return sum;
    }

    public static int[] newArraySumOfNumbers(int[] arr1) {
        int[] newArray = new int[arr1.length];
       int value;
        for (int i = 0; i < arr1.length; i++) {
            value=sum(arr1[i]);
            newArray[i]=value;
        }
        return newArray;
    }

    public static void printArray (int []arr ){
        for (int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static int indexOfNumber (int []arr1, int [] arr2){
        int [] arr1Sum = newArraySumOfNumbers(arr1);
        int [] arr2Sum = newArraySumOfNumbers(arr2);
        int maxCounter =0;
        int index =-1;
        for (int i =0; i< arr1Sum.length; i++){
            int counter=0;
            for (int j =0; j< arr2Sum.length; j++){
                if (arr1Sum[i]==arr2Sum[j]) {
                    counter++;
                }
                if (j==arr2Sum.length-1 && counter>maxCounter){
                   if (counter>maxCounter){
                        maxCounter=counter;
                        index=i;
                    }
                }
            }
        }
        return index;
    }
}
