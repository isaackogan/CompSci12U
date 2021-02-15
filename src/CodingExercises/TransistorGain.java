package CodingExercises;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransistorGain {

    public static void main(String[] args) {

        AtomicBoolean runProgram = new AtomicBoolean(true);

        do {
            // Creating the Scanner (..object? idk, python makes this confusing)
            Scanner myScanner = new Scanner(System.in);

            // Getting user Input
            System.out.print("Enter the amount of collector current (in Amperes): ");
            double collCurrent = myScanner.nextDouble();

            if (collCurrent == 0) runProgram.set(false);

            System.out.print("Enter the amount of base current (in Amperes): ");
            double baseCurrent = myScanner.nextDouble();

            // Math & Display
            double currentGain = collCurrent / baseCurrent;
            System.out.println("The current gain is " + currentGain);

        } while (runProgram.get());
    }


}
