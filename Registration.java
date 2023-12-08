import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Registration {
    String uname, pass, address;
    String mob, age;
    // long age;
    private JFrame frame;
    private JTextField unametxtfld;
    private JTextField addtxtfld;
    private JTextField mobtxtfld;
    private JPasswordField pwdtxtfld;
    private JTextField agetxtfld;

    /**
     * Launch the application.
     */
    private void clearbtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        unametxtfld.setText(null);
        addtxtfld.setText(null);
        mobtxtfld.setText(null);
        pwdtxtfld.setText(null);
        agetxtfld.setText(null);
    }

private void signupbtnActionPerformed(ActionEvent e) {
String dbURL = "jdbc:mysql://localhost:3306/ajdb";
 String username = "root";
 String password = "Ajay@678";
Connection connection = null;
PreparedStatement pst = null;
ResultSet rs = null;
try {
String sql = "INSERT INTO customer_list(cust_name,cust_pwd,mobile_no,age,address) values(?,?,?,?,?)";
connection = DriverManager.getConnection(dbURL, username, 
password);
pst = connection.prepareStatement(sql);
pst.setString(1, unametxtfld.getText());
pst.setString(2, pwdtxtfld.getText());
pst.setString(3, mobtxtfld.getText());
pst.setString(4, agetxtfld.getText());
pst.setString(5, addtxtfld.getText());
pst.executeUpdate();
JOptionPane.showMessageDialog(frame,"Signed Up Successfully!");
frame.dispose();
} catch(Exception f){JOptionPane.showMessageDialog(frame,f);}
 }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registration window = new Registration();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Registration() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 630, 515);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("Sign Up to create your new account");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel.setBounds(127, 40, 427, 46);
        frame.getContentPane().add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(105, 123, 132, 39);
        frame.getContentPane().add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("Address");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(105, 173, 132, 39);
        frame.getContentPane().add(lblNewLabel_2);
        JLabel lblNewLabel_3 = new JLabel("Mobile Number");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(105, 223, 132, 39);
        frame.getContentPane().add(lblNewLabel_3);
        JLabel lblNewLabel_4 = new JLabel("Age");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(105, 273, 132, 39);
        frame.getContentPane().add(lblNewLabel_4);
        JLabel lblNewLabel_5 = new JLabel("Password");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(105, 327, 132, 39);
        frame.getContentPane().add(lblNewLabel_5);
        unametxtfld = new JTextField();
        unametxtfld.setBounds(306, 123, 150, 27);
        frame.getContentPane().add(unametxtfld);
        unametxtfld.setColumns(10);
        addtxtfld = new JTextField();
        addtxtfld.setBounds(306, 184, 150, 28);
        frame.getContentPane().add(addtxtfld);
        addtxtfld.setColumns(10);
        mobtxtfld = new JTextField();
        mobtxtfld.setBounds(306, 235, 150, 27);
        frame.getContentPane().add(mobtxtfld);
        mobtxtfld.setColumns(10);
        pwdtxtfld = new JPasswordField();
        pwdtxtfld.setBounds(306, 334, 150, 28);
        frame.getContentPane().add(pwdtxtfld);
        JButton signupbtn = new JButton("Sign Up");
        signupbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        signupbtn.setBounds(127, 410, 113, 33);
        frame.getContentPane().add(signupbtn);
        JButton clearbtn = new JButton("Clear");
        clearbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        clearbtn.setBounds(278, 410, 113, 33);
        frame.getContentPane().add(clearbtn);
        agetxtfld = new JTextField();
        agetxtfld.setBounds(305, 285, 151, 27);
        frame.getContentPane().add(agetxtfld);
        agetxtfld.setColumns(10);
        
        JButton btnClose = new JButton("Back");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		customerLogin cl=new customerLogin();
        		cl.frame.setVisible(true);
        	}
        });
        btnClose.setBounds(428, 410, 89, 33);
        frame.getContentPane().add(btnClose);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\PIMAGE\\registration.jpg"));
        lblNewLabel_6.setBounds(10, 11, 596, 467);
        frame.getContentPane().add(lblNewLabel_6);
        signupbtn.addActionListener(e -> signupbtnActionPerformed(e));
        clearbtn.addActionListener(e -> clearbtnActionPerformed(e));
        frame.setVisible(true);
    }
}
