package CodingExercises;
import java.util.Locale;
import java.util.Scanner;

public class RockPaperScissors {

    public static int getRoundWinner(String roundString) {

        String validChars = "RPS";
        String regexString = String.format("([%s]{2})", validChars);

        // Validate Input
        if (roundString.length() > 2 || !roundString.matches(regexString)) return  -1;

        // Getting the indexes for their characters
        int p1InputIndex = validChars.indexOf(roundString.charAt(0)), p2InputIndex = validChars.indexOf(roundString.charAt(1));

        // Performing math to determine winners (modulus lets us create a circle R -> P -> S -> R -> ...)
        return p1InputIndex == p2InputIndex ? 0 : ((p1InputIndex + 1) % 3 == p2InputIndex % 3 ? 2 : 1);

    }

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        boolean runGame = true;

        String userInput;
        String[] gameRounds;

        System.out.print("Welcome to my game! ");

        // Game Loop
        while (runGame) {

            int p1RoundsWon = 0, p2RoundsWon = 0;
            System.out.print("Please input the round data: ");

            // Get Input
            while (true) {

                userInput = myScanner.nextLine().toUpperCase(Locale.ROOT);

                // Length Check
                if (userInput.length() > 255) {
                    System.out.print("Invalid input, try again (<255 chars): ");

                // If still here, valid string
                } else {

                    // If we're quitting
                    if (userInput.equals("G")) runGame = false;

                    // Break no matter what since string is valid
                    break;
                }
            }

            // Break if runGame is false
            if (!runGame) break;

            // Split into string array at spaces
            gameRounds = userInput.split(" ");

            // Iterate through entries in the array
            for (String currentRound: gameRounds) {

                // Stop after 2 rounds won
                if (p1RoundsWon == 2 || p2RoundsWon == 2) break;

                // Add point to winner
                if (getRoundWinner(currentRound) == 1) p1RoundsWon += 1;
                if (getRoundWinner(currentRound) == 2) p2RoundsWon += 1;

            }

            // Print the Winner
            System.out.println(
                    (p1RoundsWon > p2RoundsWon) ? "PLAYER ONE " + p1RoundsWon : (p2RoundsWon > p1RoundsWon)
                    ? "PLAYER TWO " + p2RoundsWon : "GAME TIE " + p1RoundsWon + ":" + p2RoundsWon
            );

        }

    }

}

