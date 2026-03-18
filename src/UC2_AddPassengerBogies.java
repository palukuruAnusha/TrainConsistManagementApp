import java.util.ArrayList;
import java.util.List;

/**
 * UC2 - Add Passenger Bogies to Train (ArrayList Operations)
 * 
 * Objective: Allow dynamic insertion and removal of passenger bogies 
 * using ArrayList.
 * 
 * Key Concepts:
 * - ArrayList: Resizable collection allowing insertion and deletion
 * - add() Method: Inserts elements into the list
 * - remove() Method: Deletes elements from the list
 * - contains() Method: Checks whether element exists
 * - Insertion Order Preservation: ArrayList maintains order
 * - CRUD Operations: Create, Read, Update, Delete operations
 */

public class UC2_AddPassengerBogies {
    
    // ArrayList to store passenger bogies
    private List<String> passengerBogies;
    
    /**
     * Constructor to initialize the passenger bogies collection
     */
    public UC2_AddPassengerBogies() {
        this.passengerBogies = new ArrayList<>();
    }
    
    /**
     * Method to add a bogie to the train
     * @param bogie the bogie to add
     */
    public void addBogie(String bogie) {
        passengerBogies.add(bogie);
        System.out.println("✓ Added bogie: " + bogie);
    }
    
    /**
     * Method to remove a bogie from the train
     * @param bogie the bogie to remove
     * @return true if removed, false if not found
     */
    public boolean removeBogie(String bogie) {
        boolean removed = passengerBogies.remove(bogie);
        if (removed) {
            System.out.println("✓ Removed bogie: " + bogie);
        } else {
            System.out.println("✗ Bogie not found: " + bogie);
        }
        return removed;
    }
    
    /**
     * Method to check if a bogie exists in the train
     * @param bogie the bogie to check
     * @return true if exists, false otherwise
     */
    public boolean contains(String bogie) {
        return passengerBogies.contains(bogie);
    }
    
    /**
     * Method to display all bogies in the train
     */
    public void displayBogies() {
        System.out.println("Current Train Consist:");
        System.out.println("Total Bogies: " + passengerBogies.size());
        
        if (passengerBogies.isEmpty()) {
            System.out.println("No bogies in the train.");
        } else {
            for (int i = 0; i < passengerBogies.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + passengerBogies.get(i));
            }
        }
        System.out.println();
    }
    
    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        System.out.println("=== UC2: Add Passenger Bogies to Train ===\n");
        
        UC2_AddPassengerBogies trainApp = new UC2_AddPassengerBogies();
        
        // CRUD Operations Demo
        System.out.println("--- CREATE (Adding Bogies) ---");
        trainApp.addBogie("Sleeper");
        trainApp.addBogie("AC Chair");
        trainApp.addBogie("First Class");
        System.out.println();
        
        System.out.println("--- READ (Display Bogies) ---");
        trainApp.displayBogies();
        
        System.out.println("--- DELETE (Removing Bogie) ---");
        trainApp.removeBogie("AC Chair");
        System.out.println();
        
        System.out.println("--- VERIFY Existence ---");
        String checkBogie = "Sleeper";
        if (trainApp.contains(checkBogie)) {
            System.out.println("✓ " + checkBogie + " exists in the train.");
        } else {
            System.out.println("✗ " + checkBogie + " does not exist in the train.");
        }
        System.out.println();
        
        System.out.println("--- Final Train Configuration ---");
        trainApp.displayBogies();
        
        System.out.println("Program execution completed successfully!");
    }
}
