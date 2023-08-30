
package InternetBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deposit extends JFrame implements ActionListener {
    String acNo = null;
    JButton depositButton, homeButton;
    JTextField depositField;
    Deposit(String acNo) {
        this.acNo = acNo;
        setTitle("SBI Internet Banking");
        
        ImageIcon backgroundImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/BackGroundImage.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 480, Image.SCALE_SMOOTH);
        ImageIcon newBackgroundImageIcon = new ImageIcon(backgroundImage);
        JLabel image = new JLabel(newBackgroundImageIcon);
        add(image);
        
        JLabel baseLabel = new JLabel("Deposit Amount in Ac No: " + acNo);
        baseLabel.setBounds(100, 50, 400, 40);
        baseLabel.setForeground(Color.WHITE);
        baseLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        image.add(baseLabel);
        
        
        JLabel depositFieldLabel = new JLabel("Enter amount to Deposit :");
        depositFieldLabel.setBounds(100, 140, 200, 20);
        depositFieldLabel.setForeground(Color.WHITE);
        depositFieldLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        image.add(depositFieldLabel);
        
        depositField = new JTextField(10);
        depositField.setBounds(350, 140, 300, 20);
        depositField.setFont(new Font("Times New Roman", Font.BOLD, 17));
        depositField.setBorder(null);
        image.add(depositField);
        
        depositButton = new JButton("Deposit");
        depositButton.setBounds(450, 220, 150, 50);
        depositButton.setFont(new Font("verdana", Font.BOLD, 18));
        depositButton.setBackground(Color.WHITE);
        depositButton.setForeground(Color.BLACK);
        depositButton.setBorder(null);
        depositButton.addActionListener(this);
        image.add(depositButton);
        
        
        homeButton = new JButton("Home");
        homeButton.setBounds(600, 350, 100, 50);
        homeButton.setFont(new Font("verdana", Font.BOLD, 18));
        homeButton.setBackground(Color.WHITE);
        homeButton.setForeground(Color.BLACK);
        homeButton.setBorder(null);
        homeButton.addActionListener(this);
        image.add(homeButton);
        
        setSize(800, 480);
        setLocation(550, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == homeButton) {
            setVisible(false);
            new MainFrame(acNo).setVisible(true);
        }
        try {
            if(ae.getSource() == depositButton && !depositField.getText().equals("")) {
                String accountBalance = null;
                ConnectionSQL csql = new ConnectionSQL();
                ResultSet rs = csql.statement.executeQuery("select * from accountdetails where account_no = '"+acNo+"'");
                if(rs.next()) {
                    accountBalance = rs.getString("amount");
                }
                int amountDeposit = Integer.parseInt(depositField.getText());
                int acBalance = Integer.parseInt(accountBalance) + Integer.parseInt(depositField.getText());
                String acMoney = acBalance + "";
                String transitionId = Deposit.codeGenerator();
                String transitionType = "Cash Deposit";
                String currentDate = Deposit.timeDateGenerator();
                
                csql.statement.executeUpdate("update accountdetails set amount = '"+acMoney+"' where account_no = '"+acNo+"'");
                csql.statement.executeUpdate("insert into transitions values('"+acNo+"', '"+transitionId+"', '"+transitionType+"', '"+currentDate+"', '"+amountDeposit+"');");
                JOptionPane.showMessageDialog(null, "amount deposit successfully !");
                setVisible(false);
                new MainFrame(acNo).setVisible(true);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String codeGenerator() {
        Random r = new Random();
        long longCode = (Math.abs(r.nextLong() % 900000000) + 100000000);
        String code = longCode + "";
        
        return code;
    }
    public static String timeDateGenerator() {
        LocalDateTime DTobj = LocalDateTime.now();
        DateTimeFormatter Fobj = DateTimeFormatter.ofPattern("dd-MMM-yyyy  HH:mm:ss");
        String formatedDate = DTobj.format(Fobj);
        
        return formatedDate;
    }
    
}
