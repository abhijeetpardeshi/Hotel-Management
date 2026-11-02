import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber ,TextName, TextCountry,TextDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton add,back;
    NewCustomer(){
        //Background panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(100,120,120));
        add(panel);
        //image for the customer
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550,150,200,200);
        panel.add(imglabel);
        // label for customer
        JLabel labelname = new JLabel("NEW CUSTOMER FROM");
        labelname.setBounds(18,11,260,53);
        labelname.setFont(new Font("Tahoma",Font.BOLD,20));
        labelname.setForeground(Color.WHITE);
        panel.add(labelname);
        // customer id
        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35,76,200,14);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelID);
        //Which id is regster
        comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(Color.DARK_GRAY);
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(comboBox);
        // customer number
        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);
        //customer name
        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(35,151,200,14);
        labelName.setForeground(Color.WHITE);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelName);
        TextName = new JTextField();
        TextName.setBounds(271,151,150,20);
        panel.add(TextName);
        // customer gender
        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelGender);
        //male gender
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(100,120,120));
        r1.setBounds(271,191,80,30);
        panel.add(r1);
        // female gender
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(100,120,120));
        r2.setBounds(350,191,80,30);
        panel.add(r2);
        //customer country
        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setBounds(35,231,200,14);
        labelCountry.setForeground(Color.WHITE);
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCountry);
        TextCountry = new JTextField();
        TextCountry.setBounds(271,231,150,20);
        panel.add(TextCountry);
        //room number
        JLabel labelRoom = new JLabel("Allocated Room Number :");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelRoom);
        c1 = new Choice();
        // geting data
        try {
            con_class c = new con_class();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()){
                c1.add(resultSet.getString("roomnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(100,120,120));
        panel.add(c1);
        // check in
        JLabel labelCIS = new JLabel("Checked-In :");
        labelCIS.setBounds(35,316,200,14);
        labelCIS.setForeground(Color.WHITE);
        labelCIS.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCIS);
        //Date for check in
        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(271,316,200,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(date);
        //customer deposite
        JLabel labelDeposite = new JLabel("Deposite :");
        labelDeposite.setBounds(35,359,200,14);
        labelDeposite.setForeground(Color.WHITE);
        labelDeposite.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelDeposite);
        TextDeposite = new JTextField();
        TextDeposite.setBounds(271,359,150,20);
        panel.add(TextDeposite);
        //add button
        add = new JButton("ADD");
        add.setBounds(100,430,120,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.DARK_GRAY);
        add.addActionListener(this);
        panel.add(add);
        //back button
        back = new JButton("BACK");
        back.setBounds(260,430,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    //logic for add and back button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            con_class c = new con_class();
            String radioBTn = null;
            if (r1.isSelected()){
                radioBTn = "Male";
            } else if (r2.isSelected()) {
                radioBTn = "Female";
            }
            String s1 = (String)comboBox.getSelectedItem();
            String s2 =  textFieldNumber.getText();
            String s3 =  TextName.getText();
            String s4 =  radioBTn;
            String s5 =  TextCountry.getText();
            String s6 =  c1.getSelectedItem();
            String s7 =  date.getText();
            String s8 = TextDeposite.getText();

            try {
                String q ="insert into customer values ('"+s1+"', '"+s2+"','"+s3+"','"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"')";
                String q1 = "update room set availability = 'Occupied' where roomnumber = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "added Successfully");
                setVisible(false);
            }catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
        }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
