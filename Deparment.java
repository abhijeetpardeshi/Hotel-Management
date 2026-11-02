import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Deparment extends JFrame{
    Deparment(){
        //panel for the background
        JPanel panel = new JPanel();
        panel.setBackground(new Color(100,120,120));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);
        //table to stored data
        JTable table = new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(100,120,120));
        table.setForeground(Color.WHITE);
        panel.add(table);
        //data in the tabel
        try {
            con_class c = new con_class();
            String deparmentInfo = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(deparmentInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        //back button
        JButton back = new JButton("BACK");
        back.setBounds(400,410,120,30);
        back.setBackground(Color.DARK_GRAY
        );
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        //Label for Deparment
        JLabel label1 = new JLabel("Deparment");
        label1.setBounds(145,11,105,20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);
        //label for Budget
        JLabel label2 = new JLabel("Budget");
        label2.setBounds(431,11,105,20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        setUndecorated(true);
        setLayout(null);
        setLocation(550,150);
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Deparment();
    }
}
