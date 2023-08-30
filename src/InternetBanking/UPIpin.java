package InternetBanking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UPIpin extends JFrame implements ActionListener {

    boolean flag = false;
    JLabel cardText, textField;
    JPasswordField passwordField;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;
    // b1 -> login
    // b2 -> clear
    // b3 -> sign up

    UPIpin(boolean f) {
        setTitle("SBI Intenet Banking");
        setLayout(null);
        this.flag = f;

        ImageIcon sbiImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/sbiLogo.png"));
        Image sbiImage = sbiImageIcon.getImage().getScaledInstance(240, 80, Image.SCALE_SMOOTH);
        ImageIcon newSbiImageIcon = new ImageIcon(sbiImage);
        JLabel imageLabel = new JLabel(newSbiImageIcon);
        imageLabel.setBounds(250, 40, 240, 80);
        add(imageLabel);

        cardText = new JLabel("UPI PIN :");
        cardText.setBounds(200, 170, 400, 20);
        cardText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(cardText);

        textField = new JLabel("");
        textField.setBounds(320, 170, 220, 20);
        textField.setFont(new Font("Arial", Font.BOLD, 15));
        add(textField);

        if (!flag) {
            b4 = new JButton("Pay");
            b4.setBounds(300, 370, 200, 40);
            b4.setBackground(Color.WHITE);
            b4.setForeground(Color.GRAY);
            b4.setFont(new Font("Times New Roman", Font.BOLD, 15));
            b4.addActionListener(this);
            add(b4);
        } else if (flag) {
            b13 = new JButton("Set PIN");
            b13.setBounds(300, 370, 200, 40);
            b13.setBackground(Color.WHITE);
            b13.setForeground(Color.GRAY);
            b13.setFont(new Font("Times New Roman", Font.BOLD, 15));
            b13.addActionListener(this);
            add(b13);
        }

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b5 = new JButton("4");
        b6 = new JButton("5");
        b7 = new JButton("6");
        b8 = new JButton("7");
        b9 = new JButton("8");
        b10 = new JButton("9");
        b11 = new JButton("0");
        b12 = new JButton("X");
        b1.setBounds(200, 220, 60, 50);
        b2.setBounds(270, 220, 60, 50);
        b3.setBounds(340, 220, 60, 50);
        b5.setBounds(410, 220, 60, 50);
        b6.setBounds(480, 220, 60, 50);
        b7.setBounds(200, 280, 60, 50);
        b8.setBounds(270, 280, 60, 50);
        b9.setBounds(340, 280, 60, 50);
        b10.setBounds(410, 280, 60, 50);
        b11.setBounds(480, 280, 60, 50);
        b12.setBounds(560, 220, 60, 110);

        b1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b5.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b6.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b7.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b8.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b9.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b10.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b11.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b12.setFont(new Font("Times New Roman", Font.BOLD, 15));
//        b3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b3.setBackground(Color.WHITE);
        b5.setBackground(Color.WHITE);
        b6.setBackground(Color.WHITE);
        b7.setBackground(Color.WHITE);
        b8.setBackground(Color.WHITE);
        b9.setBackground(Color.WHITE);
        b10.setBackground(Color.WHITE);
        b11.setBackground(Color.WHITE);
        b12.setBackground(Color.WHITE);
//        b3.setBackground(Color.WHITE);

        b1.setForeground(Color.GRAY);
        b2.setForeground(Color.GRAY);
        b3.setForeground(Color.GRAY);
        b5.setForeground(Color.GRAY);
        b6.setForeground(Color.GRAY);
        b7.setForeground(Color.GRAY);
        b8.setForeground(Color.GRAY);
        b9.setForeground(Color.GRAY);
        b10.setForeground(Color.GRAY);
        b11.setForeground(Color.GRAY);
        b12.setForeground(Color.GRAY);
//        b13.setForeground(Color.GRAY);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        add(b1);
        add(b2);
        add(b3);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);
        add(b12);

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 480);
        setLocation(550, 200);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (textField.getText().length() < 10) {
            if (ae.getSource() == b1) {
                textField.setText(textField.getText() + "1");
            } else if (ae.getSource() == b2) {
                textField.setText(textField.getText() + "2");
            } else if (ae.getSource() == b3) {
                textField.setText(textField.getText() + "3");
            } else if (ae.getSource() == b5) {
                textField.setText(textField.getText() + "4");
            } else if (ae.getSource() == b6) {
                textField.setText(textField.getText() + "5");
            } else if (ae.getSource() == b7) {
                textField.setText(textField.getText() + "6");
            } else if (ae.getSource() == b8) {
                textField.setText(textField.getText() + "7");
            } else if (ae.getSource() == b9) {
                textField.setText(textField.getText() + "8");
            } else if (ae.getSource() == b10) {
                textField.setText(textField.getText() + "9");
            } else if (ae.getSource() == b11) {
                textField.setText(textField.getText() + "0");
            }
        }

        if (ae.getSource() == b12) {
            if (!textField.getText().isEmpty()) {
                textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            }
        }
    }

}
