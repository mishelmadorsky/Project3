import java.util.Scanner;
public class ExNumber5 {

    public static void main(String[] args) {
        System.out.println(changeChar());
    }

    public static char maxChar(String str1) {
        int counter = 0;
        int maxRepetition = 0;
        char maxChar = ' ';
        for (int i = 0; i < str1.length(); i++) {
            counter = numberOfRepetition(str1, str1.charAt(i));
            if (counter > maxRepetition) {
                maxRepetition = counter;
                maxChar = str1.charAt(i);
            }
        }
        return maxChar;
    }

    public static int numberOfRepetition(String str1, char charToCheck) {
        int counter = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == charToCheck) {
                counter++;
            }
        }
        return counter;
    }

    public static char theSecondMostCommonChar(String str1) {
        int counter = 0;
        char maxChar = maxChar(str1);
        int max = numberOfRepetition(str1, maxChar);
        int theSecondMostCommonCharCounter = 0;
        char theSecondMostCommonChar = ' ';
        for (int i = 0; i < str1.length(); i++) {
            counter=numberOfRepetition(str1, str1.charAt(i));
            if (counter == max && str1.charAt(i) != maxChar) {
                theSecondMostCommonChar = str1.charAt(i);
                break;
            }
            if (counter < max && counter > theSecondMostCommonCharCounter) {
                theSecondMostCommonCharCounter = counter;
                theSecondMostCommonChar = str1.charAt(i);
            }
        }
        return theSecondMostCommonChar;
    }

    public static String changeChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string:");
        String str1 = scanner.nextLine();
        String newStr = "";
        char maxChar = maxChar(str1);
        char theSecondCommonChar = theSecondMostCommonChar(str1);
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != theSecondCommonChar && str1.charAt(i) != maxChar) {
                newStr += str1.charAt(i);
            } else if (str1.charAt(i) == theSecondCommonChar) {
                newStr += maxChar;
            } else if (str1.charAt(i) == maxChar) {
                newStr += theSecondCommonChar;
            }
        }
        return newStr;
    }
}