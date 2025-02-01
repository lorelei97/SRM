import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends Component implements ActionListener {
    JButton admin, student;
    JTextField studentNameField;
    JTextArea outputArea;
    JFrame frame;

    public void inter() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(800, 500); //frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //GUI exits on closing

        frame.setTitle("Student Report Management System"); //title of the frame

        JLabel title, userlabel;
        title = new JLabel("Student Report", SwingConstants.CENTER); //title of the page
        userlabel = new JLabel("Choose user option"); //user option label
        //adding labels to the frame and positioning them
        frame.add(title, BorderLayout.NORTH);
        frame.add(userlabel, BorderLayout.CENTER);

        //creating buttons
        admin = new JButton("Admin");
        student = new JButton("Student");
        //adding buttons to frame
        frame.add(admin);
        frame.add(student);
        //adding action listener button
        admin.addActionListener(this);
        student.addActionListener(this);

        //creating text box and output box
        studentNameField = new JTextField(20);
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false); //cannot type in the output box
        //adding text box and output box to frame
        frame.add(studentNameField);
        frame.add(outputArea);

        //for title of the page
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(title);
        frame.add(titlePanel, BorderLayout.NORTH);

        //for user options of the page
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPanel.add(userlabel);
        userPanel.add(admin);
        userPanel.add(student);
        frame.add(userPanel, BorderLayout.CENTER); //adding to the frame and positioning

        //creating text field box for entering student name
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(new JLabel("Enter Student Name "));
        inputPanel.add(studentNameField);
        frame.add(inputPanel, BorderLayout.SOUTH); //adding to the frame and positioning

        //creating output box for showing the student scores
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        frame.add(outputPanel, BorderLayout.EAST); //adding to the frame and positioning

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin) { //when admin button is pressed
            String password = JOptionPane.showInputDialog(frame, "Enter password:"); //another panel to enter the password
            if (password != null && password.equals("admin000")) { //if password is the same as set password
                JOptionPane.showMessageDialog(frame, "Login Successful as Admin");
                // Add code for admin operations
            } else { //if wrong password is entered
                JOptionPane.showMessageDialog(frame, "Login Unsuccessful");
            }
        } else if (e.getSource() == student) { //if the student button is pressed
            String name = studentNameField.getText();
            if (name.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please enter a student name");
            }
        }
    }
    public static void main(String[] args) {
        GUI run = new GUI();
        run.inter(); //to run the GUI
    }
}
