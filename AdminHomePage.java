import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

public class AdminHomePage {
    String dbURL = "jdbc:mysql://localhost:3306/ajdb";
    String username = "root";
    String password = "Ajay@678";
    private JFrame frame;
    private JTable table;
    private JTable table2;
    JComboBox<String> comboBox;

    /**
     * Launch the application.
     */
    private void loadtable() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            String sql = "SELECT * from ord_rcv";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame, f);
        }
    }

    private void loadtab() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            String sql = "SELECT * from ord_disp";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            table2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame, f);
        }
    }

    private void selectbtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        String cat = comboBox.getSelectedItem().toString();

        if (cat == "CAT1") {
            CAT1 cat1 = new CAT1();
        } else if (cat == "CAT2") {
            CAT2 cat2 = new CAT2();
        } else if (cat == "CAT3") {
            CAT3 cat3 = new CAT3();
        } else if (cat == "CAT4") {
            CAT4 cat4 = new CAT4();
        }
    }

    private void dispatchbtnActionPerformed(ActionEvent e) {
        // TODO add your code here.
        int flag = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            String sql = "INSERT into ord_disp SELECT * from ord_rcv";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            loadtab();
            flag = 1;

            if (flag == 1) {
                Connection con = null;
                PreparedStatement ps2 = null;
                ResultSet rs2 = null;

                try {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    con = DriverManager.getConnection(dbURL, username, password);
                    String sql2 = "truncate table ord_rcv";
                    ps2 = con.prepareStatement(sql2);
                    ps2.executeUpdate();
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(frame, f);
                }
            }
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame, f);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminHomePage window = new AdminHomePage();
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
    public AdminHomePage() {
        initialize();
        loadtable();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 850, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 275, 486);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "CAT1", "CAT2", "CAT3", "CAT4" }));
        comboBox.setBounds(27, 62, 149, 22);
        panel.add(comboBox);
        JButton selectbtn = new JButton("");
        selectbtn.setIcon(new ImageIcon("C:\\PIMAGE\\searchicon.png"));
        selectbtn.setBounds(196, 60, 33, 30);
        panel.add(selectbtn);
        JLabel lblNewLabel_4 = new JLabel("Dashboard ");
        lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
        lblNewLabel_4.setBounds(74, 11, 116, 30);
        panel.add(lblNewLabel_4);
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.GRAY);
        panel_1.setBounds(275, 0, 559, 486);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        table = new JTable();
        table.setBounds(20, 87, 251, 329);
        panel_1.add(table);
        table2 = new JTable();
        table2.setBounds(295, 87, 238, 329);
        panel_1.add(table2);
        JLabel lblNewLabel = new JLabel("Orders Received ");
        lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
        lblNewLabel.setBounds(82, 40, 168, 25);
        panel_1.add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("Orders Dispatched ");
        lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
        lblNewLabel_1.setBounds(341, 40, 208, 25);
        panel_1.add(lblNewLabel_1);
        JButton dispatchbtn = new JButton("Dispatch ");
        dispatchbtn.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
        dispatchbtn.setBounds(90, 436, 107, 25);
        panel_1.add(dispatchbtn);
        
        JButton btnClose = new JButton("Back");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		AdminLogin hmp=new AdminLogin();
        		hmp.frame.setVisible(true);
        	}
        });
        btnClose.setBounds(367, 439, 89, 23);
        panel_1.add(btnClose);
        dispatchbtn.addActionListener(e -> dispatchbtnActionPerformed(e));
        selectbtn.addActionListener(e -> selectbtnActionPerformed(e));
        frame.setVisible(true);
    }
}
