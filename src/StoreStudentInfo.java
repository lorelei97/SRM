import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

abstract class StoreStudentInfo { //abstract class for storing student info
    abstract void studentScore(); //abstract method
}

class updateInfo extends StoreStudentInfo {
    private static final double[] moduleMark = new double[4]; //array for storing all scores from 4 modules for each student

    //method for adding student marks to file
    public void studentScore() { //use abstract method from abstract class
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String studentName = obj.nextLine();

        System.out.println("Enter marks for each module (1.AES, 2.MATHS, 3.PE, 4.SD):");
        //for loop for entering the marks for all 4 modules
        for (int i = 0; i < moduleMark.length; i++) {
            System.out.print("Module " + (i + 1) + ": ");
            moduleMark[i] = obj.nextDouble(); //store each input in respective array space
        }

        //creating object and calling method from inheritor(child) class
        average a = new average();
        double averageMark = a.calculateAverageMark(); //calling the calculating average mark method from child class
        String result = average.getResult(averageMark); //calling the pass or fail status method from child class

        String filename = "student_info.txt";
        //String variable to catch the inputted info
        String content = "Student: " + studentName + ", AES: " + moduleMark[0] + ", Maths: " + moduleMark[1] +
                ", PE: " + moduleMark[2] + ", SD: " + moduleMark[3] + ", Average Mark: " + averageMark +
                ", Result: " + result;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(content); //storing the inputted info in the file
            writer.newLine();
            System.out.println("Student information saved successfully.");
        } catch (IOException e) { //to ignore buffers
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    private static class average extends updateInfo { //inheritance of updateInfo class

        //method for calculating average score of a student
        private double calculateAverageMark() {
            double sum = 0;
            //for loop for addition of marks from 4 modules
            for (double mark : moduleMark) { //use array from parent class for calculating the average mark of 4 modules
                sum += mark;
            }
            return sum / moduleMark.length; //returning average score
        }

        //method for showing status according to passing marks
        public static String getResult(double mark) {
            //if calculated mark is more than or equal to 40,
            if (mark >= 40) {
                return "congrats, you passed";
                //if calculated mark is less than 40
            } else {
                return "failed";
            }
        }
    }

}