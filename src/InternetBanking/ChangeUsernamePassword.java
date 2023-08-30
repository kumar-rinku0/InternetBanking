package InternetBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangeUsernamePassword extends JFrame implements ActionListener {

    String acNo, changeType;
    JButton homeButton, backButton, updateButton;
    JLabel baseLabel, firstLabel, secondLabel;
    JTextField firstField, secondField;

    ChangeUsernamePassword(String acNo, String newString) {
        this.acNo = acNo;
        this.changeType = newString;
        setTitle("SBI Internet Banking");

        ImageIcon backgroundImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/BackGroundImage.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 480, Image.SCALE_SMOOTH);
        ImageIcon newBackgroundImageIcon = new ImageIcon(backgroundImage);
        JLabel image = new JLabel(newBackgroundImageIcon);
        add(image);

        String str = "change";
        if (changeType.contains("UPI")) {
            str = changeType.substring(3);
            changeType = changeType.substring(0, 3);
        }
        baseLabel = new JLabel("To " + str + " " + changeType);
        baseLabel.setBounds(100, 50, 200, 40);
        baseLabel.setForeground(Color.WHITE);
        baseLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        image.add(baseLabel);

        firstLabel = new JLabel("Enter " + changeType);
        firstLabel.setBounds(100, 120, 200, 20);
        firstLabel.setForeground(Color.WHITE);
        firstLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        image.add(firstLabel);

        firstField = new JTextField(10);
        firstField.setBounds(300, 120, 200, 20);
        firstField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        firstField.setBorder(null);
        image.add(firstField);

        secondLabel = new JLabel("Re-Enter " + changeType);
        secondLabel.setBounds(100, 160, 200, 20);
        secondLabel.setForeground(Color.WHITE);
        secondLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        image.add(secondLabel);

        secondField = new JTextField(10);
        secondField.setBounds(300, 160, 200, 20);
        secondField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        secondField.setBorder(null);
        image.add(secondField);

        updateButton = new JButton("Update");
        updateButton.setBounds(400, 220, 100, 50);
        updateButton.setFont(new Font("vardana", Font.BOLD, 18));
        updateButton.setBackground(Color.WHITE);
        updateButton.setForeground(Color.BLACK);
        updateButton.setBorder(null);
        updateButton.addActionListener(this);
        image.add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(600, 290, 100, 50);
        backButton.setFont(new Font("vardana", Font.BOLD, 18));
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.setBorder(null);
        backButton.addActionListener(this);
        image.add(backButton);

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
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String firstData = firstField.getText();
        String secondData = secondField.getText();
        if (ae.getSource() == homeButton) {
            setVisible(false);
            new MainFrame(acNo).setVisible(true);
        }
        if (ae.getSource() == backButton) {
            setVisible(false);
            new AccountHolder(acNo).setVisible(true);
        }
        if (ae.getSource() == updateButton && !firstData.equals(secondData)) {
            JOptionPane.showMessageDialog(null, changeType + " doesn't mathced !");
        } else if (ae.getSource() == updateButton && (firstData.equals("") || secondData.equals(""))) {
            JOptionPane.showMessageDialog(null, changeType + " field empty !");
        } else if (ae.getSource() == updateButton && firstData.equals(secondData)) {
            try {
                String username = null, password = null;
                ConnectionSQL csql = new ConnectionSQL();
                ResultSet rs = csql.statement.executeQuery("select * from accountdetails where ac_no = '" + acNo + "'");
                if (rs.next()) {
                    username = rs.getString("user_id");
                    password = rs.getString("password");
                }

                if (changeType.charAt(0) == 'u' && changeType.charAt(1) == 's') {
                    csql.statement.executeUpdate("update accountdetails set user_id = '" + firstData + "' where ac_no = '" + acNo + "'");
                    JOptionPane.showMessageDialog(null, changeType + " changed !");
                    setVisible(false);
                    new AccountHolder(acNo).setVisible(true);

                }
                if (changeType.contains("UPI") && firstData.contains("@oksbi")) {
                    csql.statement.executeUpdate("update accountdetails set upi_id = '" + firstData + "' where ac_no = '" + acNo + "'");
                    setVisible(false);
                    UPIpin upi = new UPIpin(true);
                    upi.setVisible(true);
                    upi.b13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if (ae.getSource() == upi.b13) {
                                try {
                                    if (upi.textField.getText().length() == 6) {
                                        String str = upi.textField.getText();
                                        int pin = Integer.parseInt(str);
                                        csql.statement.executeUpdate("update accountdetails set upi_pin = '" + pin + "' where ac_no = '" + acNo + "'");
                                        JOptionPane.showMessageDialog(null, "UPI PIN Set !");
                                        upi.setVisible(false);
                                        new AccountHolder(acNo).setVisible(true);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Enter 6 Digits Only!");
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                        }
                    });

                } else if (changeType.contains("UPI") && !firstData.contains("@oksbi")) {
                    JOptionPane.showMessageDialog(null, "UPI should contain @oksbi");
                }
                if (changeType.contains("password")) {
                    csql.statement.executeUpdate("update accountdetails set password = '" + firstData + "' where ac_no = '" + acNo + "'");
                    JOptionPane.showMessageDialog(null, changeType + " changed !");
                    setVisible(false);
                    new AccountHolder(acNo).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
