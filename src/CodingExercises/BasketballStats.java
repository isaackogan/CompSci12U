package CodingExercises;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class BasketballStats {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        Map<String, Double> basketballPlayers = new TreeMap<>();
        NumberFormat myFormatter = new DecimalFormat("#0.00");

        boolean repeatEntry;

        String playerName = "";
        int userEntries = 0;
        int playerShotAttempts = 0;
        int playerShotSuccesses = 0;


        while (userEntries != 4) {

            repeatEntry = true;

            while (repeatEntry) {

                try{
                    // Get Name
                    playerName = myScanner.nextLine().toUpperCase(Locale.ROOT);

                    // Get Shot Attempts
                    playerShotAttempts = myScanner.nextInt();

                    // Get Shot Successes
                    playerShotSuccesses = myScanner.nextInt();

                    // Validate Input
                    if (playerShotSuccesses > playerShotAttempts) {
                        System.out.println("You can't have more successful shots than attempts... (Restart input from name)");

                    // Break the Loop
                    } else repeatEntry = false;

                } catch (Exception ex) {
                    System.out.println("Numbers only please... (Restart input from name)");
                }

                // Consume the line
                myScanner.nextLine();
            }

            // Make an entry in the hashmap
            basketballPlayers.put(playerName, (((double) playerShotSuccesses) / (double) playerShotAttempts) * 100);

            // Add 1 to successful entries
            userEntries += 1;

        }

        // Order Hashmap Small -> Great
        basketballPlayers = basketballPlayers.entrySet().stream().sorted(Entry.comparingByValue()).collect(
                Collectors.toMap(Entry :: getKey, Entry :: getValue, (e1, e2) -> e1, LinkedHashMap :: new));

        // Create Display String
        String outputString = "";
        int iterCount = 0;
        int mapLength = basketballPlayers.size();

        for (Map.Entry<String, Double> currentEntry : basketballPlayers.entrySet()) {
            iterCount += 1;
            outputString = "\n" + currentEntry.getKey() + "-" + myFormatter.format(currentEntry.getValue()).concat(outputString);

            // Set the winner on the last iteration
            if (iterCount == mapLength) outputString = outputString.concat("\n" + currentEntry.getKey() + " is the best player.");

        }

        System.out.println(outputString);


    }




}
