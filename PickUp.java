import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
public class PickUp extends JFrame{
    PickUp(){
        //panel 1
        JPanel panel = new JPanel();
        panel.setBackground(new Color(100,120,120));
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        add(panel);
        //pick up service
        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(90,11,160,25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pus);
        //type of car
        JLabel TOC = new JLabel("Type of Car");
        TOC.setBounds(32,97,89,14);
        TOC.setForeground(Color.WHITE);
        TOC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(TOC);
        //choice for the car
        Choice c = new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);
        //
        try {
            con_class C = new con_class();
            ResultSet resultSet = C.statement.executeQuery("select * from driver");
            while (resultSet.next()){
                c.add(resultSet.getString("carname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //
        JTable table = new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(100,120,120));
        table.setForeground(Color.WHITE);
        panel.add(table);
        //
        try {
            con_class C = new con_class();
            String q = "select * from driver";
            ResultSet resultSet = C.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        //label for name
        JLabel name = new JLabel("Name");
        name.setBounds(24,208,46,14);
        name.setForeground(Color.WHITE);
        panel.add(name);
        //age of driver
        JLabel age = new JLabel("Age");
        age.setBounds(165,208,46,14);
        age.setForeground(Color.WHITE);
        panel.add(age);
        //gender of driver
        JLabel gender = new JLabel("Gender");
        gender.setBounds(264,208,46,14);
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        //car company
        JLabel company = new JLabel("Company");
        company.setBounds(366,208,100,14);
        company.setForeground(Color.WHITE);
        panel.add(company);
        //car name
        JLabel Carname = new JLabel("Car Name");
        Carname.setBounds(486,208,100,14);
        Carname.setForeground(Color.WHITE);
        panel.add(Carname);
        // car Available or not
        JLabel available = new JLabel("Available");
        available.setBounds(600,208,100,14);
        available.setForeground(Color.WHITE);
        panel.add(available);
        //loction
        JLabel loacation = new JLabel("Loacation");
        loacation.setBounds(700,208,100,14);
        loacation.setForeground(Color.WHITE);
        panel.add(loacation);
        //display button
        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.DARK_GRAY);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carname = '"+c.getSelectedItem()+"'";
                try{
                    con_class C = new con_class();
                    ResultSet resultSet = C.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //back button
        JButton Back = new JButton("Back");
        Back.setBounds(420,500,120,30);
        Back.setBackground(Color.DARK_GRAY);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PickUp();
    }
}
