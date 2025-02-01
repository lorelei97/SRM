import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Report {
    //method for viewing student marks from file
    public void showStudentMarks() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Student Name to search: ");
        String searchName = obj.nextLine();

        String filename = "student_info.txt"; //name of file
        boolean found = false; //condition marker for searching student name in the file with inputted name

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) { //for reading from file

            String line;
            System.out.println("\nSearching for student " + searchName + " ......");

            while ((line = reader.readLine()) != null) { //while the file is not empty

                //if statement to check the inputted name is in the file or not
                if (line.contains("Student: " + searchName + ",")) { //if the lines from file contain inputted name
                    System.out.println("\n" + line); //the line is showed as output
                    found = true; //condition market will become true
                }
            }

            if (!found) { //if the inputted name is not found in the file
                System.out.println("No information found for student: " + searchName);
            }

        } catch (IOException e) { //to ignore buffers
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

    }
}