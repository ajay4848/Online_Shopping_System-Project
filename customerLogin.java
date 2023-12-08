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
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class customerLogin {
    String uname, pwd;
    int flag = 0;
    String dbURL = "jdbc:mysql://localhost:3306/ajdb";
    String username = "root";
    String password = "Ajay@678";

   JFrame frame;
    private JTextField custUnameTxtFld;
    private JPasswordField custPwdFld;

/**
* Launch the application.
*/
private void custLoginBtnActionPerformed(ActionEvent e) {
String name="",pass="";
Connection connection = null;
PreparedStatement ps = null;
ResultSet rs = null;
try{
 connection = DriverManager.getConnection(dbURL, username, password);
 String sql = "SELECT * FROM customer_list where cust_name=? AND cust_pwd=?";
 ps = connection.prepareStatement(sql);
 ps.setString(1, custUnameTxtFld.getText());
 ps.setString(2, custPwdFld.getText());
 rs = ps.executeQuery();
 
 if(rs.next()) {
 flag = 1;
 JOptionPane.showMessageDialog(null,"Success!!!");
 
 }
 else{
 JOptionPane.showMessageDialog(null,"Username and Password does not match");
 }
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);}
if(flag == 1) {
Connection con = null;
PreparedStatement ps2 = null;
ResultSet rs2 = null;
try{
	 

	con = DriverManager.getConnection(dbURL, username, password);
 String sql2 = "insert into custlogin(cname) values(?)";
 ps2 = con.prepareStatement(sql2);
 ps2.setString(1, custUnameTxtFld.getText());
 ps2.executeUpdate();
 CustomerHomePage hp = new CustomerHomePage();
   hp.frame.setVisible(true);
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);}
}
 }

    private void signUpBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        Registration regform = new Registration();
        frame.dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    customerLogin window = new customerLogin();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public customerLogin() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("Login as Customer");
        lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel.setBounds(149, 28, 228, 31);
        lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 17));
        frame.getContentPane().add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\PIMAGE\\personlogo.png"));
        lblNewLabel_1.setForeground(SystemColor.text);
        lblNewLabel_1.setBounds(84, 92, 121, 24);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\PIMAGE\\password.png"));
        lblNewLabel_2.setForeground(SystemColor.text);
        lblNewLabel_2.setBounds(84, 166, 121, 24);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_2);
        custUnameTxtFld = new JTextField();
        custUnameTxtFld.setBounds(230, 90, 161, 31);
        frame.getContentPane().add(custUnameTxtFld);
        custUnameTxtFld.setColumns(10);
        custPwdFld = new JPasswordField();
        custPwdFld.setBounds(230, 170, 161, 31);
        frame.getContentPane().add(custPwdFld);
        JButton custLoginBtn = new JButton("Login");
        custLoginBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        custLoginBtn.setBounds(116, 229, 89, 23);
        frame.getContentPane().add(custLoginBtn);
        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        signUpBtn.setBounds(230, 229, 89, 23);
        frame.getContentPane().add(signUpBtn);
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\PIMAGE\\clog.jpg"));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(0, 0, 484, 311);
        frame.getContentPane().add(lblNewLabel_3);
        
        JButton btnClose = new JButton("Back");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		MainLogin ml=new MainLogin();
             ml.frame.setVisible(true);       	}
        });
        btnClose.setBounds(351, 230, 89, 23);
        frame.getContentPane().add(btnClose);
        custLoginBtn.addActionListener(e -> custLoginBtnActionPerformed(e));
        signUpBtn.addActionListener(e -> signUpBtnActionPerformed(e));
        frame.setVisible(true);
    }
}
