import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * UC7 - Sort Bogies by Capacity (Comparator)
 *
 * Objective: Sort passenger bogies based on seating capacity
 * using a custom Comparator.
 *
 * Key Concepts:
 * - Comparator Interface: Defines custom ordering logic
 * - Custom Objects: Bogie class with name and capacity
 * - List Collection: Stores multiple bogie objects dynamically
 * - sort() Method: Rearranges elements using Comparator logic
 * - Lambda Expression: Concise comparator implementation
 * - Separation of Data and Logic: Data model independent from sort behavior
 */
public class UC7_SortBogiesByCapacity {

    /**
     * Data model for passenger bogie details.
     */
    static class Bogie {
        private final String name;
        private final int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return "Bogie{name='" + name + "', capacity=" + capacity + "}";
        }
    }

    /**
     * Builds the passenger bogie list used in UC7 and reused in later use cases.
     *
     * @return list of passenger bogies
     */
    public static List<Bogie> createPassengerBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 80));
        bogies.add(new Bogie("First Class", 60));
        bogies.add(new Bogie("Second Seating", 108));
        return bogies;
    }

    private static void displayBogies(String heading, List<Bogie> bogies) {
        System.out.println(heading);
        for (Bogie bogie : bogies) {
            System.out.println("- " + bogie.getName() + " | Capacity: " + bogie.getCapacity());
        }
        System.out.println();
    }

    /**
     * Main method - Entry point of UC7
     */
    public static void main(String[] args) {
        System.out.println("=== UC7: Sort Bogies by Capacity (Comparator) ===\n");

        List<Bogie> passengerBogies = createPassengerBogies();
        displayBogies("Before Sorting:", passengerBogies);

        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        displayBogies("After Sorting by Capacity (Ascending):", passengerBogies);

        System.out.println("Program execution completed successfully!");
    }
}
