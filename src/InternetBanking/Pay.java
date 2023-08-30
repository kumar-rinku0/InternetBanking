package InternetBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Pay extends JFrame implements ActionListener {

    String payType, acNo, accountFormNo, acBalance, accountHolderName, myUpi;
    JTextField acUpiField, nameTextField, amountTextField;
    JButton homeButton, payButton;

    Pay(String str, String type) {
        this.acNo = str;
        this.payType = type;
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
            ResultSet acRs = csql.statement.executeQuery("select * from accountdetails where ac_no = '" + acNo + "'");
            if (acRs.next()) {
                accountFormNo = acRs.getString("id_no");
                acBalance = acRs.getString("amount");
                myUpi = acRs.getString("upi_id");
                
            }
            ResultSet loginRs = csql.statement.executeQuery("select * from signupone where id_no = '" + accountFormNo + "'");
            if (loginRs.next()) {
                accountHolderName = loginRs.getString("name");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        if (payType.charAt(0) == 'a') {

            JLabel baseLabel = new JLabel("Payment Using Account No");
            baseLabel.setBounds(100, 40, 400, 20);
            baseLabel.setForeground(Color.WHITE);
            baseLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            image.add(baseLabel);

            JLabel acountNoLabel = new JLabel("Account No :");
            acountNoLabel.setBounds(100, 100, 200, 20);
            acountNoLabel.setForeground(Color.WHITE);
            acountNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
            image.add(acountNoLabel);
            acUpiField = new JTextField(10);
            acUpiField.setBounds(300, 100, 300, 20);
            acUpiField.setFont(new Font("Times New Roman", Font.BOLD, 17));
            acUpiField.setBorder(null);
            image.add(acUpiField);

            JLabel acountHolderLabel = new JLabel("Account UserName :");
            acountHolderLabel.setBounds(100, 140, 200, 20);
            acountHolderLabel.setForeground(Color.WHITE);
            acountHolderLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
            image.add(acountHolderLabel);
            nameTextField = new JTextField(10);
            nameTextField.setBounds(300, 140, 300, 20);
            nameTextField.setFont(new Font("Times New Roman", Font.BOLD, 17));
            nameTextField.setBorder(null);
            image.add(nameTextField);

            JLabel amountLabel = new JLabel("Payable Amount :");
            amountLabel.setBounds(100, 180, 200, 20);
            amountLabel.setForeground(Color.WHITE);
            amountLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
            image.add(amountLabel);

            amountTextField = new JTextField(10);
            amountTextField.setBounds(300, 180, 300, 20);
            amountTextField.setFont(new Font("Times New Roman", Font.BOLD, 17));
            amountTextField.setBorder(null);
            image.add(amountTextField);

        } else if (payType.charAt(0) == 'u') {

            JLabel baseLabel = new JLabel("Payment Using UPI Id");
            baseLabel.setBounds(100, 40, 400, 20);
            baseLabel.setForeground(Color.WHITE);
            baseLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            image.add(baseLabel);

            JLabel upLabel = new JLabel("UPI Address :");
            upLabel.setBounds(100, 100, 200, 20);
            upLabel.setForeground(Color.WHITE);
            upLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
            image.add(upLabel);
            acUpiField = new JTextField(10);
            acUpiField.setBounds(300, 100, 300, 20);
            acUpiField.setFont(new Font("Times New Roman", Font.BOLD, 17));
            acUpiField.setBorder(null);
            image.add(acUpiField);

            JLabel amountLabel = new JLabel("Payable Amount :");
            amountLabel.setBounds(100, 140, 200, 20);
            amountLabel.setForeground(Color.WHITE);
            amountLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
            image.add(amountLabel);
            amountTextField = new JTextField(10);
            amountTextField.setBounds(300, 140, 300, 20);
            amountTextField.setFont(new Font("Times New Roman", Font.BOLD, 17));
            amountTextField.setBorder(null);
            image.add(amountTextField);

        }

        payButton = new JButton("Make Payment");
        payButton.setBounds(400, 250, 200, 50);
        payButton.setFont(new Font("verdana", Font.BOLD, 18));
        payButton.setBackground(Color.WHITE);
        payButton.setForeground(Color.BLACK);
        payButton.setBorder(null);
        payButton.addActionListener(this);
        image.add(payButton);

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

    @Override
    @SuppressWarnings("Convert2Lambda")
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == homeButton) {
            setVisible(false);
            new MainFrame(acNo).setVisible(true);
        }
        Login log = new Login(true);
        if (ae.getSource() == payButton && !acUpiField.getText().equals("")) {
            String accountNumberOrUpi = acUpiField.getText();
            int amount = Integer.parseInt(amountTextField.getText());
            int leftAmount = Integer.parseInt(acBalance) - amount;
            if (leftAmount < 0) {
                JOptionPane.showMessageDialog(null, "Insufficent Account Balance");
                return;
            }
            String acMoney = leftAmount + "";
            String transitionId = Deposit.codeGenerator();
            String currentDate = Deposit.timeDateGenerator();

            if (payType.charAt(0) == 'a') {
                String accountHolder = nameTextField.getText();
                if(accountHolder == null || accountHolder.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Account Username!");
                    return;
                }
                try {
                    ConnectionSQL csql = new ConnectionSQL();
                    ResultSet rs = csql.statement.executeQuery("select * from accountdetails where ac_no = '" + accountNumberOrUpi + "' and user_id = '" + accountHolder + "'");

                    if (!acNo.equals(accountNumberOrUpi) && rs.next()) {
                        String newAcAmount = rs.getString("amount");
                        setVisible(false);
                        log.setVisible(true);
                        log.actionPerformed(ae);
                        log.b4.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                if (ae.getSource() == log.b4) {

                                    try {
                                        String user = log.textField.getText();
                                        String pass = log.passwordField.getText();
                                        String transitionType = "Online Send";
                                        ResultSet result = csql.statement.executeQuery("select * from accountdetails where ac_no = '" + acNo + "' and password = '" + pass + "'and user_id = '" + user + "';");
                                        if (result.next()) {
                                            
                                            csql.statement.executeUpdate("update accountdetails set amount = '" + acMoney + "' where ac_no = '" + acNo + "'");
                                            csql.statement.executeUpdate("insert into transitions values('" + acNo + "', '" + transitionId + "', '" + transitionType + "', '" + currentDate + "', '" + amount + "');");

                                            int newTotalAmount = Integer.parseInt(newAcAmount) + amount;
                                            String newAcMoney = newTotalAmount + "";
                                            String newTransitionType = "Online Receive";

                                            csql.statement.executeUpdate("update accountdetails set amount = '" + newAcMoney + "' where ac_no = '" + accountNumberOrUpi + "'");
                                            csql.statement.executeUpdate("insert into transitions values('" + accountNumberOrUpi + "', '" + transitionId + "', '" + newTransitionType + "', '" + currentDate + "', '" + amount + "');");

                                            JOptionPane.showMessageDialog(null, "Amount Transfared");

                                            log.setVisible(false);
                                            new MainFrame(acNo).setVisible(true);

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Incorrect UserName or Password");
                                        }

                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                }
                            }
                        });

                    } else {
                        JOptionPane.showMessageDialog(null, "No AccountNo or UserName Exist");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

            } else if (payType.charAt(0) == 'u') {
                UPIpin upi = new UPIpin(false);
                try {
                    ConnectionSQL csql = new ConnectionSQL();
                    ResultSet rs = csql.statement.executeQuery("select * from accountdetails where upi_id = '" + accountNumberOrUpi + "';");

                    if (!myUpi.equals(accountNumberOrUpi) && rs.next()) {
                        String newAcAmount = rs.getString("amount");
                        String accountNumber = rs.getString("ac_no");
                        setVisible(false);
                        upi.setVisible(true);
                        upi.actionPerformed(ae);
                        upi.b4.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                if (ae.getSource() == upi.b4) {

                                    try {
                                        String pin = upi.textField.getText();
                                        String transitionType = "UPI Send";
                                        ResultSet result = csql.statement.executeQuery("select * from accountdetails where ac_no = '" + acNo + "' and upi_pin = '" + pin + "';");
                                        if (result.next()) {
                                            csql.statement.executeUpdate("update accountdetails set amount = '" + acMoney + "' where ac_no = '" + acNo + "'");
                                            csql.statement.executeUpdate("insert into transitions values('" + acNo + "', '" + transitionId + "', '" + transitionType + "', '" + currentDate + "', '" + amount + "');");

                                            int newTotalAmount = Integer.parseInt(newAcAmount) + amount;
                                            String newAcMoney = newTotalAmount + "";
                                            String newTransitionType = "UPI Receive";

                                            csql.statement.executeUpdate("update accountdetails set amount = '" + newAcMoney + "' where ac_no = '" + accountNumber + "'");
                                            csql.statement.executeUpdate("insert into transitions values('" + accountNumber + "', '" + transitionId + "', '" + newTransitionType + "', '" + currentDate + "', '" + amount + "');");

                                            JOptionPane.showMessageDialog(null, "Amount Transfared");

                                            upi.setVisible(false);
                                            new MainFrame(acNo).setVisible(true);

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Incorrect UPI PIN");
                                        }

                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                }
                            }
                        });

                    } else {
                        JOptionPane.showMessageDialog(null, "No UPI Exist!");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
    }
}
