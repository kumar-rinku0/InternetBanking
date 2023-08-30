
package InternetBanking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    boolean flag = false;
    JLabel cardText, pinText;
    JTextField textField;
    JPasswordField passwordField;
    JButton b1, b2, b3, b4;
    // b1 -> login
    // b2 -> clear
    // b3 -> sign up
    
    Login(boolean f) {
        this.flag = f;
        setTitle("SBI Intenet Banking");
        setLayout(null);
        
        ImageIcon sbiImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/sbiLogo.png"));
        Image sbiImage = sbiImageIcon.getImage().getScaledInstance(240, 80, Image.SCALE_SMOOTH);
        ImageIcon newSbiImageIcon = new ImageIcon(sbiImage);
        JLabel imageLabel = new JLabel(newSbiImageIcon);
        imageLabel.setBounds(250, 40, 240, 80);
        add(imageLabel);
        
        cardText = new JLabel("username :");
        cardText.setBounds(200, 170, 400, 20);
        cardText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(cardText);
        
        textField = new JTextField(15);
        textField.setBounds(320, 170, 220, 20);
        textField.setFont(new Font("Arial", Font.BOLD, 15));
        add(textField);
        
        
        pinText = new JLabel("password :");
        pinText.setBounds(200, 220, 400, 20);
        pinText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(pinText);
        
        passwordField = new JPasswordField(15);
        passwordField.setBounds(320, 220, 220, 20);
        passwordField.setFont(new Font("Arial", Font.BOLD, 15));
        add(passwordField);
        
        if(flag) {
            b4 = new JButton("Pay");
            b4.setBounds(300, 280, 200, 40);
            b4.setBackground(Color.WHITE);
            b4.setForeground(Color.GRAY);
            b4.setFont(new Font("Times New Roman", Font.BOLD, 15));
            b4.addActionListener(this);
            add(b4);
        }
        else {
            b1 = new JButton("Login");
            b2 = new JButton("Clear");
            b3 = new JButton("New User! Register");

            b1.setBounds(250, 280, 100, 40);
            b2.setBounds(400, 280, 100, 40);
            b3.setBounds(250, 350, 250, 40);
            b1.setFont(new Font("Times New Roman", Font.BOLD, 15));
            b2.setFont(new Font("Times New Roman", Font.BOLD, 15));
            b3.setFont(new Font("Times New Roman", Font.BOLD, 15));
            b1.setBackground(Color.WHITE);
            b2.setBackground(Color.WHITE);
            b3.setBackground(Color.WHITE);
            b1.setForeground(Color.GRAY);
            b2.setForeground(Color.GRAY);
            b3.setForeground(Color.GRAY);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            add(b1);
            add(b2);
            add(b3);
        }
        
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 480);
        setLocation(550, 200); 
    }
    @Override
    public void actionPerformed(ActionEvent ae ) {
        if(ae.getSource() == b1) {
            ConnectionSQL csql = new ConnectionSQL();
            String username = textField.getText();
            String password = passwordField.getText();
            String query = "select * from accountdetails where user_id = '"+username+"' and password = '"+password+"'";
            try {
                ResultSet rs = csql.statement.executeQuery(query);
                if (rs.next()) {
                    String acNo = rs.getString("ac_no");
                    
                    setVisible(false);
                    new MainFrame(acNo).setVisible(true);
                }
                
                else {
                    
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password!!!");
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b2 ) {
            textField.setText("");
            passwordField.setText("");
        }
        else if(ae.getSource() == b3) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Login(false).setVisible(true); 
    }
}
