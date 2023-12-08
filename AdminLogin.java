import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class AdminLogin {
    String uname, pwd;
    JFrame frame;
    private JTextField adminUNameTxtFld;
    private JPasswordField adminPwdTxtFld;

    /**
     * Launch the application.
     */
    private void adminLoginBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        uname = adminUNameTxtFld.getText();
        pwd = adminPwdTxtFld.getText();
        if (uname.equals("admin") && pwd.equals("admin123")) {
            AdminHomePage ap = new AdminHomePage();
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid Login and Password");
        }
    }

    private void adminClrBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        adminUNameTxtFld.setText(null);
        adminPwdTxtFld.setText(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminLogin window = new AdminLogin();
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
    public AdminLogin() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("Login as Administrator");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel.setBounds(148, 29, 228, 31);
        frame.getContentPane().add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\PIMAGE\\personlogo.png"));
        lblNewLabel_1.setForeground(SystemColor.text);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(84, 92, 121, 24);
        frame.getContentPane().add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\PIMAGE\\password.png"));
        lblNewLabel_2.setForeground(SystemColor.text);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(84, 166, 121, 24);
        frame.getContentPane().add(lblNewLabel_2);
        adminUNameTxtFld = new JTextField();
        adminUNameTxtFld.setBounds(230, 90, 161, 31);
        frame.getContentPane().add(adminUNameTxtFld);
        adminUNameTxtFld.setColumns(10);
        JButton adminLoginBtn = new JButton("Login");
        adminLoginBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        adminLoginBtn.setBounds(116, 229, 89, 23);
        frame.getContentPane().add(adminLoginBtn);
        JButton adminClrBtn = new JButton("Clear");
        adminClrBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        adminClrBtn.setBounds(230, 229, 89, 23);
        frame.getContentPane().add(adminClrBtn);
        adminPwdTxtFld = new JPasswordField();
        adminPwdTxtFld.setBounds(230, 170, 161, 31);
        frame.getContentPane().add(adminPwdTxtFld);
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\PIMAGE\\clog.jpg"));
        lblNewLabel_3.setBounds(0, 0, 484, 311);
        frame.getContentPane().add(lblNewLabel_3);
        
        JButton btnClose = new JButton("Back");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainLogin ml=new MainLogin();
                ml.frame.setVisible(true);
        	}
        });
        btnClose.setBounds(347, 230, 89, 23);
        frame.getContentPane().add(btnClose);
        adminLoginBtn.addActionListener(e -> adminLoginBtnActionPerformed(e));
        adminClrBtn.addActionListener(e -> adminClrBtnActionPerformed(e));
        frame.setVisible(true);
    }
}
