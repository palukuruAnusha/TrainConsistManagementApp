import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UC9 - Group Bogies by Type
 *
 * Objective: Group bogies into categories using Stream collectors.
 *
 * Key Concepts:
 * - Collectors.groupingBy(): Classifies elements into groups
 * - Stream Pipeline: Transforms list to grouped map
 * - Map Output: Key is category, value is list of bogies
 * - Lambda Classification: Defines grouping rule
 * - Data Aggregation: Builds clustered view for reporting
 * - Structured Transformation: Flat list to hierarchical output
 */
public class UC9_GroupBogiesByType {

    private static String classifyBogie(UC7_SortBogiesByCapacity.Bogie bogie) {
        String name = bogie.getName().toLowerCase();
        if (name.contains("ac") || name.contains("first")) {
            return "Premium Passenger";
        }
        if (name.contains("sleeper")) {
            return "Sleeper Passenger";
        }
        return "General Passenger";
    }

    private static void displayGroupedBogies(Map<String, List<UC7_SortBogiesByCapacity.Bogie>> groupedBogies) {
        System.out.println("Grouped Bogie Structure:");
        groupedBogies.forEach((type, bogies) -> {
            System.out.println(type + ":");
            for (UC7_SortBogiesByCapacity.Bogie bogie : bogies) {
                System.out.println("- " + bogie.getName() + " | Capacity: " + bogie.getCapacity());
            }
            System.out.println();
        });
    }

    /**
     * Main method - Entry point of UC9
     */
    public static void main(String[] args) {
        System.out.println("=== UC9: Group Bogies by Type ===\n");

        // Reuse the same bogie list from UC7.
        List<UC7_SortBogiesByCapacity.Bogie> passengerBogies = UC7_SortBogiesByCapacity.createPassengerBogies();

        Map<String, List<UC7_SortBogiesByCapacity.Bogie>> groupedBogies = passengerBogies.stream()
                .collect(Collectors.groupingBy(UC9_GroupBogiesByType::classifyBogie));

        displayGroupedBogies(groupedBogies);

        System.out.println("Program execution completed successfully!");
    }
}
