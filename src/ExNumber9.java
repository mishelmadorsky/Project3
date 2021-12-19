import java.util.Random;
import java.util.Scanner;

public class ExNumber9 {
    public static final int SECRET_CODE_SIZE = 4;
    public static final String WIN = "you win!";

    public static void main(String[] args) {
        playAGame();
    }

    public static int[] theSecretCode() {
        Random random = new Random();
        int[] secretNumber = new int[SECRET_CODE_SIZE];
        for (int i = 0; i < secretNumber.length; i++) {
            secretNumber[i] = random.nextInt(6) + 1;
        }
        for (int i = 0; i < secretNumber.length; i++) {
            for (int j = i + 1; j < secretNumber.length; j++) {
                if (secretNumber[i] == secretNumber[j]) {
                    secretNumber = theSecretCode();
                    break;
                }
            }
        }
        return secretNumber;
    }

    public static int runOption() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int turnCounter = 0;
        do {
            System.out.println("You Need To guess what is the secret code ? \n Easy run : choose 1 (20 opportunity) \n Medium run : choose 2 (15 opportunity) \n" +
                    " Hard run : choose 3 (10 opportunity) \n Special run : choose 4 (5-25 opportunity) ");
            choice = scanner.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid option. try again!");
            }
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                turnCounter = 20;
                break;
            case 2:
                turnCounter = 15;
                break;
            case 3:
                turnCounter = 10;
                break;
            case 4:
                Random random = new Random();
                turnCounter = random.nextInt(30) + 5;
                break;
        }
        return turnCounter;
    }

    public static int[] guessTheSecretNumber() {
        Scanner scanner = new Scanner(System.in);
        int[] guessNumber = new int[SECRET_CODE_SIZE];
        System.out.println("Enter the secret code");
        int userGuess = scanner.nextInt();
        if (userGuess < 1000 || userGuess > 9999) {
            System.out.println("Exactly 4 numbers!");
            guessNumber = guessTheSecretNumber();
        } else {
            int i = 3;
            while (userGuess != 0) {
                int unit = userGuess % 10;
                userGuess = userGuess / 10;
                if (unit < 1 || unit > 6) {
                    System.out.println("Only 1-6!");
                    guessNumber = guessTheSecretNumber();
                    break;
                } else {
                    guessNumber[i] = unit;
                    i--;
                }
            }
        }
        return guessNumber;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    public static boolean checkDuplicates(int[] userGuess) {
        boolean duplicates = false;
        int count = 0;
        for (int i = 0; i < userGuess.length; i++) {
            if (count >= 1) {
                break;
            }
            for (int j = i + 1; j < userGuess.length - 1; j++) {
                if (userGuess[i] == userGuess[j]) {
                    count++;
                    duplicates = true;
                    break;
                }
            }
        }
        return duplicates;
    }

    public static String partialGuessAndFullGuess(int[] input, int[] realSecretNumber) {
        int countReal = 0;
        int countPartial = 0;
        String message = "";
        for (int i = 0; i < realSecretNumber.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (realSecretNumber[i] == input[j] && i == j) {
                    countReal++;
                }
                if (realSecretNumber[i] == input[j] && i != j) {
                    countPartial++;
                }
            }
        }
        if (countReal != 4) {
            if (countReal >= 1) {
                message += "there is " + countReal + "of real guess \n";
                if (countPartial >= 1) {
                    message += "there is " + countPartial + "of partial guess";
                }
                if (checkDuplicates(input)) {
                    message += "\n there is duplicated in the number you guess";
                }
            }
        }
        if (countReal == 4) {
            message = WIN;
        }
        return message;
    }

    public static void playAGame() {
        int turn = runOption();
        int[] guessNumber = theSecretCode();
        String message = "";
        while (turn != 0) {
            int[] userChoice = guessTheSecretNumber();
            if (checkDuplicates(userChoice)) {
                turn -= 2;
            }
            message = partialGuessAndFullGuess(userChoice, guessNumber);
            if (equalsString(message, WIN)) {
                System.out.println(message);
                break;
            } else {
                System.out.println(message);
                turn--;
                System.out.println("you have more " + turn + " turn");
            }
        }
        if (turn == 0 && !equalsString(message, WIN)) {
            System.out.println("you lost in this game. the secret number is: ");
            print(guessNumber);
        }
    }

    public static boolean equalsString(String str1, String str2) {
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
}