import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){
        // panel 1
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(100, 120, 120));
        add(panel);
        //panel 2
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(100,120,120));
        add(panel1);
        //Button for new customer
        JButton btnNCF = new JButton("New Customer From");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setBackground(Color.DARK_GRAY);
        btnNCF.setForeground(Color.WHITE);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NewCustomer();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        // button for room
        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30,70,200,30);
        btnRoom.setBackground(Color.DARK_GRAY);
        btnRoom.setForeground(Color.WHITE);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new room();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        // Deparment
        JButton btnDeparment = new JButton("Deparment");
        btnDeparment.setBounds(30,110,200,30);
        btnDeparment.setBackground(Color.DARK_GRAY);
        btnDeparment.setForeground(Color.WHITE);
        panel1.add(btnDeparment);
        btnDeparment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Deparment();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //All Emp info
        JButton btnAEI = new JButton("All Employee Info");
        btnAEI.setBounds(30,150,200,30);
        btnAEI.setBackground(Color.DARK_GRAY);
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Employee();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //Customer Info
        JButton btnCI = new JButton("Customer Info");
        btnCI.setBounds(30,190,200,30);
        btnCI.setBackground(Color.DARK_GRAY);
        btnCI.setForeground(Color.WHITE);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CustomerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //Manager Info
        JButton btnMI = new JButton(" Manager Info ");
        btnMI.setBounds(30,230,200,30);
        btnMI.setBackground(Color.DARK_GRAY);
        btnMI.setForeground(Color.WHITE);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MangerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //Checkout
        JButton btnCo = new JButton("Check out");
        btnCo.setBounds(30,270,200,30);
        btnCo.setBackground(Color.DARK_GRAY);
        btnCo.setForeground(Color.WHITE);
        panel1.add(btnCo);
        btnCo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new  CheckOut();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //Check In Details Update
        JButton btnIn = new JButton("Update Check in Details");
        btnIn.setBounds(30,310,200,30);
        btnIn.setBackground(Color.DARK_GRAY);
        btnIn.setForeground(Color.WHITE);
        panel1.add(btnIn);
        btnIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateCheck();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //Update room satus
        JButton btnRS = new JButton("Update Room Status");
        btnRS.setBounds(30,350,200,30);
        btnRS.setBackground(Color.DARK_GRAY);
        btnRS.setForeground(Color.WHITE);
        panel1.add(btnRS);
        btnRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        // Pick up service
        JButton btnPUS = new JButton("Pick up service");
        btnPUS.setBounds(30,390,200,30);
        btnPUS.setBackground(Color.DARK_GRAY);
        btnPUS.setForeground(Color.WHITE);
        panel1.add(btnPUS);
        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new PickUp();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        // Search Room
        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30,430,200,30);
        btnSR.setBackground(Color.DARK_GRAY);
        btnSR.setForeground(Color.WHITE);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new SearchRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //log out
        JButton logout = new JButton("Logout");
        logout.setBounds(30,470,95,30);
        logout.setBackground(Color.DARK_GRAY);
        logout.setForeground(Color.WHITE);
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.exit(500);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //back button
        JButton back = new JButton("Back");
        back.setBounds(140,470,95,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    new Dashborad();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
