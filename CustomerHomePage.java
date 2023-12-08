import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;

public class CustomerHomePage {
    String n1, n2, n3, n4, name;
    String p1, p2, p3, p4;
    String dbURL = "jdbc:mysql://localhost:3306/ajdb";
    String username = "root";
    String password = "Ajay@678";
    JFrame frame;
    private JTextField tf12;
    private JTextField tf11;
    private JTextField tf21;
    private JTextField tf22;
    private JTextField tf31;
    private JTextField tf32;
    private JTextField tf41;
    private JTextField tf42;
    JComboBox<String> fashionjbox;
    JComboBox<String> sportsjbox;
    JComboBox<String> elecjbox;
    JComboBox<String> pharmajbox;
    private JTable table;
    private JTextField usrtxt;

/**
* Launch the application.
*/
//Select buttons
private void fashionselectbtnActionPerformed(ActionEvent e) {
 // TODO add your code here
 String fname = fashionjbox.getSelectedItem().toString();
 
 Connection connection = null;
PreparedStatement ps = null;
ResultSet rs = null;
try{
 connection = DriverManager.getConnection(dbURL, username, password);
 String sql = "SELECT product_name,product_price FROM product WHERE product_name= ?";
 ps = connection.prepareStatement(sql);
 ps.setString(1, fname);
 rs = ps.executeQuery();
 
 if(rs.next() == true) {
 String name = rs.getString(1);
 String price = rs.getString(2);
 
 n1 = name;
 p1 = price;
 
 tf11.setText(name);
 tf12.setText(price);
 }
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);}
 }

