package GuessingGameAndCalculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculator loaded. Supported operations: (+) (-) (*) (/) (%).");
        System.out.println("Enter the 3 elements of the operation (the first number, the operand and the second number), separated by commas (ex.: 1, +, 1 or 1,-,1): ");

        String operation = scanner.nextLine();

        if (operation.isEmpty()) {
            System.out.println("The input was empty. Operation cancelled.");
            return;
        }

        operation = operation.replaceAll("\\s", "");

        String[] elements = operation.split(",");


        if (elements.length != 3) {
            System.out.println("The input was in an unaccepted format. Accepted input format: (1, +, 1) or (1,/,1).");
            return;
        }

        int firstNumber = Integer.parseInt(elements[0]);
        String operator = elements[1];
        int secondNumber = Integer.parseInt(elements[2]);


        if (!isAcceptedOperator(operator)) {
            System.out.println("That operation is not implemented by this calculator (Accepted operations: (+) (-) (*) (/) (%).");
            return;
        }

        performOperation(firstNumber, secondNumber, operator);

    }

    public static boolean isAcceptedOperator(String operator) {
        boolean isAccepted = false;
        String[] operators = {"+", "-", "*", "/", "%"};

        for (String operation: operators) {
            if (operation.equals(operator)) {
                isAccepted = true;
                break;
            }
        }

        return isAccepted;
    }

    public static void performOperation(int firstNumber, int secondNumber, String operator) {

        switch (operator) {
            case "%":
                System.out.println(firstNumber % secondNumber);
                break;
            case "+":
                System.out.println(firstNumber + secondNumber);
                break;
            case "-":
                System.out.println(firstNumber - secondNumber);
                break;
            case "*":
                System.out.println(firstNumber * secondNumber);
                break;
            case "/":
                if (secondNumber != 0) {
                    System.out.println(1.0 * firstNumber / secondNumber);
                }   else {
                    System.out.println("Division by 0 is impossible.");
                }
        }
    }
}

