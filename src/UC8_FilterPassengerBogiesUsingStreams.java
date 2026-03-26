import java.util.List;
import java.util.stream.Collectors;

/**
 * UC8 - Filter Passenger Bogies Using Streams
 *
 * Objective: Filter passenger bogies using Stream pipelines
 * based on seating capacity.
 *
 * Key Concepts:
 * - Stream API: Declarative collection processing
 * - stream(): Converts list to stream pipeline
 * - filter(): Selects matching elements
 * - Lambda Expressions: Compact rule definition
 * - collect(toList()): Converts stream result to list
 * - Declarative Style: Focuses on what to do
 */
public class UC8_FilterPassengerBogiesUsingStreams {

    private static void displayBogies(String heading, List<UC7_SortBogiesByCapacity.Bogie> bogies) {
        System.out.println(heading);
        for (UC7_SortBogiesByCapacity.Bogie bogie : bogies) {
            System.out.println("- " + bogie.getName() + " | Capacity: " + bogie.getCapacity());
        }
        System.out.println();
    }

    /**
     * Main method - Entry point of UC8
     */
    public static void main(String[] args) {
        System.out.println("=== UC8: Filter Passenger Bogies Using Streams ===\n");

        // Reuse the bogie list created in UC7.
        List<UC7_SortBogiesByCapacity.Bogie> passengerBogies = UC7_SortBogiesByCapacity.createPassengerBogies();
        displayBogies("All Passenger Bogies:", passengerBogies);

        List<UC7_SortBogiesByCapacity.Bogie> filteredBogies = passengerBogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        displayBogies("Filtered Bogies (capacity > 60):", filteredBogies);

        System.out.println("Program execution completed successfully!");
    }
}
