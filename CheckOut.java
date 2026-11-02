import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class CheckOut extends JFrame{
    CheckOut(){
        //
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(100,120,120));
        panel.setLayout(null);
        add(panel);
        //check out
        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,100,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);
        //customer id
        JLabel UserId = new JLabel("Customer Id");
        UserId.setBounds(30,80,150,30);
        UserId.setFont(new Font("Tahoma",Font.BOLD,14));
        UserId.setForeground(Color.WHITE);
        panel.add(UserId);
        //choice for the customer
        Choice Customer = new Choice();
        Customer.setBounds(200,80,150,25);
        panel.add(Customer);
        //room number
        JLabel roomNum = new JLabel("Room Number");
        roomNum.setBounds(30,130,150,30);
        roomNum.setFont(new Font("Tahoma",Font.BOLD,14));
        roomNum.setForeground(Color.WHITE);
        panel.add(roomNum);
        //label for the roomnumber
        JLabel labelRoomnumber = new JLabel();
        labelRoomnumber.setBounds(200,130,150,30);
        labelRoomnumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoomnumber.setForeground(Color.WHITE);
        panel.add(labelRoomnumber);
        //check in time
        JLabel checkintime = new JLabel("Check-In Time");
        checkintime.setBounds(30,180,150,30);
        checkintime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkintime.setForeground(Color.WHITE);
        panel.add(checkintime);
        //label for the check time
        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(200,180,200,30);
        labelcheckintime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckintime.setForeground(Color.WHITE);
        panel.add(labelcheckintime);
        //check out time
        JLabel checkouttime = new JLabel("Check-Out Time");
        checkouttime.setBounds(30,230,150,30);
        checkouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkouttime.setForeground(Color.WHITE);
        panel.add(checkouttime);
        //date declaration
        Date date = new Date();
        //label for the date
        JLabel labelcheckouttime = new JLabel(""+date);
        labelcheckouttime.setBounds(200,230,200,30);
        labelcheckouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckouttime.setForeground(Color.WHITE);
        panel.add(labelcheckouttime);
        try{
            con_class c = new con_class();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                Customer.add(resultSet.getString("number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        //button for the check out
        JButton checkOut = new JButton(" Check-Out");
        checkOut.setBounds(30,300,120,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.DARK_GRAY);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                     con_class cv = new con_class();
                    cv.statement.executeUpdate("delete from customer where number = '"+Customer.getSelectedItem()+"'");
                    cv.statement.executeUpdate("update room set availability = 'availability' where roomnumber = '"+labelRoomnumber.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                }catch (Exception E ){
                    E.printStackTrace();
                }
            }
        });
        //button for the check
        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.DARK_GRAY);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con_class c = new con_class();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from customer where number = '"+Customer.getSelectedItem()+"'");
                    while (resultSet.next()){
                        labelRoomnumber.setText(resultSet.getString("room"));
                        labelcheckintime.setText(resultSet.getString("checkintime"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //button for the back
        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.DARK_GRAY);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(800,400);
        setLocation(500,210);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CheckOut();
    }
}