private void sportsselectbtnActionPerformed(ActionEvent e) {
 // TODO add your code here
 String fname = sportsjbox.getSelectedItem().toString();
 
 Connection connection = null;
PreparedStatement ps = null;
ResultSet rs = null;
try{
 connection = DriverManager.getConnection(dbURL, username, password);
 String sql = "SELECT product_name,product_price FROM product WHERE product_name= ?";
 ps = connection.prepareStatement(sql);
 ps.setString(1, fname);
 rs = ps.executeQuery();
 
 if(rs.next() == true) {
 String name = rs.getString(1);
 String price = rs.getString(2);
 
 n2 = name;
 p2 = price;
 
 tf21.setText(name);
 tf22.setText(price);
 }
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
 }

private void elecselectbtnActionPerformed(ActionEvent e) {
 // TODO add your code here
 String fname = elecjbox.getSelectedItem().toString();
 
 Connection connection = null;
PreparedStatement ps = null;
ResultSet rs = null;
try{
 connection = DriverManager.getConnection(dbURL, username, password);
 String sql = "SELECT product_name,product_price FROM product WHERE product_name= ?";
 ps = connection.prepareStatement(sql);
 ps.setString(1, fname);
 rs = ps.executeQuery();
 
 if(rs.next() == true) {
 String name = rs.getString(1);
 String price = rs.getString(2);
 
 n3 = name;
 p3 = price;
 
 tf31.setText(name);
 tf32.setText(price);
 }
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
 }

private void pharmaselectbtnActionPerformed(ActionEvent e) {
 // TODO add your code here
 String fname = pharmajbox.getSelectedItem().toString();
 
 Connection connection = null;
PreparedStatement ps = null;
ResultSet rs = null;
try{
 connection = DriverManager.getConnection(dbURL, username, password);
 String sql = "SELECT product_name,product_price FROM product WHERE product_name= ?";
 ps = connection.prepareStatement(sql);
 ps.setString(1, fname);
 rs = ps.executeQuery();
 
 if(rs.next() == true) {
 String name = rs.getString(1);
 String price = rs.getString(2);
 
 n4 = name;
 p4 = price;
 
 tf41.setText(name);
 tf42.setText(price);
 }
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
 }

    // Add To Cart
private void fashionaddbtnActionPerformed(ActionEvent e) {
 // TODO add your code here
int flag = 0;
 Connection connection = null;
PreparedStatement ps = null;
ResultSet rs = null;
try{
 connection = DriverManager.getConnection(dbURL, username, password);
 String sql = "INSERT into purchase(product_name,product_price) values(?,?)";
 ps = connection.prepareStatement(sql);
 ps.setString(1, n1);
 ps.setString(2, p1);
 ps.executeUpdate();
 flag = 1;
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
loadtable();
if(flag == 1) {
Connection con = null;
PreparedStatement ps2 = null;
ResultSet rs2 = null;
try{
 con = DriverManager.getConnection(dbURL, username, password);
 String sql2 = "INSERT into ord_rcv (username, product_name , product_price) values (?,?,?)";
 ps2 = con.prepareStatement(sql2);
 ps2.setString(1, name);
 ps2.setString(2, n1);
 ps2.setString(3, p1);
 ps2.execute();
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
}
 }

private void sportsaddbtnActionPerformed(ActionEvent e) {
 // TODO add your code here
int flag = 0;
Connection connection = null;
PreparedStatement ps = null;
ResultSet rs = null;
try{
 connection = DriverManager.getConnection(dbURL, username, password);
 String sql = "INSERT into purchase(product_name,product_price) values(?,?)";
 ps = connection.prepareStatement(sql);
 ps.setString(1, n2);
 ps.setString(2, p2);
 ps.executeUpdate();
 flag = 1;
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
loadtable();
if(flag == 1) {
Connection con = null;
PreparedStatement ps2 = null;
ResultSet rs2 = null;
try{
 con = DriverManager.getConnection(dbURL, username, password);
 String sql2 = "INSERT into ord_rcv (username, product_name , product_price) values (?,?,?)";
 ps2 = con.prepareStatement(sql2);
 ps2.setString(1, name);
 ps2.setString(2, n2);
 ps2.setString(3, p2);
 ps2.executeUpdate();
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
}
 }

private void elecaddbtnActionPerformed(ActionEvent e) {
 // TODO add your code here
int flag = 0;
Connection connection = null;
PreparedStatement ps = null;
ResultSet rs = null;
try{
 connection = DriverManager.getConnection(dbURL, username, password);
 String sql = "INSERT into purchase(product_name,product_price) values(?,?)";
 ps = connection.prepareStatement(sql);
 ps.setString(1, n3);
 ps.setString(2, p3);
 ps.executeUpdate();
 flag = 1;
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
loadtable();
if(flag == 1) {
Connection con = null;
PreparedStatement ps2 = null;
ResultSet rs2 = null;
try{
 con = DriverManager.getConnection(dbURL, username, password);
 String sql2 = "INSERT into ord_rcv (username, product_name , product_price) values (?,?,?)";
 ps2 = con.prepareStatement(sql2);
 ps2.setString(1, name);
 ps2.setString(2, n3);
 ps2.setString(3, p3);
 ps2.executeUpdate();
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
}
 }

private void pharmaaddbtnActionPerformed(ActionEvent e) {
 // TODO add your code here
int flag = 0;
Connection connection = null;
PreparedStatement ps = null;
ResultSet rs = null;
try{
 connection = DriverManager.getConnection(dbURL, username, password);
 String sql = "INSERT into purchase(product_name,product_price) values(?,?)";
 ps = connection.prepareStatement(sql);
 ps.setString(1, n4);
 ps.setString(2, p4);
 ps.executeUpdate();
 flag = 1;
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
loadtable();
if(flag == 1) {
Connection con = null;
PreparedStatement ps2 = null;
ResultSet rs2 = null;
try{
 con = DriverManager.getConnection(dbURL, username, password);
 String sql2 = "INSERT into ord_rcv (username, product_name , product_price) values (?,?,?)";
 ps2 = con.prepareStatement(sql2);
 ps2.setString(1, name);
 ps2.setString(2, n4);
 ps2.setString(3, p4);
 ps2.executeUpdate();
 }
 catch(Exception f){JOptionPane.showMessageDialog(frame,f);} 
}
 }

    private void ptpbtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        Payment pay = new Payment();
        frame.dispose();
    }

    private void loadtable() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            String sql = "SELECT * from purchase";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame, f);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerHomePage window = new CustomerHomePage();
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
    public CustomerHomePage() {
        initialize();
        username();
        admin();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void admin() {
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
                name = rs.getString(1);
                usrtxt.setText(name);
            }
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame, f);
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 204, 204));
        panel.setBounds(0, 0, 264, 561);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        JLabel lblNewLabel = new JLabel("My Cart");
        lblNewLabel.setForeground(new Color(0, 0, 102));
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        lblNewLabel.setBounds(91, 86, 112, 45);
        panel.add(lblNewLabel);
        JButton ptpbtn = new JButton("Procced to Payment");
        ptpbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        ptpbtn.setBounds(42, 511, 183, 28);
        panel.add(ptpbtn);
        table = new JTable();
        table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        table.setBounds(23, 172, 214, 285);
        panel.add(table);
        JLabel lblNewLabel_9 = new JLabel("Product Name");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_9.setBounds(23, 142, 88, 28);
        panel.add(lblNewLabel_9);
        JLabel lblNewLabel_10 = new JLabel("Product Price");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_10.setBounds(137, 142, 88, 28);
        panel.add(lblNewLabel_10);
        usrtxt = new JTextField();
        usrtxt.setBounds(23, 29, 118, 28);
        panel.add(usrtxt);
        usrtxt.setColumns(10);
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(51, 102, 102));
        panel_1.setBounds(263, 0, 621, 561);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(20, 27, 271, 241);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        JButton fashionaddbtn = new JButton("Add to cart");
        fashionaddbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        fashionaddbtn.setBounds(67, 191, 112, 23);
        panel_2.add(fashionaddbtn);
        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 204));
        lblNewLabel_1.setBounds(46, 96, 73, 23);
        panel_2.add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("Price");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_2.setForeground(new Color(255, 255, 153));
        lblNewLabel_2.setBounds(46, 130, 73, 23);
        panel_2.add(lblNewLabel_2);
        tf12 = new JTextField();
        tf12.setBounds(129, 131, 92, 20);
        panel_2.add(tf12);
        tf12.setColumns(10);
        tf11 = new JTextField();
        tf11.setBounds(129, 97, 92, 20);
        panel_2.add(tf11);
        tf11.setColumns(10);
        fashionjbox = new JComboBox<String>();
        fashionjbox.setFont(new Font("Tahoma", Font.BOLD, 15));
        fashionjbox.setBounds(34, 11, 145, 34);
        fashionjbox.setModel(new DefaultComboBoxModel<String>(new String[] { "T shirt", "Jeans", "Watch", "Shoes" }));
        panel_2.add(fashionjbox);
        JButton fashionselectbtn = new JButton("");
        fashionselectbtn.setIcon(new ImageIcon("C:\\PIMAGE\\searchicon.png"));
        fashionselectbtn.setBounds(189, 13, 32, 29);
        panel_2.add(fashionselectbtn);
        JLabel lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setIcon(new ImageIcon("C:\\PIMAGE\\fashion.jpg"));
        lblNewLabel_11.setBounds(0, 0, 271, 241);
        panel_2.add(lblNewLabel_11);
        
        JLabel lblNewLabel_15 = new JLabel("");
        lblNewLabel_15.setIcon(new ImageIcon("C:\\PIMAGE\\fashion2.jpg"));
        lblNewLabel_15.setBounds(0, 0, 271, 241);
        panel_2.add(lblNewLabel_15);
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(316, 27, 271, 241);
        panel_1.add(panel_3);
        panel_3.setLayout(null);
        JButton sportsaddbtn = new JButton("Add to cart");
        sportsaddbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        sportsaddbtn.setBounds(82, 193, 113, 23);
        panel_3.add(sportsaddbtn);
        JLabel lblNewLabel_3 = new JLabel("Name");
        lblNewLabel_3.setForeground(new Color(0, 0, 102));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_3.setBounds(34, 109, 83, 28);
        panel_3.add(lblNewLabel_3);
        JLabel lblNewLabel_4 = new JLabel("Price");
        lblNewLabel_4.setForeground(new Color(0, 0, 51));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_4.setBounds(34, 148, 85, 23);
        panel_3.add(lblNewLabel_4);
        tf21 = new JTextField();
        tf21.setBounds(127, 113, 92, 20);
        panel_3.add(tf21);
        tf21.setColumns(10);
        tf22 = new JTextField();
        tf22.setBounds(127, 149, 92, 20);
        panel_3.add(tf22);
        tf22.setColumns(10);
        sportsjbox = new JComboBox<String>();
        sportsjbox.setFont(new Font("Tahoma", Font.BOLD, 15));
        sportsjbox.setModel(new DefaultComboBoxModel<String>(new String[] { "Bat",
                "Football", "Basketball", "Volleyball" }));
        sportsjbox.setBounds(34, 11, 146, 33);
        panel_3.add(sportsjbox);
        JButton sportsselectbtn = new JButton("");
        sportsselectbtn.setIcon(new ImageIcon("C:\\PIMAGE\\searchicon.png"));
        sportsselectbtn.setBounds(190, 11, 33, 33);
        panel_3.add(sportsselectbtn);
        JLabel lblNewLabel_12 = new JLabel("");
        lblNewLabel_12.setIcon(new ImageIcon("C:\\PIMAGE\\sports.jpg"));
        lblNewLabel_12.setBounds(0, -11, 271, 241);
        panel_3.add(lblNewLabel_12);
        
        JLabel lblNewLabel_16 = new JLabel("");
        lblNewLabel_16.setIcon(new ImageIcon("C:\\PIMAGE\\sport.jpg"));
        lblNewLabel_16.setBounds(0, 0, 271, 241);
        panel_3.add(lblNewLabel_16);
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(23, 297, 268, 241);
        panel_1.add(panel_4);
        panel_4.setLayout(null);
        JButton elecaddbtn = new JButton("Add to cart");
        elecaddbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        elecaddbtn.setBounds(81, 207, 108, 23);
        panel_4.add(elecaddbtn);
        JLabel lblNewLabel_5 = new JLabel("Name");
        lblNewLabel_5.setForeground(new Color(255, 255, 102));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_5.setBounds(42, 118, 87, 30);
        panel_4.add(lblNewLabel_5);
        JLabel lblNewLabel_6 = new JLabel("Price");
        lblNewLabel_6.setForeground(new Color(255, 255, 0));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_6.setBounds(42, 159, 87, 32);
        panel_4.add(lblNewLabel_6);
        tf31 = new JTextField();
        tf31.setBounds(126, 123, 95, 20);
        panel_4.add(tf31);
        tf31.setColumns(10);
        tf32 = new JTextField();
        tf32.setBounds(126, 165, 95, 20);
        panel_4.add(tf32);
        tf32.setColumns(10);
        elecjbox = new JComboBox<String>();
        elecjbox.setFont(new Font("Dialog", Font.BOLD, 15));
        elecjbox.setModel(new DefaultComboBoxModel<String>(new String[] { "Mobile",
                "Washing Machine", "Laptop", "Earphones" }));
        elecjbox.setBounds(26, 11, 146, 32);
        panel_4.add(elecjbox);
        JButton elecselectbtn = new JButton("");
        elecselectbtn.setIcon(new ImageIcon("C:\\PIMAGE\\searchicon.png"));
        elecselectbtn.setBounds(182, 11, 32, 30);
        panel_4.add(elecselectbtn);
        JLabel lblNewLabel_13 = new JLabel("");
        lblNewLabel_13.setIcon(new ImageIcon("C:\\PIMAGE\\electronics.jpg"));
        lblNewLabel_13.setBounds(0, 0, 268, 241);
        panel_4.add(lblNewLabel_13);
        JPanel panel_5 = new JPanel();
        panel_5.setBounds(316, 297, 271, 241);
        panel_1.add(panel_5);
        panel_5.setLayout(null);
        JButton pharmaaddbtn = new JButton("Add to cart");
        pharmaaddbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        pharmaaddbtn.setBounds(92, 207, 112, 23);
        panel_5.add(pharmaaddbtn);
        pharmajbox = new JComboBox<String>();
        pharmajbox.setFont(new Font("Dialog", Font.BOLD, 15));
        pharmajbox.setModel(new DefaultComboBoxModel<String>(
                new String[] { "Firstaid Kit", "Glucose", "Painkillers", "Medical Kit" }));
        pharmajbox.setBounds(42, 11, 140, 36);
        panel_5.add(pharmajbox);
        JButton pharmaselectbtn = new JButton("");
        pharmaselectbtn.setIcon(new ImageIcon("C:\\PIMAGE\\searchicon.png"));
        pharmaselectbtn.setBounds(192, 13, 33, 34);
        panel_5.add(pharmaselectbtn);
        JLabel lblNewLabel_7 = new JLabel("Name");
        lblNewLabel_7.setForeground(new Color(0, 0, 153));
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_7.setBounds(42, 123, 73, 23);
        panel_5.add(lblNewLabel_7);
        JLabel lblNewLabel_8 = new JLabel("Price");
        lblNewLabel_8.setForeground(new Color(0, 0, 51));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_8.setBounds(42, 166, 73, 30);
        panel_5.add(lblNewLabel_8);
        tf41 = new JTextField();
        tf41.setBounds(125, 124, 98, 20);
        panel_5.add(tf41);
        tf41.setColumns(10);
        tf42 = new JTextField();
        tf42.setBounds(125, 171, 98, 20);
        panel_5.add(tf42);
        tf42.setColumns(10);
        JLabel lblNewLabel_14 = new JLabel("");
        lblNewLabel_14.setIcon(new ImageIcon("C:\\PIMAGE\\pharmacy.jpg"));
        lblNewLabel_14.setBounds(0, 0, 271, 241);
        panel_5.add(lblNewLabel_14);
        fashionselectbtn.addActionListener(e -> fashionselectbtnActionPerformed(e));
        sportsselectbtn.addActionListener(e -> sportsselectbtnActionPerformed(e));
        elecselectbtn.addActionListener(e -> elecselectbtnActionPerformed(e));
        pharmaselectbtn.addActionListener(e -> pharmaselectbtnActionPerformed(e));
        fashionaddbtn.addActionListener(e -> fashionaddbtnActionPerformed(e));
        sportsaddbtn.addActionListener(e -> sportsaddbtnActionPerformed(e));
        elecaddbtn.addActionListener(e -> elecaddbtnActionPerformed(e));
        pharmaaddbtn.addActionListener(e -> pharmaaddbtnActionPerformed(e));
        ptpbtn.addActionListener(e -> ptpbtnActionPerformed(e));
        frame.setVisible(true);
    }
}
