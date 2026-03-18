import java.util.LinkedHashSet;
import java.util.Set;

/**
 * UC5 - Preserve Insertion Order of Bogies (LinkedHashSet)
 * 
 * Objective: Maintain insertion order while enforcing uniqueness of bogies.
 * 
 * Key Concepts:
 * - LinkedHashSet: Hash table with linked list implementation
 * - Stores unique elements while maintaining insertion order
 * - Set Interface: Collection that doesn't allow duplicates
 * - add() Method: Inserts bogie, ignores if already exists
 * - Automatic Deduplication: LinkedHashSet removes duplicates internally
 * - Ordered Iteration: Elements returned in insertion order
 */

public class UC5_PreserveInsertionOrderBogies {
    
    // LinkedHashSet to store bogies with unique values in insertion order
    private Set<String> trainFormation;
    
    /**
     * Constructor to initialize the linked hash set
     */
    public UC5_PreserveInsertionOrderBogies() {
        this.trainFormation = new LinkedHashSet<>();
    }
    
    /**
     * Method to attach a bogie to the train
     * @param bogie the bogie to attach
     * @return true if successfully attached, false if already attached
     */
    public boolean attachBogie(String bogie) {
        boolean attached = trainFormation.add(bogie);
        if (attached) {
            System.out.println("✓ Attached bogie: " + bogie);
        } else {
            System.out.println("✗ Duplicate bogie - Cannot attach: " + bogie + " (already in formation)");
        }
        return attached;
    }
    
    /**
     * Method to check if a bogie is in the formation
     * @param bogie the bogie to check
     * @return true if exists, false otherwise
     */
    public boolean contains(String bogie) {
        return trainFormation.contains(bogie);
    }
    
    /**
     * Method to remove a bogie from the train
     * @param bogie the bogie to remove
     * @return true if removed, false if not found
     */
    public boolean removeBogie(String bogie) {
        boolean removed = trainFormation.remove(bogie);
        if (removed) {
            System.out.println("✓ Removed bogie: " + bogie);
        } else {
            System.out.println("✗ Bogie not found: " + bogie);
        }
        return removed;
    }
    
    /**
     * Method to get total number of bogies
     * @return size of the formation
     */
    public int getTotalBogies() {
        return trainFormation.size();
    }
    
    /**
     * Method to display the train formation in order
     */
    public void displayFormation() {
        System.out.println("--- Current Train Formation ---");
        System.out.println("Total Bogies: " + trainFormation.size());
        
        if (trainFormation.isEmpty()) {
            System.out.println("Train formation is empty.");
        } else {
            System.out.print("Formation (in attachment order): ");
            int count = 1;
            for (String bogie : trainFormation) {
                System.out.print(count + "." + bogie);
                if (count < trainFormation.size()) {
                    System.out.print(" --> ");
                }
                count++;
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        System.out.println("=== UC5: Preserve Insertion Order of Bogies (LinkedHashSet) ===\n");
        
        UC5_PreserveInsertionOrderBogies trainApp = new UC5_PreserveInsertionOrderBogies();
        
        // Attach bogies in specific order
        System.out.println("--- Attaching Bogies in Order ---");
        trainApp.attachBogie("Engine");
        trainApp.attachBogie("Sleeper");
        trainApp.attachBogie("Cargo");
        trainApp.attachBogie("Guard");
        System.out.println();
        
        trainApp.displayFormation();
        
        // Attempt to attach duplicate
        System.out.println("--- Attempting to Attach Duplicate Bogies ---");
        trainApp.attachBogie("Sleeper");  // Duplicate - should be ignored
        trainApp.attachBogie("Cargo");    // Duplicate - should be ignored
        System.out.println();
        
        trainApp.displayFormation();
        
        // Verify existence
        System.out.println("--- Verifying Existence ---");
        String checkBogie = "Sleeper";
        if (trainApp.contains(checkBogie)) {
            System.out.println("✓ " + checkBogie + " is in the formation.");
        } else {
            System.out.println("✗ " + checkBogie + " is not in the formation.");
        }
        System.out.println();
        
        // Remove and display
        System.out.println("--- Removing a Bogie ---");
        trainApp.removeBogie("Cargo");
        trainApp.displayFormation();
        
        System.out.println("Total Bogies in Formation: " + trainApp.getTotalBogies());
        System.out.println("\nProgram execution completed successfully!");
    }
}
