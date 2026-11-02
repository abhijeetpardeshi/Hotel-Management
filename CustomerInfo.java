import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class CustomerInfo extends JFrame{
    CustomerInfo(){
        //panel for background
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(100,120,120));
        panel.setLayout(null);
        add(panel);
        //tabel to see customer info
        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(100,120,120));
        table.setForeground(Color.WHITE);
        panel.add(table);
        //data from the customer table
        try{
            con_class c = new con_class();
            String q ="select * from customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        //id of customer
        JLabel id = new JLabel("ID");
        id.setBounds(31,11,100,14);
        id.setForeground(Color.WHITE);
        id.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(id);
        //number of a customer
        JLabel number = new JLabel("Number");
        number.setBounds(150,11,100,14);
        number.setForeground(Color.WHITE);
        number.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(number);
        //name of a customer
        JLabel name = new JLabel("Name");
        name.setBounds(270,11,100,14);
        name.setForeground(Color.WHITE);
        name.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(name);
        // gender of a customer
        JLabel gender = new JLabel("Gender");
        gender.setBounds(360,11,100,14);
        gender.setForeground(Color.WHITE);
        gender.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(gender);
        //country fo a customer
        JLabel country = new JLabel("Country");
        country.setBounds(480,11,100,25);
        country.setForeground(Color.WHITE);
        country.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(country);
        // room number of customer
        JLabel room = new JLabel("Room");
        room.setBounds(600,11,100,14);
        room.setForeground(Color.WHITE);
        room.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(room);
        // Time of check in
        JLabel Time = new JLabel("CI Time");
        Time.setBounds(680,11,100,14);
        Time.setForeground(Color.WHITE);
        Time.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Time);
        // amount that customer deposit
        JLabel Deposit = new JLabel("Deposit");
        Deposit.setBounds(800,11,100,25);
        Deposit.setForeground(Color.WHITE);
        Deposit.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Deposit);
        //back button
        JButton back = new JButton("Back");
        back.setBounds(450,510,120,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(500,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
