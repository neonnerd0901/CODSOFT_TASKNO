import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRoundsWon = 0;
        String playAgain;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {
            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("\nAttempt " + attempt + "/" + maxAttempts
                        + " - Enter your guess: ");

                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    attempt--;
                    continue;
                }

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    System.out.println("You guessed it in " + attempt + " attempt(s).");

                    totalRoundsWon++;
                    guessedCorrectly = true;
                    break;
                } 
                else if (guess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } 
                else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nSorry! You ran out of attempts.");
                System.out.println("The correct number was: " + targetNumber);
            }

            System.out.println("\nRounds won: " + totalRoundsWon);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n=================================");
        System.out.println("          GAME OVER");
        System.out.println("Rounds Won: " + totalRoundsWon);
        System.out.println("Thanks for playing!");
        System.out.println("=================================");

        scanner.close();
    }
}