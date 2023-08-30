package InternetBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {
    String formNo;
    JLabel applicationNo, page, existAc, categoryL, religionL, literateL, occupationL, anualIncomL, aadharL, panL, mobnoL, citizenL;
    JTextField  religonField, anulalIcomeField, aadharIdField, panIdField, mobNoField, occupationField;
    JRadioButton literateYesButton, literateNoButton, stButton, scButton, obcButton, generalButton, yesButton, noButton, yesNatinal, noNatinal;
    ButtonGroup literateGroup, categoryGroup, accountGroup, nationalityGroup;
    JButton NextButton;
    
    SignUpTwo(String str) {
        setTitle("account stup : additional details");

        
        ImageIcon sbiImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/sbiRoundLogo.png"));
        Image sbiImage = sbiImageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(sbiImage);
        JLabel imageLabel = new JLabel(newImageIcon);
        imageLabel.setBounds(0, 0, 100, 100);
        add(imageLabel);
        
        this.formNo = str;
        applicationNo = new JLabel("Application No. " + formNo);
        applicationNo.setBounds(200, 30, 400, 50);
        applicationNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(applicationNo);

        page = new JLabel("page 2 : additional details");
        page.setBounds(100, 100, 200, 20);
        page.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        add(page);

        existAc = new JLabel("Exsting Account :");
        existAc.setBounds(100, 150, 200, 20);
        existAc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(existAc);
        
        yesButton = new JRadioButton("yes");
        yesButton.setBackground(Color.WHITE);
        yesButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        yesButton.setBounds(250, 150, 50, 20);
        add(yesButton);
        
        noButton = new JRadioButton("no");
        noButton.setBackground(Color.WHITE);
        noButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        noButton.setBounds(300, 150, 50, 20);
        add(noButton);
        
        accountGroup = new ButtonGroup();
        accountGroup.add(yesButton);
        accountGroup.add(noButton);

        categoryL = new JLabel("Category :");
        categoryL.setBounds(100, 190, 200, 20);
        categoryL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(categoryL);

        
        stButton = new JRadioButton("st");
        stButton.setBackground(Color.WHITE);
        stButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        stButton.setBounds(250, 190, 40, 20);
        add(stButton);
        
        scButton = new JRadioButton("sc");
        scButton.setBackground(Color.WHITE);
        scButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        scButton.setBounds(290, 190, 40, 20);
        add(scButton);
        
        obcButton = new JRadioButton("obc");
        obcButton.setBackground(Color.WHITE);
        obcButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        obcButton.setBounds(330, 190, 50, 20);
        add(obcButton);
        
        generalButton = new JRadioButton("general");
        generalButton.setBackground(Color.WHITE);
        generalButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        generalButton.setBounds(380, 190, 100, 20);
        add(generalButton);
        
        categoryGroup = new ButtonGroup();
        categoryGroup.add(stButton);
        categoryGroup.add(scButton);
        categoryGroup.add(obcButton);
        categoryGroup.add(generalButton);
        

        religionL = new JLabel("Religion :");
        religionL.setBounds(100, 230, 200, 20);
        religionL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(religionL);
        
        religonField = new JTextField(10);
        religonField.setBounds(250, 230, 200, 20);
        religonField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(religonField);

        literateL = new JLabel("literate ?");
        literateL.setBounds(100, 270, 200, 20);
        literateL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(literateL);
        
        literateYesButton = new JRadioButton("yes");
        literateYesButton.setBounds(250, 270, 50, 20);
        literateYesButton.setFont(new Font("Times New Roman", Font.PLAIN,15));
        literateYesButton.setBackground(Color.WHITE);
        add(literateYesButton);
        
        literateNoButton = new JRadioButton("no");
        literateNoButton.setBounds(300, 270, 50, 20);
        literateNoButton.setFont(new Font("Times New Roman", Font.PLAIN,15));
        literateNoButton.setBackground(Color.WHITE);
        add(literateNoButton);
        
        literateGroup = new ButtonGroup();
        literateGroup.add(literateYesButton);
        literateGroup.add(literateNoButton);

        occupationL = new JLabel("Occupation :");
        occupationL.setBounds(100, 310, 200, 20);
        occupationL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(occupationL);
        
        
        occupationField = new JTextField(10);
        occupationField.setBounds(250, 310, 200, 20);
        occupationField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(occupationField);
        
        anualIncomL = new JLabel("Anual Income :");
        anualIncomL.setBounds(100, 350, 200, 20);
        anualIncomL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(anualIncomL);
        
        anulalIcomeField = new JTextField(10);
        anulalIcomeField.setBounds(250, 350, 200, 20);
        anulalIcomeField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(anulalIcomeField);
        
        aadharL = new JLabel("Aadhar Id :");
        aadharL.setBounds(100, 390, 200, 20);
        aadharL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(aadharL);
        
        aadharIdField = new JTextField(10);
        aadharIdField.setBounds(250, 390, 200, 20);
        aadharIdField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(aadharIdField);

        panL = new JLabel("PAN Id :");
        panL.setBounds(100, 430, 200, 20);
        panL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(panL);
        
        panIdField = new JTextField(10);
        panIdField.setBounds(250, 430, 200, 20);
        panIdField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(panIdField);

        mobnoL = new JLabel("Mob No. :");
        mobnoL.setBounds(100, 470, 200, 20);
        mobnoL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(mobnoL);
        
        mobNoField = new JTextField(10);
        mobNoField.setBounds(250, 470, 200, 20);
        mobNoField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(mobNoField);

        citizenL = new JLabel("Are you indian citizen ?");
        citizenL.setBounds(100, 510, 200, 20);
        citizenL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(citizenL);
        
        yesNatinal = new JRadioButton("yes");
        yesNatinal.setBounds(250, 510, 50, 20);
        yesNatinal.setFont(new Font("Times New Roman", Font.PLAIN,15));
        yesNatinal.setBackground(Color.WHITE);
        add(yesNatinal);
        
        noNatinal = new JRadioButton("no");
        noNatinal.setBounds(300, 510, 50, 20);
        noNatinal.setFont(new Font("Times New Roman", Font.PLAIN,15));
        noNatinal.setBackground(Color.WHITE);
        add(noNatinal);
        
        nationalityGroup = new ButtonGroup();
        nationalityGroup.add(yesNatinal);
        nationalityGroup.add(noNatinal);
        
        
        NextButton = new JButton("Next");
        NextButton.setBounds(350, 590, 100, 30);
        NextButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        NextButton.setForeground(Color.WHITE);
        NextButton.setBackground(Color.BLACK);
        NextButton.addActionListener(this);
        add(NextButton);

        setLayout(null);
        setSize(600, 700);
        setLocation(650, 200);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String acExist = null;
        if (yesButton.isSelected()) {
            acExist = "yes";
        }
        else if (noButton.isSelected()) {
            acExist = "no";
        }
        String category = null;
        if (stButton.isSelected()) {
            category = "st";
        }
        else if (scButton.isSelected()) {
            category = "sc";
        }
        else if (obcButton.isSelected()) {
            category = "obc";
        }
        else if (generalButton.isSelected()) {
            category = "general";
        }
        String religon = religonField.getText();
        String literate = null;
        if (literateYesButton.isSelected()) {
            literate = "yes";
        }
        else if (literateNoButton.isSelected()) {
            literate = "no";
        }
        
        String anualIncome = anulalIcomeField.getText();
        String aadharId = aadharIdField.getText();
        String panId = panIdField.getText();
        String mobNo = mobNoField.getText();
        String indian = null;
        if (yesNatinal.isSelected()) {
            indian = "yes";
        }
        else if (noNatinal.isSelected()) {
            indian = "no";
        }
        
        try {
            
            if (ae.getSource() == NextButton ) {
                ConnectionSQL csql = new ConnectionSQL();
                csql.statement.execute("CREATE TABLE IF NOT EXISTS signuptwo( id_no varchar(10) NOT NULL, category varchar(20) , religon varchar(30) , literate varchar(30) , anualIncome varchar(30), aadharId varchar(30) , panId varchar(30) ,mobNo varchar(20), indian varchar(20), PRIMARY KEY (id_no));");
                String query = "insert into signuptwo values('"+formNo+"', '"+ category +"' , '"+religon+"' , '"+literate+"' , '"+anualIncome+"' , '"+aadharId+"' , '"+panId+"' ,'"+mobNo+"', '"+indian+"' )";
                
                csql.statement.executeUpdate(query);
                setVisible(false);
                new SignUpTree(formNo).setVisible(true);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
    }

}
