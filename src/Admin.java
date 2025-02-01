import java.util.LinkedList;
import java.util.Scanner;
public class Admin {
    private LinkedList<Student> students = new LinkedList<>();

    public void adminProfile(){
        Scanner obj = new Scanner(System.in);
        char option;

        do{
            System.out.println("\nChoose an option: ");
            System.out.println("1. Update Student Info");
            System.out.println("2. Show Student marks");
            System.out.println("3. Exit");

            option = obj.next().charAt(0);

            switch (option) {
                case '1':
                    addStudent();
                    break;
                case '2':
                    showStudentRecord();
                    break;
                case '3':
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid Option. Try Again.");
            }
        }while (option != 3);
    }

    private void addStudent(){
        Scanner obj = new Scanner(System.in);
        System.out.println("\nEnter Student Name: ");
        String name = obj.nextLine();

        double[] marks = new double[4];
        System.out.println("Enter marks for each module (AES, Maths, PE, SD): ");
        for(int i = 0; i < marks.length; i++){
            System.out.println("Module " + (i+1) + ": ");
            marks[i] = obj.nextDouble();
        }

        Student newstudent = new Student(name, marks);
        students.add(newstudent);
        System.out.println("Student added successfully!");
    }

    private void showStudentRecord(){
        if(students.isEmpty()){
            System.out.println("No student record to display.");
        }
        else students.forEach(System.out::println);
    }
}

/*
//calling other classes
    updateInfo infoUpdate = new updateInfo();
    Report report = new Report();

    //method for choosing options by admin
    public void adminProfile() {
        Scanner obj = new Scanner(System.in);

        System.out.println("\nChoose an option: ");
        System.out.println("1. Update Student Info");
        System.out.println("2. Show Student marks");
        System.out.println("3. Exit");

        char option = obj.next().charAt(0);

    }
       switch (option) { //switch for choosing an option
            case '1':
                infoUpdate.studentScore(); //calling another class method
                char add;
                do{ //do-while loop for adding another student
                    System.out.println("\nDo you want to add another student info? Y/N");
                    add = obj.next().charAt(0);

                    //if the user input is Y or y, it will continue to add another student info
                    if (add == 'Y' || add == 'y') {
                        infoUpdate.studentScore(); //calling method from infoUpdate class for updating student info

                    } else //if the user input is other than Y or y
                        System.out.println("\n...Exiting...");

                } while (add == 'Y' || add == 'y'); //condition for do-while loop to continue or exit
                break;


            case '2':
                report.showStudentMarks(); //calling method from report class for viewing student info
                break;

            case '3':
                System.out.println("...Exiting...");
                break;


            default: //if user input is apart from given option, it will ask to enter again
                do {
                    System.out.println("\nInvalid option. Please Try Again.");
                    System.out.println("Choose an option: ");
                    System.out.println("1. Update Student Info");
                    System.out.println("2. Show Student marks");
                    System.out.println("3. Exit");

                    option = obj.next().charAt(0);

                    //switch loop to run option choices again
                    switch (option) {
                        case '1':
                            do{
                                infoUpdate.studentScore();
                                System.out.println("Do you want to add another student info? Y/N");
                                add = obj.next().charAt(0);

                                if (add == 'Y' || add == 'y') {
                                    infoUpdate.studentScore();

                                } else
                                    System.out.println("...Exiting...");

                            } while (add == 'Y' || add == 'y');
                            break;


                        case '2':
                            report.showStudentMarks();
                            break;

                        case '3':
                            System.out.println("\n...Exiting...");
                            break;
                    }
                } while (!(option == '1' || option == '2' || option == '3'));
        }
    }
* */