import java.util.HashMap;
import java.util.Map;

/**
 * UC6 - Map Bogie to Capacity (HashMap)
 * 
 * Objective: Associate each bogie with its seating or load capacity 
 * using a key-value mapping structure.
 * 
 * Key Concepts:
 * - HashMap: Hash table based Map implementation
 * - Stores data in key-value pairs
 * - Map Interface: Represents mapping between keys and values
 * - put() Method: Inserts key-value pair
 * - Key-Value Association: Binds bogies to their properties
 * - entrySet() Iteration: Iterates over map entries
 * - Fast Lookup: Constant-time retrieval using keys
 */

public class UC6_MapBogieToCapacity {
    
    // HashMap to store bogie name to capacity mapping
    private Map<String, Integer> bogieCapacityMap;
    
    /**
     * Constructor to initialize the capacity map
     */
    public UC6_MapBogieToCapacity() {
        this.bogieCapacityMap = new HashMap<>();
    }
    
    /**
     * Method to add or update a bogie's capacity
     * @param bogieName the name of the bogie
     * @param capacity the seating or load capacity
     */
    public void addBogieCapacity(String bogieName, int capacity) {
        bogieCapacityMap.put(bogieName, capacity);
        System.out.println("✓ Added/Updated: " + bogieName + " --> Capacity: " + capacity + " seats");
    }
    
    /**
     * Method to get capacity of a specific bogie
     * @param bogieName the name of the bogie
     * @return capacity or -1 if not found
     */
    public int getCapacity(String bogieName) {
        return bogieCapacityMap.getOrDefault(bogieName, -1);
    }
    
    /**
     * Method to check if a bogie exists in the map
     * @param bogieName the name of the bogie
     * @return true if exists, false otherwise
     */
    public boolean containsBogie(String bogieName) {
        return bogieCapacityMap.containsKey(bogieName);
    }
    
    /**
     * Method to calculate total capacity of all bogies
     * @return total capacity
     */
    public int calculateTotalCapacity() {
        int totalCapacity = 0;
        for (int capacity : bogieCapacityMap.values()) {
            totalCapacity += capacity;
        }
        return totalCapacity;
    }
    
    /**
     * Method to display all bogies and their capacities
     */
    public void displayBogieCapacities() {
        System.out.println("--- Bogie Capacity Details ---");
        System.out.println("Total Bogies: " + bogieCapacityMap.size());
        
        if (bogieCapacityMap.isEmpty()) {
            System.out.println("No bogies configured.");
        } else {
            System.out.println("\nBogie Name\t\tCapacity (Seats)");
            System.out.println("-------------------------------------------");
            
            for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
                String bogieName = entry.getKey();
                int capacity = entry.getValue();
                System.out.println(bogieName + "\t\t\t" + capacity);
            }
            
            System.out.println("-------------------------------------------");
            System.out.println("Total Train Capacity: " + calculateTotalCapacity() + " seats");
        }
        System.out.println();
    }
    
    /**
     * Method to remove a bogie from the map
     * @param bogieName the name of the bogie to remove
     * @return true if removed, false if not found
     */
    public boolean removeBogie(String bogieName) {
        if (bogieCapacityMap.remove(bogieName) != null) {
            System.out.println("✓ Removed bogie: " + bogieName);
            return true;
        } else {
            System.out.println("✗ Bogie not found: " + bogieName);
            return false;
        }
    }
    
    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        System.out.println("=== UC6: Map Bogie to Capacity (HashMap) ===\n");
        
        UC6_MapBogieToCapacity trainApp = new UC6_MapBogieToCapacity();
        
        // Add bogies with their capacities
        System.out.println("--- Adding Bogie Capacity Mappings ---");
        trainApp.addBogieCapacity("Engine", 0);         // Engine doesn't have passenger capacity
        trainApp.addBogieCapacity("Sleeper", 72);       // Sleeper car
        trainApp.addBogieCapacity("AC Chair", 80);      // AC Chair car
        trainApp.addBogieCapacity("First Class", 60);   // First class compartment
        trainApp.addBogieCapacity("Pantry", 0);         // Pantry car (no passengers)
        trainApp.addBogieCapacity("Cargo", 0);          // Cargo bogie (no passengers)
        trainApp.addBogieCapacity("Guard", 0);          // Guard's compartment
        System.out.println();
        
        // Display all mappings
        trainApp.displayBogieCapacities();
        
        // Lookup specific capacity
        System.out.println("--- Capacity Lookup ---");
        String searchBogie = "Sleeper";
        int capacity = trainApp.getCapacity(searchBogie);
        if (capacity != -1) {
            System.out.println("Capacity of " + searchBogie + ": " + capacity + " seats");
        } else {
            System.out.println(searchBogie + " not found in system.");
        }
        System.out.println();
        
        // Check existence
        System.out.println("--- Existence Check ---");
        if (trainApp.containsBogie("AC Chair")) {
            System.out.println("✓ AC Chair is configured in the system.");
        }
        System.out.println();
        
        // Update capacity
        System.out.println("--- Updating Capacity ---");
        trainApp.addBogieCapacity("Sleeper", 75);  // Increased capacity
        System.out.println();
        
        // Remove a bogie
        System.out.println("--- Removing a Bogie ---");
        trainApp.removeBogie("Pantry");
        System.out.println();
        
        // Final display
        System.out.println("--- Final Train Configuration with Capacities ---");
        trainApp.displayBogieCapacities();
        
        System.out.println("Program execution completed successfully!");
    }
}
