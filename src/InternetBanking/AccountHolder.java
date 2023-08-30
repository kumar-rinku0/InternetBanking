
package InternetBanking;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;


public class AccountHolder extends JFrame implements ActionListener {
    String acNo, accountFormNo, accountHolderName, accountBalance, accountType, accountUsername, accountPassword, currUPI;
    JLabel acNoButton, acTypeButton, usernameButton, passwordButton, upiLabel;
    JButton accountHolder, accountBalanceButton, homeButton, changeUsername, changePassword, changeUPI, createUPI;
    AccountHolder(String acNo) {
        this.acNo = acNo;
        setTitle("SBI Internet Banking");
        
        ImageIcon backgroundImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/BackGroundImage.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 480, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(backgroundImage);
        JLabel image = new JLabel(newImageIcon);
        add(image);
        
        try {
            ConnectionSQL csql = new ConnectionSQL();
            ResultSet acRs = csql.statement.executeQuery("select * from accountdetails where ac_no = '"+ acNo +"'");
            if(acRs.next()) {
                accountFormNo = acRs.getString("id_no");
                accountBalance = acRs.getString("amount");
                accountUsername = acRs.getString("user_id");
                accountPassword = acRs.getString("password");
                accountType = acRs.getString("ac_type");
                currUPI = acRs.getString("upi_id");
            }
            ResultSet loginRs = csql.statement.executeQuery("select * from signupone where id_no = '"+accountFormNo+"'");
            if(loginRs.next()) {
                accountHolderName = loginRs.getString("name");
            }
            
        }
        catch (Exception e) {
            System.out.println(e);
        }
    
        
        accountHolder = new JButton(accountHolderName);
        accountHolder.setBounds(40, 20, 450, 50);
        ImageIcon acHoldeerIcon = new ImageIcon(ClassLoader.getSystemResource("icons/accountHolderIcon.jpg"));
        Image acHolderImage = acHoldeerIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon newAcHolderIcon = new ImageIcon(acHolderImage);
        accountHolder.setIcon(newAcHolderIcon);
        accountHolder.setIconTextGap(20);
        accountHolder.setFont(new Font("Times New Roman", Font.BOLD, 18));
        accountHolder.setBackground(Color.WHITE);
        accountHolder.setForeground(Color.BLACK);
        accountHolder.setBorder(null);
        image.add(accountHolder);
        
        accountBalanceButton = new JButton(accountBalance + ".00 /-");
        accountBalanceButton.setBounds(540, 20, 200, 50);
        accountBalanceButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        accountBalanceButton.setBackground(Color.WHITE);
        accountBalanceButton.setForeground(Color.BLACK);
        accountBalanceButton.setBorder(null);
        image.add(accountBalanceButton);
        
        acNoButton = new JLabel(" Ac No : "+ acNo);
        acNoButton.setBounds(40, 90, 300, 20);
        acNoButton.setFont(new Font("verdana", Font.BOLD, 16));
        //acNoButton.setBackground(Color.WHITE);
        acNoButton.setForeground(Color.WHITE);
        acNoButton.setHorizontalAlignment(10);
        acNoButton.setBorder(null);
        image.add(acNoButton);
        
        acTypeButton = new JLabel(" Ac Type : "+ accountType);
        acTypeButton.setBounds(40, 120, 400, 20);
        acTypeButton.setFont(new Font("verdana", Font.BOLD, 16));
        //acTypeButton.setBackground(Color.WHITE);
        acTypeButton.setForeground(Color.WHITE);
        acTypeButton.setHorizontalAlignment(10);
        acTypeButton.setBorder(null);
        image.add(acTypeButton);
        
        usernameButton = new JLabel(" Username : "+ accountUsername);
        usernameButton.setBounds(40, 150, 300, 20);
        usernameButton.setFont(new Font("verdana", Font.BOLD, 16));
        //usernameButton.setBackground(Color.WHITE);
        usernameButton.setForeground(Color.WHITE);
        usernameButton.setHorizontalAlignment(10);
        usernameButton.setBorder(null);
        image.add(usernameButton);
        
        changeUsername = new JButton("Change username");
        changeUsername.setBounds(140, 180, 200, 40);
        changeUsername.setFont(new Font("verdana", Font.BOLD, 15));
        changeUsername.setBackground(Color.WHITE);
        changeUsername.setForeground(Color.BLACK);
        changeUsername.setBorder(null);
        changeUsername.addActionListener(this);
        image.add(changeUsername);
        
        passwordButton = new JLabel(" Password : "+ accountPassword);
        passwordButton.setBounds(40, 230, 300, 20);
        passwordButton.setFont(new Font("verdana", Font.BOLD, 16));
        //passwordButton.setBackground(Color.WHITE);
        passwordButton.setForeground(Color.WHITE);
        passwordButton.setHorizontalAlignment(10);
        passwordButton.setBorder(null);
        image.add(passwordButton);
        
        changePassword = new JButton("Change password");
        changePassword.setBounds(140, 260, 200, 40);
        changePassword.setFont(new Font("verdana", Font.BOLD, 15));
        changePassword.setBackground(Color.WHITE);
        changePassword.setForeground(Color.BLACK);
        changePassword.setBorder(null);
        changePassword.addActionListener(this);
        image.add(changePassword);
        
        if(currUPI == null) {
            createUPI = new JButton("Create UPI");
            createUPI.setBounds(40, 340, 300, 40);
            createUPI.setFont(new Font("verdana", Font.BOLD, 15));
            createUPI.setBackground(Color.WHITE);
            createUPI.setForeground(Color.BLACK);
            createUPI.setBorder(null);
            createUPI.addActionListener(this);
            image.add(createUPI);
        }
        else {
            upiLabel = new JLabel(" UPI : "+ currUPI);
            upiLabel.setBounds(40, 310, 300, 20);
            upiLabel.setFont(new Font("verdana", Font.BOLD, 16));
            //upiLabel.setBackground(Color.WHITE);
            upiLabel.setForeground(Color.WHITE);
            upiLabel.setHorizontalAlignment(10);
            upiLabel.setBorder(null);
            image.add(upiLabel);

            changeUPI = new JButton("Change UPI");
            changeUPI.setBounds(140, 340, 200, 40);
            changeUPI.setFont(new Font("verdana", Font.BOLD, 15));
            changeUPI.setBackground(Color.WHITE);
            changeUPI.setForeground(Color.BLACK);
            changeUPI.setBorder(null);
            changeUPI.addActionListener(this);
            image.add(changeUPI);
        }
        
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
        if(ae.getSource() == changeUsername) {
            setVisible(false);
            new ChangeUsernamePassword(acNo, "username").setVisible(true);
        }
        if(ae.getSource() == changePassword) {
            setVisible(false);
            new ChangeUsernamePassword(acNo, "password").setVisible(true);
        }
        if(ae.getSource() == changeUPI) {
            setVisible(false);
            new ChangeUsernamePassword(acNo, "UPIchange").setVisible(true);
        }
        else if(ae.getSource() == createUPI) {
            setVisible(false);
            new ChangeUsernamePassword(acNo, "UPIcreate").setVisible(true);
        }
    }
}
