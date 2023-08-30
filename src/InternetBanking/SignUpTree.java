
package InternetBanking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class SignUpTree extends JFrame implements ActionListener {
    
    String randomNo;
    JLabel formNo, page, acType, services, userName;
    JTextField userNameField;
    JRadioButton b1, b2, b3, b4;
    ButtonGroup acTypeGroup;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton createAc;
    
    SignUpTree(String randomNo) {
        setTitle("account stup : new account details");
        
        ImageIcon sbiImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/sbiRoundLogo.png"));
        Image sbiImage = sbiImageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(sbiImage);
        JLabel imageLabel = new JLabel(newImageIcon);
        imageLabel.setBounds(0, 0, 100, 100);
        add(imageLabel);
        
        this.randomNo = randomNo;
        formNo = new JLabel("Application No. " + randomNo);
        formNo.setBounds(200, 30, 400, 50);
        formNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(formNo);

        page = new JLabel("page 3 : new account details");
        page.setBounds(100, 100, 200, 20);
        page.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        add(page);
        
        userName = new JLabel("Create Username :");
        userName.setBounds(100, 150, 150, 20);
        userName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(userName);
        
        userNameField = new JTextField(10);
        userNameField.setBounds(230, 150, 220, 20);
        userNameField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(userNameField);
        
        
        acType = new JLabel("Choose Account Type : ");
        acType.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        acType.setBounds(100, 190, 200, 20);
        add(acType);
        
        b1 = new JRadioButton("Savings Account");
        b2 = new JRadioButton("Fixed Deposit Account");
        b3 = new JRadioButton("Current Account");
        b4 = new JRadioButton("Recurring Deposit Account");
        b1.setBounds(150, 230, 150, 20);
        b2.setBounds(300, 230, 200, 20);
        b3.setBounds(150, 270, 150, 20);
        b4.setBounds(300, 270, 200, 20);
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b3.setBackground(Color.WHITE);
        b4.setBackground(Color.WHITE);
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        b4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        
        acTypeGroup = new ButtonGroup();
        acTypeGroup.add(b1);
        acTypeGroup.add(b2);
        acTypeGroup.add(b3);
        acTypeGroup.add(b4);
        
        services = new JLabel("Select Srvices :");
        services.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        services.setBounds(100, 310, 100, 20);
        add(services);
        
        c1 = new JCheckBox("Debit Card");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Cheque Book");
        c4 = new JCheckBox("Credit Card");
        c5 = new JCheckBox("SMS & E-mail Alerts");
        c1.setBounds(150, 350, 100, 20);
        c2.setBounds(300, 350, 150, 20);
        c3.setBounds(150, 390, 150, 20);
        c4.setBounds(300, 390, 150, 20);
        c5.setBounds(150, 430, 200, 20);
        c1.setBackground(Color.WHITE);
        c2.setBackground(Color.WHITE);
        c3.setBackground(Color.WHITE);
        c4.setBackground(Color.WHITE);
        c5.setBackground(Color.WHITE);
        c1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        
        add(c1);
        add(c2);
        add(c3);
        add(c4);
        add(c5);
        
        c6 = new JCheckBox("i agree with banking turms and conditions!");
        c6.setBounds(100, 500, 400, 20);
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(c6);
            
        
        createAc = new JButton("Create Account");
        createAc.setBounds(350, 550, 150, 30);
        createAc.setFont(new Font("Times New Roman", Font.BOLD, 16));
        createAc.setBackground(Color.BLACK);
        createAc.setForeground(Color.WHITE);
        createAc.addActionListener(this);
        add(createAc);
                
        setSize(600, 700);
        setLayout(null);
        setLocation(650, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));
    }
    public void actionPerformed(ActionEvent ae) {
        String accountNo = SignUpOne.generateAcNo();
        String formNo = randomNo;
        String acType = null;
        if (b1.isSelected()) {
            acType = "Saving Account";
        }
        else if (b2.isSelected()) {
            acType = "Fixed Deposit Account";
        }
        else if (b3.isSelected()) {
            acType = "Current Account";
        }
        else if (b4.isSelected()) {
            acType = "Recurring Deposit Account";
        }
        String userId = userNameField.getText();
        String password = passwordGenerator();

        try {
            if (ae.getSource() == createAc && !c6.isSelected()) {
                JOptionPane.showMessageDialog(null, "Box unchecked..!!! \nCan't create account!");
            }
            else if (ae.getSource() == createAc && !c2.isSelected()) {
                JOptionPane.showMessageDialog(null, "Internet Banking is necessary to open an Account!");
            }
            else if (ae.getSource() == createAc && acType == null) {
                JOptionPane.showMessageDialog(null, "Choose a Account Type!");
            }
            else if (ae.getSource() == createAc && c6.isSelected()) {
                ConnectionSQL csql = new ConnectionSQL();
                String amount = JOptionPane.showInputDialog("Enter Amount To Deposit!");
                if(amount.equals("")) {
                    return ;
                }
                csql.statement.execute("CREATE TABLE IF NOT EXISTS accountdetails (id_no varchar(20) NOT NULL, ac_no varchar(30) NOT NULL, ac_type varchar(30), user_id varchar(30), password varchar(30), upi_id varchar(30), upi_pin varchar(30), amount varchar(30), PRIMARY KEY (id_no, ac_no) );");
                String query = "insert into accountdetails values('"+randomNo+"', '"+accountNo+"', '"+acType+"', '"+userId+"', '"+password+"', null, null,'"+amount+"');";
                csql.statement.executeUpdate(query);
                String transitionId = Deposit.codeGenerator();
                String transitionType = "Cash Deposit";
                String currentDate = Deposit.timeDateGenerator();
                int depositAmount = Integer.parseInt(amount);
                csql.statement.execute("CREATE TABLE IF NOT EXISTS transitions (ac_no varchar(30) NOT NULL, transition_id varchar(30), transition_type varchar(30), date varchar(30), amount varchar(30) );");
                csql.statement.executeUpdate("insert into transitions values('"+accountNo+"', '"+transitionId+"', '"+transitionType+"', '"+currentDate+"', '"+depositAmount+"');");
                
                
                JOptionPane.showMessageDialog(null, "\nAccount Created !!!\n\nUserName : "+userId+"\nPassword : "+password + "\n\n");
                setVisible(false);
                new Login(false).setVisible(true);
            }
   
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String passwordGenerator() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String low = "abcdefghijklmnopqrstuvwxyz";
        String num = "1234567890";
        String special = "!@#$%^&*()-+></?";
        String combination = upper + low + num + special;
        Random r = new Random();
        int passwordLength = 8;
        char password[] = new char[passwordLength];
        for(int i=0; i<passwordLength; i++) {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }
        return new String(password);
    }
}
