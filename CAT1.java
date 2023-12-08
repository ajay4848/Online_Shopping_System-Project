import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CAT1 {
    private JFrame frame;
    private JTextField t1;
    private JTextField t2;
    JComboBox<String> comboBox;
    String dbURL = "jdbc:mysql://localhost:3306/ajdb";
    String username = "root";
    String password = "Ajay@678";
    private JButton backbtn;
    private JLabel lblNewLabel_2;
    private JLabel label;

    /**
     * Launch the application.
     */
    private void selectbtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        String fname = comboBox.getSelectedItem().toString();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            String sql = "SELECT product_name,count(product_name) FROM ord_disp WHERE product_name= ? group by product_name";
            ps = connection.prepareStatement(sql);
            ps.setString(1, fname);
            rs = ps.executeQuery();

            if (rs.next() == true) {
                String name = rs.getString(1);
                String price = rs.getString(2);
                t1.setText(name);
                t2.setText(price);
            }
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame, f);
        }
    }

    private void backbtnActionPerformed(ActionEvent e) {
        frame.dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CAT1 window = new CAT1();
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
    public CAT1() {
        initialize();
    }

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.getContentPane().setFont(new Font("Yu Gothic UI", Font.PLAIN,
13));
frame.getContentPane().setBackground(Color.LIGHT_GRAY);
frame.setBounds(100, 100, 550, 350);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
comboBox = new JComboBox<String>();
comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"T shirt", "Jeans", "Watch", "Shoes"}));
comboBox.setBounds(41, 44, 125, 28);
frame.getContentPane().add(comboBox);
JButton selectbtn = new JButton("Search");
selectbtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
selectbtn.setBounds(64, 189, 89, 23);
frame.getContentPane().add(selectbtn);
JLabel lblNewLabel = new JLabel("Product Name");
lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
lblNewLabel.setBounds(224, 66, 89, 28);
frame.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("Sales (Qty)");
lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
lblNewLabel_1.setBounds(239, 171, 74, 28);
frame.getContentPane().add(lblNewLabel_1);
t1 = new JTextField();
t1.setBounds(323, 66, 97, 28);
frame.getContentPane().add(t1);
t1.setColumns(10);
t2 = new JTextField();
t2.setBounds(323, 171, 97, 28);
frame.getContentPane().add(t2);
t2.setColumns(10);
backbtn = new JButton("Back");
backbtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
backbtn.setBounds(197, 245, 89, 23);
frame.getContentPane().add(backbtn);
lblNewLabel_2 = new JLabel("");
lblNewLabel_2.setIcon(new ImageIcon("C:\\PIMAGE\\registration.jpg"));
lblNewLabel_2.setBounds(-11, 0, 547, 313);
frame.getContentPane().add(lblNewLabel_2);
JLabel lblNewLabel_3 = new JLabel("New label");
lblNewLabel_3.setBounds(44, 131, 49, 14);
frame.getContentPane().add(lblNewLabel_3);
label = new JLabel("New label");
label.setBounds(92, 250, 49, 14);
frame.getContentPane().add(label);
selectbtn.addActionListener(e -> selectbtnActionPerformed(e));
backbtn.addActionListener(e -> backbtnActionPerformed(e));
frame.setVisible(true);
}
}