import java.util.LinkedList;
import java.util.List;

/**
 * UC4 - Maintain Ordered Bogie IDs (LinkedList)
 * 
 * Objective: Maintain ordered bogie IDs using LinkedList for efficient 
 * insertion and deletion operations.
 * 
 * Key Concepts:
 * - LinkedList: Doubly linked list with node-based implementation
 * - Node Structure Concept: Elements connected via node references
 * - addFirst() / addLast(): Attach bogies at beginning or end
 * - add(index, element): Insert bogie in the middle
 * - removeFirst() / removeLast(): Detach bogies from head or tail
 * - Order Preservation: Maintains physical sequence of train bogies
 */

public class UC4_MaintainOrderedBogieIDs {
    
    // LinkedList to store bogies in order
    private LinkedList<String> consist;
    
    /**
     * Constructor to initialize the linked list consist
     */
    public UC4_MaintainOrderedBogieIDs() {
        this.consist = new LinkedList<>();
    }
    
    /**
     * Method to add a bogie at the end of the train
     * @param bogie the bogie to add
     */
    public void addLast(String bogie) {
        consist.addLast(bogie);
        System.out.println("✓ Added " + bogie + " at the end of the train.");
    }
    
    /**
     * Method to add a bogie at the beginning of the train
     * @param bogie the bogie to add
     */
    public void addFirst(String bogie) {
        consist.addFirst(bogie);
        System.out.println("✓ Added " + bogie + " at the beginning of the train.");
    }
    
    /**
     * Method to insert a bogie at a specific position
     * @param index the position to insert (0-based)
     * @param bogie the bogie to insert
     */
    public void insertAt(int index, String bogie) {
        if (index >= 0 && index <= consist.size()) {
            consist.add(index, bogie);
            System.out.println("✓ Inserted " + bogie + " at position " + index);
        } else {
            System.out.println("✗ Invalid index: " + index);
        }
    }
    
    /**
     * Method to remove the first bogie
     * @return the removed bogie or null if list is empty
     */
    public String removeFirst() {
        if (consist.isEmpty()) {
            System.out.println("✗ Cannot remove from empty train.");
            return null;
        }
        String removed = consist.removeFirst();
        System.out.println("✓ Removed " + removed + " from the beginning.");
        return removed;
    }
    
    /**
     * Method to remove the last bogie
     * @return the removed bogie or null if list is empty
     */
    public String removeLast() {
        if (consist.isEmpty()) {
            System.out.println("✗ Cannot remove from empty train.");
            return null;
        }
        String removed = consist.removeLast();
        System.out.println("✓ Removed " + removed + " from the end.");
        return removed;
    }
    
    /**
     * Method to display the ordered train consist
     */
    public void displayConsist() {
        System.out.println("--- Current Train Consist (Ordered) ---");
        System.out.println("Total Bogies: " + consist.size());
        
        if (consist.isEmpty()) {
            System.out.println("Train is empty.");
        } else {
            System.out.print("Formation: ");
            for (int i = 0; i < consist.size(); i++) {
                System.out.print(consist.get(i));
                if (i < consist.size() - 1) {
                    System.out.print(" --> ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        System.out.println("=== UC4: Maintain Ordered Bogie IDs (LinkedList) ===\n");
        
        UC4_MaintainOrderedBogieIDs trainApp = new UC4_MaintainOrderedBogieIDs();
        
        // Building the initial train
        System.out.println("--- Adding Initial Bogies ---");
        trainApp.addLast("Engine");
        trainApp.addLast("Sleeper");
        trainApp.addLast("AC");
        trainApp.addLast("Cargo");
        trainApp.addLast("Guard");
        System.out.println();
        
        trainApp.displayConsist();
        
        // Insert a pantry car at position 2
        System.out.println("--- Inserting Pantry Car at Position 2 ---");
        trainApp.insertAt(2, "Pantry");
        trainApp.displayConsist();
        
        // Remove first bogie
        System.out.println("--- Removing First Bogie ---");
        trainApp.removeFirst();
        trainApp.displayConsist();
        
        // Remove last bogie
        System.out.println("--- Removing Last Bogie ---");
        trainApp.removeLast();
        trainApp.displayConsist();
        
        System.out.println("Program execution completed successfully!");
    }
}
