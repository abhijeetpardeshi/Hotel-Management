import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_room extends JFrame implements ActionListener {
    JTextField t2,t4;
    JComboBox t3,t5,t6;
    JButton b1,b2;
    Add_room(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(100,120,120));
        panel.setLayout(null);
        add(panel);
        //add rooms
        JLabel l1 = new JLabel("Add Room");
        l1.setBounds(194,10,160,22);
        l1.setFont(new Font("Tahoma",Font.BOLD,22));
        l1.setForeground(Color.WHITE);
        panel.add(l1);
        //room number
        JLabel l2 = new JLabel("Room Number");
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        l2.setBounds(64,70,152,22);
        l2.setForeground(Color.WHITE);
        panel.add(l2);
        t2 = new JTextField();
        t2.setFont(new Font("Tahoma",Font.PLAIN,15));
        t2.setBounds(200,70,156,20);
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(55,50,22));
        panel.add(t2);
        //room available
        JLabel l3 = new JLabel("Availability");
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        l3.setBounds(64,110,152,22);
        l3.setForeground(Color.WHITE);
        panel.add(l3);
        t3 = new JComboBox(new String[]{"Availability","Occupied"});
        t3.setFont(new Font("Tahoma",Font.PLAIN,15));
        t3.setBounds(200,110,156,20);
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(55,50,22));
        panel.add(t3);
        //Price
        JLabel l4 = new JLabel("Price");
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        l4.setBounds(64,150,152,22);
        l4.setForeground(Color.WHITE);
        panel.add(l4);
        t4 = new JTextField();
        t4.setFont(new Font("Tahoma",Font.PLAIN,15));
        t4.setBounds(200,150,156,20);
        t4.setForeground(Color.WHITE);
        t4.setBackground(new Color(55,50,22));
        panel.add(t4);
        //Cleaning Status
        JLabel l5 = new JLabel("Cleaning Status");
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        l5.setBounds(64,190,152,22);
        l5.setForeground(Color.WHITE);
        panel.add(l5);
        t5 = new JComboBox(new String[]{"Cleaned","Dirty"});
        t5.setFont(new Font("Tahoma",Font.PLAIN,15));
        t5.setBounds(200,190,156,20);
        t5.setForeground(Color.WHITE);
        t5.setBackground(new Color(55,50,22));
        panel.add(t5);
        //Bed Type
        JLabel l6 = new JLabel("Bed Type");
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        l6.setBounds(64,230,152,22);
        l6.setForeground(Color.WHITE);
        panel.add(l6);
        t6 = new JComboBox(new String[]{"Single Bed","Double Bed"});
        t6.setFont(new Font("Tahoma",Font.PLAIN,15));
        t6.setBounds(200,230,156,20);
        t6.setForeground(Color.WHITE);
        t6.setBackground(new Color(55,50,22));
        panel.add(t6);
        //Add Button
        b1 = new JButton("Add");
        b1.setBounds(64,321,111,33);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);
        //Back Button
        b2 = new JButton("Back");
        b2.setBounds(198,321,111,33);
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);
        //Background image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(885,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                con_class c = new con_class();
                String room = t2.getText();
                String ava = (String) t3.getSelectedItem();
                String status = (String) t5.getSelectedItem();
                String price = t4.getText();
                String type = (String) t6.getSelectedItem();

                String q = "insert into room values('"+room+"','"+ava+"','"+status+"','"+price+"','"+type+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Room Successfully Added");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Add_room();
    }
}
