import java.util.Scanner;

public class ExNumber8 {

    public static void main(String[] args) {
        System.out.println("The most popular string is : " + theMostPopularSubString(stringUserInput()));
    }

    public static int countSizeArraySubString(String str) {
        int size = 0;
        for (int i = 1; i < str.length(); i++) {
            size = i + size;
        }
        return size;
    }

    public static String[] subStringPossible(String str) {
        int size = countSizeArraySubString(str);
        String[] subStingOptions = new String[size];
        for (int i = 0, k = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                subStingOptions[k] = subString(i, j, str);
                k++;
            }
        }
        return subStingOptions;
    }

    public static String subString(int start, int finish, String str) {
        String split = "";
        for (int i = start; i <= finish; i++) {
            split += str.charAt(i);
        }
        return split;
    }

    public static String theMostPopularSubString(String[] strings) {
        String[] split;
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            count += countSizeArraySubString(strings[i]);
        }
        String[] splitSubStringOption = new String[count];
        for (int i = 0, k = 0; i < strings.length; i++) {
            split = subStringPossible(strings[i]);
            for (int j = 0; j < split.length; j++) {
                splitSubStringOption[k] = split[j];
                k++;
            }
        }
        int max = 0;
        int index = 0;
        int sumOfRepeat = 0;
        for (int i = 0; i < splitSubStringOption.length; i++) {
            sumOfRepeat = 0;
            for (int j = i + 1; j < splitSubStringOption.length; j++) {
                if (isEquals(splitSubStringOption[i], splitSubStringOption[j])) {
                    sumOfRepeat++;
                    if (sumOfRepeat > max) {
                        max = sumOfRepeat;
                        index = i;
                    }
                }
            }
        }
        return splitSubStringOption[index];
    }

    public static boolean isEquals(String str1, String str2) {
        boolean equals = false;
        if (str1.length() == str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    equals = true;
                } else {
                    equals = false;
                    break;
                }
            }
        }
        return equals;
    }

    public static String[] stringUserInput() {
        Scanner scanner = new Scanner(System.in);
        String text;
        int count = 0;
        String allTheStringsFromUser = "";
        do {
            System.out.println("Enter a string : ");
            text = scanner.nextLine();
            if (text.length() >= 4) {
                count++;
                allTheStringsFromUser += text + " ";
            }
        } while (text.length() >= 4);
        text = "";
        String[] userInputStrings = new String[count];
        for (int i = 0, j = 0; i < allTheStringsFromUser.length(); i++) {
            if (allTheStringsFromUser.charAt(i) != ' ') {
                text += allTheStringsFromUser.charAt(i);
            } else {
                userInputStrings[j] = text;
                text = "";
                j++;
            }
        }
        return userInputStrings;
    }
}