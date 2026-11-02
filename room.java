import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

public class room extends JFrame{
    JTable table;
    JButton back;
    room(){
        //Panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(100,120,120));
        panel.setLayout(null);
        add(panel);
        // image of the room
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);
        //tabel room data
        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(100,120,120));
        table.setForeground(Color.WHITE);
        panel.add(table);
        //adding data table in panel
        try {
            con_class c = new con_class();
            String Roominfo = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(Roominfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        //back button
        back = new JButton("BACK");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        //Room number
        JLabel RoomNo = new JLabel("Room No.");
        RoomNo.setBounds(12,15,80,19);
        RoomNo.setForeground(Color.WHITE);
        RoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(RoomNo);
        //availability
        JLabel availability = new JLabel("Availability");
        availability.setBounds(111,15,80,19);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(availability);
        //cleaning
        JLabel cleaning = new JLabel(" Clean Status");
        cleaning.setBounds(216,15,150,19);
        cleaning.setForeground(Color.WHITE);
        cleaning.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(cleaning);
        //price
        JLabel price = new JLabel("Price");
        price.setBounds(320,15,80,19);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);
        //Bed Type
        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(417,15,80,19);
        Bed.setForeground(Color.WHITE);
        Bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Bed);

        setUndecorated(true);
        setLayout(null);
        setLocation(500, 100);
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new room();
    }
}
