import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login2 extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1, b2;
    Login2(){
        JLabel label1 = new JLabel("Username");
        label1.setBounds(40, 20, 100, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        add(label1);

        // Password
        JLabel label2 = new JLabel("Password");
        label2.setBounds(40, 70, 100, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        add(label2);

        // Username text field
        textField1 = new JTextField();
        textField1.setBounds(150, 20, 150, 30);
        textField1.setForeground(Color.WHITE);
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField1.setBackground(new Color(100, 120, 120));
        add(textField1);

        // Password field
        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 70, 150, 30);
        passwordField1.setForeground(Color.WHITE);
        passwordField1.setBackground(new Color(100, 120, 120));
        add(passwordField1);

        // Login button
        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("Serif", Font.BOLD, 15));
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        // Cancel button
        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("Serif", Font.BOLD, 15));
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        // Frame settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(100, 120, 120));
        setLayout(null);
        setLocation(400, 270);
        setSize(600, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String user = textField1.getText();
            String pass = new String(passwordField1.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username and password.");
                return;
            }

            try {
                con_class c = new con_class();

                if (c.connection == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                 String query = "SELECT * FROM login2 WHERE user_name = ? AND password = ?";
                PreparedStatement ps = c.connection.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    new  Admin();
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    setVisible(false);
                    // You can open the dashboard or next screen here
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }

                rs.close();
                ps.close();
                c.connection.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else {
            new Dashborad();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login2();
    }
}
