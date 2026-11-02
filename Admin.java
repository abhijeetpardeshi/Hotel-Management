import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JButton add_Employee,add_Room,add_Drivers,logout,back;
    Admin(){
        //Employee button
        add_Employee = new JButton("ADD EMPLOYEE");
        add_Employee.setBounds(250,230,200,30);
        add_Employee.setBackground(Color.DARK_GRAY);
        add_Employee.setForeground(Color.WHITE);
        add_Employee.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Employee.addActionListener(this);
        add(add_Employee);
        //Add Room button
        add_Room = new JButton("ADD ROOM");
        add_Room.setBounds(250,380,200,30);
        add_Room.setBackground(Color.DARK_GRAY);
        add_Room.setForeground(Color.WHITE);
        add_Room.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Room.addActionListener(this);
        add(add_Room);
        //Add Drivers button
        add_Drivers = new JButton("ADD DRIVER");
        add_Drivers.setBounds(250,550,200,30);
        add_Drivers.setBackground(Color.DARK_GRAY);
        add_Drivers.setForeground(Color.WHITE);
        add_Drivers.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Drivers.addActionListener(this);
        add(add_Drivers);
        //logout button
        logout = new JButton("Logout");
        logout.setBounds(10,700,95,30);
        logout.setBackground(Color.DARK_GRAY);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma",Font.BOLD,15));
        logout.addActionListener(this);
        add(logout);
        //back button
        back = new JButton("Back");
        back.setBounds(110,700,95,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.addActionListener(this);
        add(back);
        //image for Employee
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image l11 = l1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(l11);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(70,180,120,120);
        add(label);
        //inmage for Room
        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image = imageIcon1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon2);
        label1.setBounds(70,340,120,120);
        add(label1);
        //iamge for Driver
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image l111 = i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(l111);
        JLabel label2 = new JLabel(i22);
        label2.setBounds(70,500,120,120);
        add(label2);

        getContentPane().setBackground(new Color(100,120,120));
        setLayout(null);
        setSize(1950,1090);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add_Employee){
            new AddEmployee();
        } else if (e.getSource()==add_Room) {
            new Add_room();
        } else if (e.getSource()==add_Drivers) {
            new driver();
        } else if (e.getSource()==logout) {
            System.exit(102);
        } else if (e.getSource()==back) {
            new Dashborad();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
