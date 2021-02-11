package Level2;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class MyABCs {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        String rawInput;
        String[] rawCharacters;
        Map<String, Integer> myChars = new TreeMap<>();

        while (true) {

            while (true) {
                System.out.print("Input: ");
                rawInput = myScanner.nextLine();

                if (rawInput.length() > 255) {
                    System.out.println("Too long, must be <= 255, try again.");
                } else {
                    break;
                }
            }

            if (rawInput.toLowerCase(Locale.ROOT).equals("stop")) break;

            rawCharacters = rawInput.split("");

            for (String currentChar: rawCharacters) {

                // Skip if not alphanumeric
                if (!currentChar.matches("([a-zA-Z])")) continue;

                // Convert to lowercase
                currentChar = currentChar.toUpperCase(Locale.ROOT);

                // Get current val from Dictionary (the python in me lol)
                Integer currentCount = myChars.get(currentChar);

                // If null, override to 0
                if (currentCount == null) currentCount = 0;

                // Add 1 to the char at that position
                myChars.put(currentChar, currentCount + 1);

            }

            String outputString = "";

            for (Map.Entry<String, Integer> currentEntry : myChars.entrySet()) {

                outputString = outputString.concat(currentEntry.getKey() + "-" + currentEntry.getValue() + " ");

            }

            System.out.println("Output: " + outputString);


        }

    }
}
