package GuessingGameAndCalculator;

import java.util.Scanner;
import java.util.ArrayList;


public class guessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int secretNumber = (int)Math.floor(Math.random() * 100);
//        System.out.println(secretNumber);

        ArrayList<Integer> tries = new ArrayList<>();

        System.out.println("Guess the secret number. Empty input to quit");

        startGuessing(scanner, secretNumber, tries);
    }

    private static void startGuessing(Scanner scanner, int secretNumber, ArrayList<Integer> tries) {
        while (true) {
            String input = scanner.nextLine();
            if (inputIsEmpty(secretNumber, tries, input)) break;

            int guess = Integer.parseInt(input);

            if (guessOutOfBounds(guess)) continue;

            if (triedTheSameNumberConsecutively(tries, guess)) continue;

            tries.add(guess);

            if (guessedTheSecretNumber(secretNumber, tries, guess)) break;

            getMessageIfNotGuessed(secretNumber, guess);

        }
    }

    private static boolean inputIsEmpty(int secretNumber, ArrayList<Integer> tries, String input) {
        if (input.isEmpty()) {

            if (tries.size() == 0) {
                System.out.println("Sorry to see you give up before you even started. The secret number was " + secretNumber);
            }   else if (tries.size() == 1) {
                System.out.println("Sorry to see you give after just 1 try. The secret number was " + secretNumber);
            }   else {
                System.out.println("Sorry to see you give up after " + tries.size() + " tries. The secret number was " + secretNumber);
            }

            return true;
        }
        return false;
    }

    private static boolean guessOutOfBounds(int guess) {
        if (guess <= 0 || guess > 100) {
            System.out.println("Clue: The secret number can be any strictly positive number up to and including 100. This guess doesn't count. Guess again");
            return true;
        }
        return false;
    }

    private static boolean triedTheSameNumberConsecutively(ArrayList<Integer> tries, int guess) {
        if (tries.size() > 0 && tries.get(tries.size() - 1).equals(guess)) {
            System.out.println("You've put in the same number, it still isn't the one. This doesn't count as another try. Guess again");
            return true;
        }
        return false;
    }

    private static boolean guessedTheSecretNumber(int secretNumber, ArrayList<Integer> tries, int guess) {
        if (guess == secretNumber) {
            if (tries.size() == 1) {
                System.out.println("Have you tried playing the lotto? You've guessed it on your first try!");
            }   else {
                System.out.println("It took " + tries.size() + " tries, but you've guessed it, good effort!");
            }
            return true;
        }
        return false;
    }

    private static void getMessageIfNotGuessed(int secretNumber, int guess) {
        if (guess < secretNumber) {
            System.out.println("Nope. Aim bigger");
        }

        if (guess > secretNumber) {
            System.out.println("Nope. Aim smaller");
        }
    }
}
