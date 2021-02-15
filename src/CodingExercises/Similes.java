package CodingExercises;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Similes {

    private static int getNumberInput() {
        Scanner numberScanner = new Scanner(System.in);
        String userInput;

        // Forever until valid
        while (true) {
            // Get a line
            userInput = numberScanner.nextLine();

            // Verify that the line is an integer & return if so, continue in loop if not
            try {
                return Integer.parseInt(userInput);
            } catch (Exception NumberFormatException) {
                System.out.println("Must be a whole number, try again.");
            }

        }

    }

    private static String[] getMultipleStringInput(int numberOfInputs) {

        // Create empty array for String input
        Scanner stringScanner = new Scanner(System.in);
        String[] userInputArray = new String[] {};

        // Until the array is filled to the requested number
        while (userInputArray.length != numberOfInputs) {

            // Extend the array and get the input
            userInputArray = Arrays.copyOf(userInputArray, userInputArray.length + 1);
            userInputArray[userInputArray.length - 1] = stringScanner.nextLine();

        }

        // Return the valid array, e.g. ["hi, "bye", "ok"] if numberOfInputs is 3
        return userInputArray;
    }


    public static void main(String[] args) {

        // Get No. of Adjectives
        System.out.println("How many adjectives would you like to enter?");
        int adjectiveCount = getNumberInput();

        // Get No. of Nouns
        System.out.println("How many nouns would you like to enter?");
        int nounCount = getNumberInput();

        // Get Adjectives
        System.out.println("Please input " + adjectiveCount + " adjectives:");
        String[] adjectives = getMultipleStringInput(adjectiveCount);

        // Get Nouns
        System.out.println("Please input " + nounCount + " nouns:");
        String[] nouns = getMultipleStringInput(nounCount);

        // Iterate through noun array
        for (String adjective : adjectives) {

            // Iterate through adjective array
            for (String noun : nouns) {

                // Print current iteration of adjective at current iteration of Noun
                System.out.println(adjective.substring(0, 1).toUpperCase(Locale.ROOT) + adjective.substring(1) + " as " + noun + ".");
            }

        }

    }

}
