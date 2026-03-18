import java.util.ArrayList;
import java.util.List;

/**
 * UC1 - Initialize Train and Display Consist Summary
 * 
 * Objective: Initialize the Train Consist Management App and display 
 * the initial state of the train.
 * 
 * Key Concepts:
 * - Class: Container for program data and logic
 * - Main Method: Entry point of the Java application
 * - Static Keyword: Allows JVM to invoke main() without object instance
 * - ArrayList: Resizable list for storing bogies dynamically
 * - List Interface: Abstraction over List implementations
 */

public class UC1_InitializeTrainApp {
    
    // Instance variable to store bogies
    private List<String> bogies;
    
    /**
     * Constructor to initialize the train consist
     */
    public UC1_InitializeTrainApp() {
        // Create an empty ArrayList to store bogies
        this.bogies = new ArrayList<>();
    }
    
    /**
     * Method to display welcome message and initial consist summary
     */
    public void displayInitialSummary() {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Welcome to the Train Consist Management System!");
        System.out.println();
        displayConsistSummary();
    }
    
    /**
     * Method to display current consist summary
     */
    private void displayConsistSummary() {
        System.out.println("--- Initial Train Configuration ---");
        System.out.println("Total Bogies: " + bogies.size());
        System.out.println("Consist Details: " + (bogies.isEmpty() ? 
                           "Empty - Ready to add bogies" : bogies.toString()));
        System.out.println();
    }
    
    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        // Create instance of Train App
        UC1_InitializeTrainApp trainApp = new UC1_InitializeTrainApp();
        
        // Display initial summary
        trainApp.displayInitialSummary();
        
        System.out.println("Program execution completed successfully!");
    }
}
