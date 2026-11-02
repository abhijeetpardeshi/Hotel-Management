import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class UpdateRoom extends JFrame{
    UpdateRoom(){
        //panel 1
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(100,120,120));
        panel.setLayout(null);
        add(panel);
        //image for update
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);
        //label for update room status
        JLabel label1  = new JLabel("Update Room Status");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        //label for ID
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
        //room number
        JLabel label3  = new JLabel("Room Number :");
        label3.setBounds(25,129,107,14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        //text field for room number
        JTextField textField3 = new JTextField();
        textField3.setBounds(248,129,140,20);
        panel.add(textField3);
        //Availability
        JLabel label4  = new JLabel("Availability :");
        label4.setBounds(25,174,97,14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        //text for the Availability
        JTextField textField4 = new JTextField();
        textField4.setBounds(248,174,140,20);
        panel.add(textField4);
        //clean status
        JLabel label5  = new JLabel("Clean Status :");
        label5.setBounds(25,216,97,14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);
        //text field for the clean status
        JTextField textField5 = new JTextField();
        textField5.setBounds(248,216,140,20);
        panel.add(textField5);
        //update button
        JButton update = new JButton("Update");
        update.setBounds(120,315,89,23);
        update.setBackground(Color.DARK_GRAY);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con_class C = new con_class();
                    String status = textField5.getText();
                    C.statement.executeUpdate("update room set cleaning_status = '"+status+"' where roomnumber = " + textField3.getText());
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //back button
        JButton back = new JButton("Back");
        back.setBounds(180,355,89,23);
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
        check.setBounds(60,355,89,23);
        check.setBackground(Color.DARK_GRAY);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q = "select * from customer where number = '"+id+"'";
                try{
                    con_class c = new con_class();
                    ResultSet resultSet = c.statement.executeQuery(q);

                    while (resultSet.next()){
                        textField3.setText(resultSet.getString("room"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where roomnumber =  '"+textField3.getText()+"'");

                    while (resultSet1.next()){
                        textField4.setText(resultSet1.getString("availability"));
                        textField5.setText(resultSet1.getString("cleaning_status"));
                    }
                }catch (Exception E ){
                    E.printStackTrace();
                }
            }
        });

        setLayout(null);
        setSize(950,450);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateRoom();
    }
}
