package InternetBanking;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener {
    int randomNo;
    JLabel formNo, page, name, fname, dob, gender, merital, email, address, city, state, pincode;
    JTextField nameField, fnameField, dobField, emailField, addressField, cityField, stateField, pinField;
    JRadioButton maleButton, femaleButton, marridButton, singleButton;
    ButtonGroup genderGroup, marritalGroup;
    JCheckBox check;
    JButton nextButton, prevButton;
    SignUpOne() {
        setTitle("account stup : personal details");

        ImageIcon sbiImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/sbiRoundLogo.png"));
        Image sbiImage = sbiImageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(sbiImage);
        JLabel imageLabel = new JLabel(newImageIcon);
        imageLabel.setBounds(0, 0, 100, 100);
        add(imageLabel);
        
        
        Random r = new Random();
        randomNo = Math.abs((r.nextInt() % 9000))+1000;
        formNo = new JLabel("Application No. " + randomNo);
        formNo.setBounds(200, 30, 400, 50);
        formNo.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(formNo);

        page = new JLabel("page 1 : personal details");
        page.setBounds(100, 100, 200, 20);
        page.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        add(page);

        name = new JLabel("Name :");
        name.setBounds(100, 150, 200, 20);
        name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(name);

        fname = new JLabel("Father's Name :");
        fname.setBounds(100, 190, 200, 20);
        fname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(fname);

        nameField = new JTextField(10);
        fnameField = new JTextField(10);
        nameField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        fnameField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        nameField.setBounds(250, 150, 200, 20);
        fnameField.setBounds(250, 190, 200, 20);
        add(nameField);
        add(fnameField);

        dob = new JLabel("Date Of Birth :");
        dob.setBounds(100, 230, 200, 20);
        dob.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(dob);
        
        dobField = new JTextField(10);
        dobField.setBounds(250, 230, 200, 20);
        dobField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(dobField);

        gender = new JLabel("Gender :");
        gender.setBounds(100, 270, 200, 20);
        gender.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(gender);
        
        maleButton = new JRadioButton("male");
        maleButton.setBounds(250, 270, 60, 20);
        maleButton.setFont(new Font("Times New Roman", Font.PLAIN,15));
        maleButton.setBackground(Color.WHITE);
        add(maleButton);
        
        femaleButton = new JRadioButton("female");
        femaleButton.setBounds(310, 270, 100, 20);
        femaleButton.setFont(new Font("Times New Roman", Font.PLAIN,15));
        femaleButton.setBackground(Color.WHITE);
        add(femaleButton);
        
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        merital = new JLabel("Meital Status :");
        merital.setBounds(100, 310, 200, 20);
        merital.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(merital);
        
        singleButton = new JRadioButton("single");
        singleButton.setBounds(250, 310, 60, 20);
        singleButton.setFont(new Font("Times New Roman", Font.PLAIN,15));
        singleButton.setBackground(Color.WHITE);
        add(singleButton);
        
        marridButton = new JRadioButton("marrid");
        marridButton.setBounds(310, 310, 100, 20);
        marridButton.setFont(new Font("Times New Roman", Font.PLAIN,15));
        marridButton.setBackground(Color.WHITE);
        add(marridButton);
         
        marritalGroup = new ButtonGroup();
        marritalGroup.add(marridButton);
        marritalGroup.add(singleButton);

        email = new JLabel("E-mail :");
        email.setBounds(100, 350, 200, 20);
        email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(email);
        
        emailField = new JTextField(10);
        emailField.setBounds(250, 350, 200, 20);
        emailField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(emailField);
        
        address = new JLabel("Address :");
        address.setBounds(100, 390, 200, 20);
        address.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(address);
        
        addressField = new JTextField(10);
        addressField.setBounds(250, 390, 200, 20);
        addressField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(addressField);

        city = new JLabel("City :");
        city.setBounds(100, 430, 200, 20);
        city.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(city);
        
        cityField = new JTextField(10);
        cityField.setBounds(250, 430, 200, 20);
        cityField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(cityField);

        state = new JLabel("State :");
        state.setBounds(100, 470, 200, 20);
        state.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(state);
        
        stateField = new JTextField(10);
        stateField.setBounds(250, 470, 200, 20);
        stateField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(stateField);

        pincode = new JLabel("Pin Code :");
        pincode.setBounds(100, 510, 200, 20);
        pincode.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(pincode);
        
        pinField = new JTextField(10);
        pinField.setBounds(250, 510, 200, 20);
        pinField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(pinField);
        
        check = new JCheckBox("i acept that above informition is correct !");
        check.setBounds(100, 550, 400, 20);
        check.setBackground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        prevButton = new JButton("Back");
        prevButton.setBounds(240, 590, 100, 30);
        prevButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        prevButton.setForeground(Color.WHITE);
        prevButton.setBackground(Color.BLACK);
        prevButton.addActionListener(this);
        add(prevButton);
        
        nextButton = new JButton("Next");
        nextButton.setBounds(350, 590, 100, 30);
        nextButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.BLACK);
        nextButton.addActionListener(this);
        add(nextButton);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 700);
        setLocation(650, 200);
        getContentPane().setBackground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == prevButton) {
            setVisible(false);
            new Login(false).setVisible(true);
        }
        
        
        String random = ""+randomNo;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = dobField.getText();
        String gender = null;
        if (maleButton.isSelected()) {
            gender = "male";
        }
        else if (femaleButton.isSelected()) {
            gender = "female";
        }
        String marrital = null;
        if (singleButton.isSelected()) {
            marrital = "single";
        }
        else if (marridButton.isSelected()) {
            marrital = "married";
        }
        String email = emailField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pincode = pinField.getText();
        
        try {
            if(check.isSelected() && name.equals("")) {
                JOptionPane.showMessageDialog(null, "name required!");
            }
            else if (ae.getSource() == nextButton && !check.isSelected()) {
                JOptionPane.showMessageDialog(null, "box unchecked!");
            }
            else if (ae.getSource() == nextButton && check.isSelected()) {
                ConnectionSQL csql = new ConnectionSQL();
                csql.statement.execute("CREATE DATABASE IF NOT EXISTS InternetBanking;");
                csql.statement.execute("USE InternetBanking");
                csql.statement.execute("CREATE TABLE IF NOT EXISTS signupone (id_no VARCHAR(20) NOT NULL, name VARCHAR(30), f_name VARCHAR(30), dob VARCHAR(30), gender VARCHAR(30), marrital VARCHAR(30), email VARCHAR(50), address VARCHAR(50), city VARCHAR(30), state VARCHAR(30), pincode VARCHAR(30), PRIMARY KEY (id_no));");
                String query = "INSERT INTO signupone VALUES ('"+random+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"' , '"+marrital+"' , '"+email+"' , '"+address+"' , '"+city+"' , '"+state+"' , '"+pincode+"' )";
                csql.statement.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(random).setVisible(true);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public static String generateAcNo() {
        Random r = new Random();
        long randomAcNo = Math.abs(r.nextLong() % 999999999) + 100000000;
        String acNo = "3553" + randomAcNo;
        return acNo;
    }

}
