import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class MainLogin {
   JFrame frame;

    // ActionListeners
    private void btnNewButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        AdminLogin admin = new AdminLogin();
        frame.dispose();
    }

    private void btnNewButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        customerLogin customerloginframe = new customerLogin();
        // frame.dispose();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainLogin window = new MainLogin();
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
    public MainLogin() {
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
        JLabel lblNewLabel = new JLabel("WELCOME");
        lblNewLabel.setForeground(new Color(255, 255, 204));
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
        lblNewLabel.setBounds(197, 118, 121, 54);
        frame.getContentPane().add(lblNewLabel);
        JButton btnNewButton1 = new JButton("Login as Administrator");
        btnNewButton1.setBackground(UIManager.getColor("ToggleButton.darkShadow"));
        btnNewButton1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnNewButton1.setBounds(150, 183, 215, 36);
        frame.getContentPane().add(btnNewButton1);
        JButton btnNewButton2 = new JButton("Login as Customer");
        btnNewButton2.setBackground(UIManager.getColor("ToolBar.highlight"));
        btnNewButton2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnNewButton2.setBounds(150, 242, 215, 36);
        frame.getContentPane().add(btnNewButton2);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 484, 311);
        panel.setBackground(new Color(0, 250, 154));
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\PIMAGE\\login.jpg"));
        lblNewLabel_1.setBounds(0, 0, 484, 311);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBounds(67, 98, 49, 14);
        panel.add(lblNewLabel_2);
        btnNewButton1.addActionListener(e -> btnNewButton1ActionPerformed(e));
        btnNewButton2.addActionListener(e -> btnNewButton2ActionPerformed(e));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
