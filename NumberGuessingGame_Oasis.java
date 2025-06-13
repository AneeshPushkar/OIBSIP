import java.util.Scanner;
import java.util.Random;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(42);
        final int MAX_ATTEMPTS = 7;

        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("=== Welcome to the Number Guessing Game ===");

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(100)+1;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess=scanner.nextInt();;
                if (userGuess == numberToGuess) {
                    System.out.println(" Congratulations! You guessed it right.");
                    guessedCorrectly = true;
                    totalScore += attemptsLeft * 10; // score based on remaining attempts
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of attempts. The number was: " + numberToGuess);
            }

            roundsPlayed++;
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume leftover newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Your total score: " + totalScore);

        scanner.close();
    }
}