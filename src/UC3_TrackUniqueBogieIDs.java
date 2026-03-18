import java.util.HashSet;
import java.util.Set;

/**
 * UC3 - Track Unique Bogie IDs (HashSet)
 * 
 * Objective: Ensure no duplicate bogie IDs are added to the train.
 * 
 * Key Concepts:
 * - HashSet: Stores unique elements
 * - Set Interface: Collection that doesn't allow duplicate elements
 * - HashSet Implementation: Uses hashing for fast access
 * - add() Method: Inserts values into the set
 * - Automatic Deduplication: HashSet ensures uniqueness without manual checks
 * - Unordered Storage: Elements not stored using index positions
 */

public class UC3_TrackUniqueBogieIDs {
    
    // HashSet to store unique bogie IDs
    private Set<String> bogieIDs;
    
    /**
     * Constructor to initialize the bogie IDs set
     */
    public UC3_TrackUniqueBogieIDs() {
        this.bogieIDs = new HashSet<>();
    }
    
    /**
     * Method to add a bogie ID to the set
     * @param bogieID the unique identifier for the bogie
     * @return true if added (was not previously present), false if duplicate
     */
    public boolean addBogieID(String bogieID) {
        boolean added = bogieIDs.add(bogieID);
        if (added) {
            System.out.println("✓ Added unique bogie ID: " + bogieID);
        } else {
            System.out.println("✗ Duplicate detected - ID already exists: " + bogieID);
        }
        return added;
    }
    
    /**
     * Method to check if a bogie ID exists
     * @param bogieID the ID to check
     * @return true if exists, false otherwise
     */
    public boolean contains(String bogieID) {
        return bogieIDs.contains(bogieID);
    }
    
    /**
     * Method to get total count of unique bogie IDs
     * @return size of the set
     */
    public int getTotalUniqueIDs() {
        return bogieIDs.size();
    }
    
    /**
     * Method to display all unique bogie IDs
     */
    public void displayUniqueBogieIDs() {
        System.out.println("--- Unique Bogie IDs in Train ---");
        System.out.println("Total Unique Bogie IDs: " + bogieIDs.size());
        
        if (bogieIDs.isEmpty()) {
            System.out.println("No bogies in the train.");
        } else {
            System.out.println("Bogie IDs: " + bogieIDs);
        }
        System.out.println();
    }
    
    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        System.out.println("=== UC3: Track Unique Bogie IDs (HashSet) ===\n");
        
        UC3_TrackUniqueBogieIDs trainApp = new UC3_TrackUniqueBogieIDs();
        
        System.out.println("--- Adding Bogie IDs ---");
        trainApp.addBogieID("BG001");
        trainApp.addBogieID("BG002");
        trainApp.addBogieID("BG003");
        trainApp.addBogieID("BG004");
        System.out.println();
        
        System.out.println("--- Attempting Duplicate Insertions ---");
        trainApp.addBogieID("BG001");  // Duplicate
        trainApp.addBogieID("BG002");  // Duplicate
        System.out.println();
        
        System.out.println("--- Checking for Existence ---");
        String checkID = "BG001";
        if (trainApp.contains(checkID)) {
            System.out.println("✓ " + checkID + " exists in the system.");
        } else {
            System.out.println("✗ " + checkID + " does not exist.");
        }
        System.out.println();
        
        trainApp.displayUniqueBogieIDs();
        
        System.out.println("Total Unique Bogie IDs Tracked: " + trainApp.getTotalUniqueIDs());
        System.out.println("\nProgram execution completed successfully!");
    }
}
