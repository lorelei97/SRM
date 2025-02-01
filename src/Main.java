import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //creating objects to call from other class
        Login login = new Login();
        Admin admin = new Admin();
        Report report = new Report();

        Scanner obj = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------");
        System.out.println("            Student Report Management System");
        System.out.println("-------------------------------------------------------------\n");

        System.out.println("     <Choose user option>     ");
        System.out.println("        1. Admin"); //password is admin000
        System.out.println("        2. Student");
        System.out.println("        3. Exit");
        char user = obj.next().charAt(0); //catch user input for option
        obj.nextLine();

        switch (user){ //switch loop for option
            case '1':
                if(login.adminLogIn()){ //boolean method from login class, if the condition is true, this will run
                    admin.adminProfile(); //method from admin class to update student info
                }
                break;

            case '2':
                report.showStudentMarks(); //method from report class to show view result
                break;

            case '3':
                System.out.println("Exiting the Program...");
                break;

            default: //if the user enter wrong option other than 1,2,3
                do { //do-while loop for user to enter the correct choice
                    System.out.println("Invalid choice. Please Try again.");
                    System.out.println("     Choose user option     ");
                    System.out.println("        1. Admin");
                    System.out.println("        2. Student");
                    System.out.println("        3. Exit");
                    user = obj.next().charAt(0);
                    obj.nextLine();
                    //switch loop to run the option choices again
                    switch (user){
                        case '1':
                            if(login.adminLogIn()){
                                admin.adminProfile();
                            }
                            break;

                        case '2':
                            report.showStudentMarks();
                            break;

                        case '3':
                            System.out.println("\nExiting the Program...");
                            break;
                    }
                } while (!(user == '1' || user == '2' || user == '3'));
        }

        System.out.println("\n\n-------------------------------------------------------------");
        System.out.println("            Successfully Logged out of the System");
        System.out.println("-------------------------------------------------------------");
    }
}