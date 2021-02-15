package CodingExercises;

import javax.management.RuntimeErrorException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.zip.DeflaterInputStream;

public class Tobogganing {

    private static int[] getNumberInput(int inputSize) {

        Scanner myScanner = new Scanner(System.in);

        while (true) {

            String[] userNumbers = myScanner.nextLine().split(" ");
            int[] numberValues = new int[userNumbers.length];
            boolean validInput = true;

            for (int i = 0; i < userNumbers.length; i++) {

                try {
                    int testCase = Integer.parseInt(userNumbers[i]);
                    if (!(1 <= testCase && testCase <= 100)) throw new java.lang.RuntimeException("IncorrectSizeError");
                    numberValues[i] = testCase;
                } catch (Exception e) {
                    validInput = false;
                    System.out.println("SyntaxError: Input must be all (whole) numbers & must be between 1-100 inclusive");
                }

            }

            if (validInput && numberValues.length == inputSize) return numberValues;
            else System.out.println("SyntaxError: Input must be 4 values long");

        }
    }

    public static void main(String[] args) {

        // Get Number Input
        int[] userInput = getNumberInput(4);

        // Pull integers from Array
        int numD = userInput[0]; // Distance to top of hill
        float numC = userInput[1]; // Distance climbed per attempt (initial amount)
        int numS = userInput[2]; // Distance slid per fall
        int numF = userInput[3]; // Fatigue factor in %

        int climbAttempts = 0;
        float distancePerFatigue = numC * ((float) numF / 100);
        float distanceClimbed = 0;
        float distancePerClimb = numC;

        do {
            // Climb the hill & tick the climb iterator
            climbAttempts += 1;

            float currentIterClimbed = distancePerClimb;

            // Update the distance if the climb was >0
            if (currentIterClimbed > 0.0) distanceClimbed += currentIterClimbed;

            // Fall every time if we haven't reached the top
            if (distanceClimbed < numD) distanceClimbed = (float) Math.round((distanceClimbed - numS) * 10) / 10;

            // Subtract distance per climb by fatigue factor
            distancePerClimb = (float) Math.round((distancePerClimb - distancePerFatigue) * 10) / 10;

        // Run as long as he hasn't fallen to the bottom or climbed to the top
        } while (distanceClimbed >= 0 && distanceClimbed < numD);

        // Never allow a negative climb amount, limit to 0
        distanceClimbed = Math.max(0, distanceClimbed);

        System.out.println(
                ((distanceClimbed > 0) ? "SUCCESS ON ATTEMPT " : "FAILURE ON ATTEMPT ") +  climbAttempts + " (" + distanceClimbed + "m climbed)"
        );
    }



}
