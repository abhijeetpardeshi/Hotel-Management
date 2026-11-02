import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashborad extends JFrame implements ActionListener {
    JButton add,rec;
    Dashborad(){
        super("Hotel Management System");
        // RECEPTION
        rec = new JButton("RECEPTION");
        rec.setBounds(425,510,140,30);
        rec.setFont(new Font("Tahoma",Font.BOLD,15));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.WHITE);
        rec.addActionListener(this);
        add(rec);
        //admin
        add = new JButton("ADMIN");
        add.setBounds(880,510,140,30);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        add.setBackground(new Color(255,98,0));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        // Admin pages boss
        ImageIcon imageIconb = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image i2 = imageIconb.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(i2);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(850,300,200,195);
        add(label1);
        // RECEPTION logic
        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image i22 = i111.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon imageIcon111 = new ImageIcon(i22);
        JLabel label11 = new JLabel(imageIcon111);
        label11.setBounds(400,300,200,195);
        add(label11);
        //Dashboard logic
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(1950,1090,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0,0,1950,1090);
        add(label);




        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==rec){
            new Reception();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(false);
        }else{
            new Login2();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dashborad();
    }
}