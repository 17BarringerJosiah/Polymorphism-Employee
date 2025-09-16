import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileControl {

    static void controlFiles(Scanner scanner, List<Employee> allEmployees) {
        System.out.println("\n--- File Menu ---");
        System.out.println("1. Save all employees to a file");
        System.out.println("2. Read all employees back from a file");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice3 = scanner.nextInt();

        switch (choice3) {
            case 1:
                createEmployeeFile(scanner, allEmployees);
                saveAllEmployeesToFile(scanner, allEmployees);
                break;
            case 2:
                readAllEmployeesToFile(scanner, allEmployees);
                break;
            default:
                break;
        }
    }

    static void createEmployeeFile(Scanner scanner, List<Employee> allEmployees){
        try {
            File myObj = new File("employees.txt"); // Create File object
            if (myObj.createNewFile()) {           // Try to create the file
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("Employees file already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); // Print error details
        }
    }


    static void saveAllEmployeesToFile(Scanner scanner, List<Employee> allEmployees) {
        try {
            FileWriter myWriter = new FileWriter("employees.txt");
            myWriter.write(allEmployees.toString());
            myWriter.close();  // must close manually
            System.out.println("Successfully wrote all employees to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void readAllEmployeesToFile(Scanner scanner, List<Employee> allEmployees) {
        File myObj = new File("employees.txt");

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    }





