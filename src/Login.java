import java.util.Scanner;
import java.util.Stack;

public class Login {
    private static final String AdminPW = "admin000"; //constant value for admin password
    private static final int MAXattempt = 3; //maximum log in attempts after wrong password input

    public boolean adminLogIn(){
        Scanner obj = new Scanner(System.in);
        Stack<String> attempts = new Stack<>();

        System.out.println("\nLogging in as admin...");
        while (attempts.size() < MAXattempt){
            System.out.println("Enter password: ");
            String password = obj.nextLine();

            if(password.equals(AdminPW)){
                System.out.println("\n***Login Successful as Admin***");
                return true;
            }
            else{
                attempts.push(password);
                System.out.println("Incorrect password. Try again.");
            }
        }

        System.out.println("Maximum login attempts reached! Exiting the program.");
        return false;
    }
}
/*
 //boolean method for admin to log in
    public boolean adminLogIn() {
        Scanner obj = new Scanner(System.in);

        System.out.println("\nLogging in as admin...");
        System.out.println("Enter password: ");
        String password = obj.nextLine();

        //if statement for checking the inputted password is the same as actual password
        if(password.equals(AdminPW)){
            System.out.println("\n*** Login Successful as Admin ***");
            return true;
        }
        //if the input is wrong password, it will ask for 3 more times
        else {
            //for loop for making 3 more attempts after wrong password
            for(int i = 0; i < attempt; i++){
                System.out.println("Login unsuccessful. Enter password again: ");
                password = obj.nextLine();

                if(password.equals(AdminPW)){
                    System.out.println("\n*** Login Successful as Admin ***");
                    return true;
                }
            }

            //when 'if' condition in the 'for' loop is not fulfilled
            System.out.println("Maximum login attempts reached! Exiting the program");
            return false;
        }
    }
* */