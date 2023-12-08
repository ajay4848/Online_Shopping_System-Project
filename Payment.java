import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.Caret;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;

public class Payment {
    int flag = 0;
    String dbURL = "jdbc:mysql://localhost:3306/ajdb";
    String username = "root";
    String password = "Ajay@678";
    private JFrame frame;
    private JTextField usrnametxtfld;
    private JTextField amttxtfld;

    /**
     * Launch the application.
     */
    private void logoutbtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            String sql1 = "TRUNCATE table purchase";
            ps = connection.prepareStatement(sql1);
            ps.executeUpdate();
            flag = 1;
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame, f);
        }
        if (flag == 1) {
            Connection con = null;
            PreparedStatement ps2 = null;
            ResultSet rs2 = null;
            try {
                con = DriverManager.getConnection(dbURL, username, password);
                String sql2 = "TRUNCATE table custlogin";
                ps2 = con.prepareStatement(sql2);
                ps2.executeUpdate();
            } catch (Exception f) {
                JOptionPane.showMessageDialog(frame, f);
            }
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Payment window = new Payment();
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
    public Payment() {
        initialize();
        username();
        amount();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void amount() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            String sql = "SELECT sum(product_price) from purchase";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next() == true) {
                String name = rs.getString(1);

                amttxtfld.setText(name);
            }
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame, f);
        }
    }

    private void username() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM custlogin";
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next() == true) {
                String name = rs.getString(1);
                usrnametxtfld.setText(name);
            }
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame, f);
        }
    }

private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 781, 464);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
JLabel lblNewLabel_1 = new JLabel("Amount : RS ");
lblNewLabel_1.setForeground(new Color(51, 102, 102));
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_1.setBounds(225, 124, 120, 26);
frame.getContentPane().add(lblNewLabel_1);
amttxtfld = new JTextField();
amttxtfld.setBounds(333, 129, 114, 20);
frame.getContentPane().add(amttxtfld);
amttxtfld.setColumns(10);
JLabel lblNewLabel_2 = new JLabel("Your Order will be Delivered within 3 Days ");
lblNewLabel_2.setForeground(new Color(51, 102, 102));
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_2.setBounds(203, 210, 297, 32);
frame.getContentPane().add(lblNewLabel_2);
JLabel lblNewLabel_3 = new JLabel("Thank You for Your Purchase. Visit Again !!");
lblNewLabel_3.setForeground(new Color(51, 102, 102));
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_3.setBounds(179, 289, 383, 32);
frame.getContentPane().add(lblNewLabel_3);
JButton logoutbtn = new JButton("Logout ");
logoutbtn.setForeground(new Color(51, 102, 102));
logoutbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
logoutbtn.setBounds(296, 350, 105, 32);
frame.getContentPane().add(logoutbtn);
JPanel panel = new JPanel();
panel.setBackground(new Color(51, 102, 102));
panel.setBounds(10, 11, 745, 75);
frame.getContentPane().add(panel);
panel.setLayout(null);
JLabel lblNewLabel = new JLabel("Your Payment Transaction Has Been Processed ");
lblNewLabel.setForeground(new Color(204, 255, 255));
lblNewLabel.setBounds(171, 11, 413, 44);
panel.add(lblNewLabel);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
usrnametxtfld = new JTextField();
usrnametxtfld.setBounds(25, 20, 120, 32);
panel.add(usrnametxtfld);
usrnametxtfld.setColumns(10);
JPanel panel_1 = new JPanel();
panel_1.setBackground(new Color(204, 204, 204));
panel_1.setBounds(10, 97, 745, 317);
frame.getContentPane().add(panel_1);
panel_1.setLayout(null);
JLabel lblNewLabel_4 = new JLabel("");
lblNewLabel_4.setIcon(new ImageIcon("C:\\PIMAGE\\pay_cleanup.png"));
lblNewLabel_4.setBounds(0, 0, 745, 317);
panel_1.add(lblNewLabel_4);
logoutbtn.addActionListener(e -> logoutbtnActionPerformed(e));
frame.setVisible(true);
}
}
