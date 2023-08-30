
package InternetBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class CashWithdrawal extends JFrame implements ActionListener {
    String acNo = null;
    JButton depositButton, homeButton;
    JTextField depositField, usernameField, passwordField;
    CashWithdrawal(String acNo) {
        this.acNo = acNo;
        setTitle("SBI Internet Banking");
        
        ImageIcon backgroundImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/BackGroundImage.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 480, Image.SCALE_SMOOTH);
        ImageIcon newBackgroundImageIcon = new ImageIcon(backgroundImage);
        JLabel image = new JLabel(newBackgroundImageIcon);
        add(image);
        
        JLabel baseLabel = new JLabel("Withdraw Amount in Ac No: " + acNo);
        baseLabel.setBounds(100, 50, 400, 40);
        baseLabel.setForeground(Color.WHITE);
        baseLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        image.add(baseLabel);
        
        
        JLabel depositFieldLabel = new JLabel("Enter amount :");
        depositFieldLabel.setBounds(100, 100, 200, 20);
        depositFieldLabel.setForeground(Color.WHITE);
        depositFieldLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        image.add(depositFieldLabel);
        
        depositField = new JTextField(10);
        depositField.setBounds(350, 100, 300, 20);
        depositField.setFont(new Font("Times New Roman", Font.BOLD, 17));
        depositField.setBorder(null);
        image.add(depositField);
        
        JLabel usernameLabel = new JLabel("Enter last 4 digits of username :");
        usernameLabel.setBounds(100, 140, 300, 20);
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        image.add(usernameLabel);
        
        usernameField = new JTextField(10);
        usernameField.setBounds(350, 140, 300, 20);
        usernameField.setFont(new Font("Times New Roman", Font.BOLD, 17));
        usernameField.setBorder(null);
        image.add(usernameField);
        
        JLabel passwordLabel = new JLabel("Enter password :");
        passwordLabel.setBounds(100, 180, 200, 20);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        image.add(passwordLabel);
        
        passwordField = new JTextField(10);
        passwordField.setBounds(350, 180, 300, 20);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 17));
        passwordField.setBorder(null);
        image.add(passwordField);
        
        depositButton = new JButton("Withdraw");
        depositButton.setBounds(450, 240, 150, 50);
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
                String username = null;
                String password = null;
                ConnectionSQL csql = new ConnectionSQL();
                ResultSet rs = csql.statement.executeQuery("select * from accountdetails where account_no = '"+acNo+"'");
                if(rs.next()) {
                    accountBalance = rs.getString("amount");
                    username = rs.getString("user_name");
                    password = rs.getString("pass_word");
                }
                username = username.substring(username.length()-4);
                
                int prevAcBalance = Integer.parseInt(accountBalance);
                int withdrawalBalance = Integer.parseInt(depositField.getText());
                if(prevAcBalance < withdrawalBalance) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance !");
                    depositField.setText("");
                }
                if(username.equals(usernameField.getText()) && password.equals(passwordField.getText())) {
                    int acBalance = Integer.parseInt(accountBalance) - Integer.parseInt(depositField.getText());
                    String acMoney = acBalance + "";
                    String transitionId = Deposit.codeGenerator();
                    String transitionType = "Cash Withdraw";
                    String currentDate = Deposit.timeDateGenerator();

                    csql.statement.executeUpdate("update accountdetails set amount = '"+acMoney+"' where account_no = '"+acNo+"'");
                    csql.statement.executeUpdate("insert into transitions values('"+acNo+"', '"+transitionId+"', '"+transitionType+"', '"+currentDate+"', '"+withdrawalBalance+"');");
                    JOptionPane.showMessageDialog(null, "amount withdraw successfully !");
                    setVisible(false);
                    new MainFrame(acNo).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password !");
                }
                
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
