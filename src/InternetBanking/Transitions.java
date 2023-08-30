
package InternetBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Transitions extends JFrame  implements ActionListener {
    JButton homeButton, accountHolder, checkBalance;
    String acNo, accountFormNo, accountHolderName = "", acBalance;
    JLabel title, statements;
    Transitions(String acNo) {
        this.acNo = acNo;
        setTitle("SBI Internet Banking");
        setLayout(null);
        
        ImageIcon sbiBackgroundImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/BackGroundImage.jpg"));
        Image sbiImage = sbiBackgroundImageIcon.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT);
        ImageIcon sbiImageIcon = new ImageIcon(sbiImage);
        JLabel image = new JLabel(sbiImageIcon);
        image.setBounds(0, 0, 800, 480);
        add(image);
        try {
            ConnectionSQL csql = new ConnectionSQL();
            ResultSet acRs = csql.statement.executeQuery("select * from accountdetails where ac_no = '"+ acNo +"'");
            if(acRs.next()) {
                accountFormNo = acRs.getString("id_no");
                acBalance = acRs.getString("amount");
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
        accountHolder.addActionListener(this);
        image.add(accountHolder);
        
        checkBalance = new JButton("Curr Ac Balance!");
        checkBalance.setBounds(540, 20, 200, 50);
//        ImageIcon moneyIcon = new ImageIcon(ClassLoader.getSystemResource("icons/.jpg"));
//        Image moneyImage = moneyIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//        ImageIcon newMoneyIcon = new ImageIcon(moneyImage);
//        checkBalance.setIcon(newMoneyIcon);
//        checkBalance.setIconTextGap(20);
        checkBalance.setFont(new Font("Times New Roman", Font.BOLD, 18));
        checkBalance.setBackground(Color.WHITE);
        checkBalance.setForeground(Color.BLACK);
        checkBalance.setBorder(null);
        checkBalance.addActionListener(this);
        image.add(checkBalance);
        
        title = new JLabel("Recent Transitions");
        title.setBounds(40, 100, 200, 20);
        title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        image.add(title);
        
        statements = new JLabel();
        statements.setBounds(40, 140, 600, 280);
        statements.setFont(new Font("Times New Roman", Font.BOLD, 15));
        statements.setForeground(Color.WHITE);
        statements.setVerticalAlignment(SwingConstants.TOP);
//        statements.addMouseWheelListener(this);
        image.add(statements);
        
      
        try {
            ConnectionSQL csql = new ConnectionSQL();
            ResultSet trT = csql.statement.executeQuery("select * from transitions where ac_no = '"+ acNo +"'");
            while(trT.next()) {
                statements.setText("<html>"+trT.getString("transition_id")+"&nbsp; &nbsp;"+trT.getString("transition_type")+ "&nbsp; &nbsp;" +trT.getString("date")+ "&nbsp; &nbsp;" +trT.getInt("amount")+"<br><br><html>" + statements.getText());
            }
            
        }
        catch(Exception e) {
            System.out.println(e);
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
        if(ae.getSource() == accountHolder) {
            setVisible(false);
            new AccountHolder(acNo).setVisible(true);
        }
        if(ae.getSource() == checkBalance) {
            checkBalance.setText(acBalance+".00 /-");
        }
    }
    
}
