package lab1;

import java.util.Scanner;

// This is the main class that interacts with the user
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicCalculator calculator = new BasicCalculator();
        boolean keepRunning = true;

        System.out.println("Welcome to the Basic Calculator!");

        // Repeat the menu until the user wants to exit
        while (keepRunning) {
            // Show the menu options
            System.out.println("\nChoose an operation:");
            System.out.println("1: Addition");
            System.out.println("2: Subtraction");
            System.out.println("3: Multiplication");
            System.out.println("4: Division");
            System.out.println("5: Exit");
            System.out.print("Select (1-5): ");

            String choice = scanner.nextLine();

            // Check if the choice is between 1 and 5
            if (!choice.matches("[1-5]")) {
                System.out.println("Invalid option. Please select a number between 1 and 5.");
                continue; // Go back to the menu
            }

            // If the user selects 5, exit the program
            if (choice.equals("5")) {
                keepRunning = false;
                continue;
            }

            double num1, num2;

            // Ask the user to enter two numbers
            try {
                System.out.print("Enter the first number: ");
                num1 = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter the second number: ");
                num2 = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Handle non-numeric input
                System.out.println("Invalid input! Please enter valid numbers.");
                continue; // Go back to the menu
            }

            // Perform the selected operation and show the result
            try {
                double result = 0;

                switch (choice) {
                    case "1":
                        result = calculator.add(num1, num2);
                        break;
                    case "2":
                        result = calculator.subtract(num1, num2);
                        break;
                    case "3":
                        result = calculator.multiply(num1, num2);
                        break;
                    case "4":
                        result = calculator.divide(num1, num2);
                        break;
                }

                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                // Handle division by zero error
                System.out.println("Error: " + e.getMessage());
            }

            // Ask if the user wants to do another calculation
            System.out.print("Do another calculation? (yes/no): ");
            String again = scanner.nextLine().toLowerCase();
            keepRunning = again.equals("yes");
        }

        // Exit message
        System.out.println("Thank you for using the Basic Calculator!");
        scanner.close();
    }
}
