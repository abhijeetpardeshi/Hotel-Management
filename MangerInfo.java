import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
public class MangerInfo extends JFrame{
    MangerInfo(){
        //panel for the elemenets
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(100,120,120));
        panel.setLayout(null);
        add(panel);
        //table for manger
        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(100,120,120));
        panel.add(table);
        //takeing data
        try{
            con_class c = new con_class();
            String q = "select * from employee where job = 'manager'";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        //back button
        JButton back = new JButton("BACK");
        back.setBounds(350,500,120,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        //panel for the name
        JLabel name = new JLabel("Name");
        name.setBounds(41,11,70,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);
        //Age
        JLabel Age = new JLabel("Age");
        Age.setBounds(159,11,70,19);
        Age.setForeground(Color.WHITE);
        Age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Age);
        //gender
        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(259,11,70,19);
        Gender.setForeground(Color.WHITE);
        Gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Gender);
        //Job
        JLabel Job = new JLabel("Job");
        Job.setBounds(380,11,70,19);
        Job.setForeground(Color.WHITE);
        Job.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Job);
        //Salary
        JLabel Salary = new JLabel("Salary");
        Salary.setBounds(500,11,70,19);
        Salary.setForeground(Color.WHITE);
        Salary.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Salary);
        //Phone
        JLabel Phone = new JLabel("Phone");
        Phone.setBounds(630,11,70,19);
        Phone.setForeground(Color.WHITE);
        Phone.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Phone);
        //Email
        JLabel Email = new JLabel("Email");
        Email.setBounds(780,11,70,19);
        Email.setForeground(Color.WHITE);
        Email.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Email);
        //Aadhar
        JLabel Aadhar = new JLabel("Aadhar");
        Aadhar.setBounds(880,11,70,19);
        Aadhar.setForeground(Color.WHITE);
        Aadhar.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Aadhar);


        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MangerInfo();
    }
}
