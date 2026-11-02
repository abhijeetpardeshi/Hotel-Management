import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField nameText,ageText,salaryText,phone, Aadhar,emailText;
    JRadioButton radioButtonM,radioButtonF;
    JComboBox jComboBox;
    JButton add,back;
    AddEmployee(){
        //Background
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setLayout(null);
        panel.setBackground(new Color(100,120,120));
        add(panel);
        //Name
        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,150,27);
        name.setFont(new Font("serif",Font.BOLD,17));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameText = new JTextField();
        nameText.setBounds(200,30,150,27);
        nameText.setBackground(new Color(55,50,22));
        nameText.setFont(new Font("Tahoma",Font.BOLD,15));
        nameText.setForeground(Color.WHITE);
        panel.add(nameText);
        //Age Text
        JLabel Age = new JLabel("AGE");
        Age.setBounds(60,80,150,27);
        Age.setFont(new Font("serif",Font.BOLD,17));
        Age.setForeground(Color.WHITE);
        panel.add(Age);
        ageText = new JTextField();
        ageText.setBounds(200,80,150,27);
        ageText.setBackground(new Color(55,50,22));
        ageText.setFont(new Font("Tahoma",Font.BOLD,15));
        ageText.setForeground(Color.WHITE);
        panel.add(ageText);
        //Gender
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,120,150,27);
        gender.setFont(new Font("serif",Font.BOLD,17));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        //Male Button
        radioButtonM = new JRadioButton("MALE");
        radioButtonM.setBounds(200,120,70,27);
        radioButtonM.setBackground(new Color(100,120,120));
        radioButtonM.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonM.setForeground(Color.WHITE);
        panel.add(radioButtonM);
        //Female Button
        radioButtonF = new JRadioButton("FEMALE");
        radioButtonF.setBounds(280,120,100,27);
        radioButtonF.setBackground(new Color(100,120,120));
        radioButtonF.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonF.setForeground(Color.WHITE);
        panel.add(radioButtonF);
        //Job
        JLabel job = new JLabel("JOB");
        job.setBounds(60,170,150,27);
        job.setFont(new Font("serif",Font.BOLD,17));
        job.setForeground(Color.WHITE);
        panel.add(job);
        //types of job
        jComboBox = new JComboBox(new String[]{"Front Desk","Housekeeping","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        jComboBox.setBackground(new Color(55,50,22));
        jComboBox.setBounds(200,170,150,30);
        jComboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        jComboBox.setForeground(Color.WHITE);
        panel.add(jComboBox);
        //Salary
        JLabel Salary = new JLabel("SALARY");
        Salary.setBounds(60,220,150,27);
        Salary.setFont(new Font("serif",Font.BOLD,17));
        Salary.setForeground(Color.WHITE);
        panel.add(Salary);
        salaryText = new JTextField();
        salaryText.setBounds(200,220,150,27);
        salaryText.setBackground(new Color(55,50,22));
        salaryText.setFont(new Font("Tahoma",Font.BOLD,15));
        salaryText.setForeground(Color.WHITE);
        panel.add(salaryText);
        //Phone number
        JLabel Phone = new JLabel("PHONE");
        Phone.setBounds(60,270,150,27);
        Phone.setFont(new Font("serif",Font.BOLD,17));
        Phone.setForeground(Color.WHITE);
        panel.add(Phone);
        phone = new JTextField();
        phone.setBounds(200,270,150,27);
        phone.setBackground(new Color(55,50,22));
        phone.setFont(new Font("Tahoma",Font.BOLD,15));
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        //aadhar
        JLabel aadhar = new JLabel("ADDHAR");
        aadhar.setBounds(60,320,150,27);
        aadhar.setFont(new Font("serif",Font.BOLD,17));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);
        Aadhar = new JTextField();
        Aadhar.setBounds(200,320,150,27);
        Aadhar.setBackground(new Color(55,50,22));
        Aadhar.setFont(new Font("Tahoma",Font.BOLD,15));
        Aadhar.setForeground(Color.WHITE);
        panel.add(Aadhar);
        //Email
        JLabel Email = new JLabel("EMAIL");
        Email.setBounds(60,370,150,27);
        Email.setFont(new Font("serif",Font.BOLD,17));
        Email.setForeground(Color.WHITE);
        panel.add(Email);
        emailText = new JTextField();
        emailText.setBounds(200,370,150,27);
        emailText.setBackground(new Color(55,50,22));
        emailText.setFont(new Font("Tahoma",Font.BOLD,15));
        emailText.setForeground(Color.WHITE);
        panel.add(emailText);
        //ADD EMPLOYEE DETAILS
        JLabel AED = new JLabel("ADD EMPLOYEE DETAILS");
        AED.setBounds(450,24,445,35);
        AED.setFont(new Font("Tahoma",Font.BOLD,31));
        AED.setForeground(Color.WHITE);
        panel.add(AED);
        //Add
        add = new JButton("ADD");
        add.setBounds(80,420,100,30);
        add.setBackground(Color.DARK_GRAY);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);
        //Back
        back = new JButton("BACK");
        back.setBounds(200,420,100,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        //Image for the add Employee
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,100,300,300);
        panel.add(label);

        setUndecorated(true);
        setLocation(60,160);
        setLayout(null);
        setSize(900,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String name = nameText.getText();
            String age = ageText.getText();
            String salary = salaryText.getText();
            String Phone = phone.getText();
            String email = emailText.getText();
            String aadhar = Aadhar.getText();
            String job =(String) jComboBox.getSelectedItem();
            String gender = null;
            if (radioButtonM.isSelected()){
                gender = "Male";
            } else if (radioButtonF.isSelected()) {
                gender = "Female";
            }
            try{
                con_class c = new con_class();
                String q = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+Phone+"','"+email+"','"+aadhar+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Employee Added");
                setVisible(false);
            }catch (Exception e1){
                e1.printStackTrace();
            }

        }else {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
