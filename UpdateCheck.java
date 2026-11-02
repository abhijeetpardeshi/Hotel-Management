import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class UpdateCheck extends JFrame{
    UpdateCheck(){
        //panel 1
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(100,120,120));
        panel.setLayout(null);
        add(panel);
        //image for the panel
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);
        //label 1
        JLabel label1  = new JLabel("Check-In Details");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        //label 2
        JLabel label2  = new JLabel("ID :");
        label2.setBounds(25,88,46,14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        //choice for the customer id
        Choice c = new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);
        try {
            con_class C = new con_class();
            ResultSet resultSet = C.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                c.add(resultSet.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //label 3
        JLabel label3  = new JLabel("Room Number :");
        label3.setBounds(25,129,107,14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        //text field for room number
        JTextField textField3 = new JTextField();
        textField3.setBounds(248,129,140,20);
        panel.add(textField3);
        //label for name
        JLabel label4  = new JLabel("Name :");
        label4.setBounds(25,174,97,14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        //text field for name
        JTextField textField4 = new JTextField();
        textField4.setBounds(248,174,140,20);
        panel.add(textField4);
        //label for checked in
        JLabel label5  = new JLabel("Checked-in :");
        label5.setBounds(25,216,97,14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);
        //text filed for checked in
        JTextField textField5 = new JTextField();
        textField5.setBounds(248,216,140,20);
        panel.add(textField5);
        //label for amount paid
        JLabel label6  = new JLabel("Amount Paid (Rs) :");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);
        //text field amount paid
        JTextField textField6 = new JTextField();
        textField6.setBounds(248,261,140,20);
        panel.add(textField6);
        //label for pending amount
        JLabel label7  = new JLabel("Pending Amount (Rs) :");
        label7.setBounds(25,302,150,14);
        label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);
        //text field for pendeing amount
        JTextField textField7 = new JTextField();
        textField7.setBounds(248,302,140,20);
        panel.add(textField7);
        //update button
        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.DARK_GRAY);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con_class C = new con_class();
                    String q = c.getSelectedItem();
                    String room = textField3.getText();
                    String name = textField4.getText();
                    String check = textField5.getText();
                    String amount = textField6.getText();
                    C.statement.executeUpdate("update customer  set room = '"+room+"', name = '"+name+"', checkintime = '"+check+"', " +
                            "deposit = '"+amount+"' where number = '"+q+"'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //back button
        JButton back = new JButton("Back");
        back.setBounds(168,378,89,23);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        //check button
        JButton check = new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.DARK_GRAY);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q = "select * from customer where number = '"+id+"'";
                try{
                    con_class C = new con_class();
                    ResultSet resultSet = C.statement.executeQuery(q);
                    while (resultSet.next()){
                        textField3.setText(resultSet.getString("room"));
                        textField4.setText(resultSet.getString("name"));
                        textField5.setText(resultSet.getString("checkintime"));
                        textField6.setText(resultSet.getString("deposit"));
                    }
                    ResultSet resultSet1 = C.statement.executeQuery("select * from room where roomnumber =  '"+textField3.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textField6.getText());
                        textField7.setText(""+amountPaid);
                    }
                }catch (Exception E ){
                    E.printStackTrace();
                }
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(950,500);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateCheck();
    }
}
