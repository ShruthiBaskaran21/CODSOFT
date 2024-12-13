import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRoundsWon = 0;
        String playAgain;

        do {
            // Generate a random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1;
            int maxAttempts = 10; // Limit of 10 attempts
            int attemptsLeft = maxAttempts;
            boolean correctGuess = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsLeft > 0 && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                // Compare the user's guess with the generated number
                if (userGuess == numberToGuess) {
                    correctGuess = true;
                    System.out.println("Congratulations! You've guessed the correct number.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                    System.out.println("You have " + attemptsLeft + " attempts left.");
                } else {
                    System.out.println("Your guess is too high.");
                    System.out.println("You have " + attemptsLeft + " attempts left.");
                }
            }

            // Check if the user ran out of attempts without guessing the number
            if (!correctGuess) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + numberToGuess + ".");
            }

            // Update score based on whether the user won or lost
            if (correctGuess) {
                totalRoundsWon++;
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        // Display total rounds won
        System.out.println("Thanks for playing! You won " + totalRoundsWon + " round(s).");
        scanner.close();
    }
}
