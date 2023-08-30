
package InternetBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainFrame extends JFrame  implements ActionListener {
    JButton checkBalance, deposits, yonoPay, yonoCash, loan, cards, insurance, investments, accountHolder, transitions, acTransfar;
    String acNo, accountFormNo, accountHolderName = "";
    MainFrame(String acNo) {
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
        
        
        
        checkBalance = new JButton("Ac Balance!");
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
        
        deposits = new JButton("Deposit");
        deposits.setBounds(40, 110, 200, 80);
        ImageIcon depositsIcon = new ImageIcon(ClassLoader.getSystemResource("icons/depositsIcon2.png"));
        Image depositsImage = depositsIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon depositsNewIcon = new ImageIcon(depositsImage);
        deposits.setIcon(depositsNewIcon);
        deposits.setFont(new Font("Times New Roman", Font.BOLD, 18));
        deposits.setBackground(Color.WHITE);
        deposits.setForeground(Color.BLACK);
        deposits.setBorder(null);
        deposits.addActionListener(this);
        deposits.setIconTextGap(10);
        
        image.add(deposits);
        
        yonoPay = new JButton("UPI Pay");
        yonoPay.setBounds(290, 210, 200, 80);
        ImageIcon payIcon = new ImageIcon(ClassLoader.getSystemResource("icons/upiLogoIcon.png"));
        Image payImage = payIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon payNewIcon = new ImageIcon(payImage);
        yonoPay.setIcon(payNewIcon);
        yonoPay.setFont(new Font("Times New Roman", Font.BOLD, 18));
        yonoPay.setBackground(Color.WHITE);
        yonoPay.setForeground(Color.BLACK);
        yonoPay.setBorder(null);
//        yonoPay.setVerticalTextPosition(SwingConstants.BOTTOM);
//        yonoPay.setVerticalAlignment(SwingConstants.BOTTOM);
        yonoPay.addActionListener(this);
        yonoPay.setIconTextGap(10);
        
        image.add(yonoPay);
        
        acTransfar = new JButton("Ac Pay");
        acTransfar.setBounds(290, 110, 200, 80);
        ImageIcon bankIcon = new ImageIcon(ClassLoader.getSystemResource("icons/payLogo.jpg"));
        Image bankImage = bankIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon newBankImage = new ImageIcon(bankImage);
        acTransfar.setIcon(newBankImage);
        acTransfar.setFont(new Font("Times New Roman", Font.BOLD, 18));
        acTransfar.setBackground(Color.WHITE);
        acTransfar.setForeground(Color.BLACK);
        acTransfar.setBorder(null);
        acTransfar.addActionListener(this);
        acTransfar.setIconTextGap(10);
        
        image.add(acTransfar);
        
        yonoCash = new JButton("Cash");
        yonoCash.setBounds(540, 110, 200, 80);
        ImageIcon cashIcon = new ImageIcon(ClassLoader.getSystemResource("icons/cashIcon.png"));
        Image cashImage= cashIcon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon newCashIcon = new ImageIcon(cashImage);
        yonoCash.setIcon(newCashIcon);
        yonoCash.setForeground(Color.BLACK);
        yonoCash.setBackground(new Color(255, 255, 255));
        yonoCash.setFont(new Font("Times New Roman", Font.BOLD, 18));
        yonoCash.setBorder(null);
        yonoCash.addActionListener(this);
        yonoCash.setIconTextGap(10);
        
        image.add(yonoCash);
        
        
        
        loan = new JButton("Loan");
        loan.setBounds(40, 210, 200, 80);
        ImageIcon loanIcon = new ImageIcon(ClassLoader.getSystemResource("icons/LoanIconPersonal.png"));
        Image loanImage = loanIcon.getImage().getScaledInstance(60,60, Image.SCALE_SMOOTH);
        ImageIcon loanNewIcon = new ImageIcon(loanImage);
        loan.setIcon(loanNewIcon);
        loan.setFont(new Font("Times New Roman", Font.BOLD, 18));
        loan.setBackground(Color.WHITE);
        loan.setForeground(Color.BLACK);
        loan.setBorder(null);
        loan.setIconTextGap(15);
        
        image.add(loan);
        
        
        cards = new JButton("Cards");
        cards.setBounds(290, 310, 200, 80);
        ImageIcon cardIcon = new ImageIcon(ClassLoader.getSystemResource("icons/cardIcon.jpg"));
        Image cardImage = cardIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon cardNewIcon = new ImageIcon(cardImage);
        cards.setIcon(cardNewIcon);
        cards.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cards.setBackground(Color.WHITE);
        cards.setForeground(Color.BLACK);
        cards.setBorder(null);
        cards.setIconTextGap(10);
        
        image.add(cards);
        
        insurance = new JButton("Insurance");
        insurance.setBounds(540, 210, 200,80);
        ImageIcon insuranceIcon = new ImageIcon(ClassLoader.getSystemResource("icons/insuranceIcon.jpg"));
        Image insuranceImage = insuranceIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon insuranceNewIcon = new ImageIcon(insuranceImage);
        insurance.setIcon(insuranceNewIcon);
        insurance.setFont(new Font("Times New Roman", Font.BOLD, 18));
        insurance.setBackground(Color.WHITE);
        insurance.setForeground(Color.BLACK);
        insurance.setBorder(null);
        insurance.setIconTextGap(10);
        
        image.add(insurance);
        
        investments = new JButton("Investments");
        investments.setBounds(40, 310, 200, 80);
        ImageIcon investmentIcon = new ImageIcon(ClassLoader.getSystemResource("icons/savingMoney.png"));
        Image investmentImage = investmentIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon investmentNewIcon = new ImageIcon(investmentImage);
        investments.setIcon(investmentNewIcon);
        investments.setFont(new Font("Times New Roman", Font.BOLD, 18));
        investments.setBackground(Color.WHITE);
        investments.setForeground(Color.BLACK);
        investments.setBorder(null);
        investments.setIconTextGap(10);
        
        image.add(investments);
        
        transitions = new JButton("Transitions");
        transitions.setBounds(540, 310, 200, 80);
        ImageIcon trasitionIcon = new ImageIcon(ClassLoader.getSystemResource("icons/transitionIcon.jpg"));
        Image transitionImage = trasitionIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon transitionNewIcon = new ImageIcon(transitionImage);
        transitions.setIcon(transitionNewIcon);
        transitions.setFont(new Font("Times New Roman", Font.BOLD, 18));
        transitions.setBackground(Color.WHITE);
        transitions.setForeground(Color.BLACK);
        transitions.setBorder(null);
        transitions.setIconTextGap(10);
        transitions.addActionListener(this);
        
        image.add(transitions);
        
        setSize(800, 480);
        setLocation(550, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String amt = "0";
        ConnectionSQL csql = new ConnectionSQL();
        String query = "select * from accountdetails where ac_no = '"+acNo+"'";
        try {
            ResultSet rs = csql.statement.executeQuery(query);
            if(rs.next()) {
                amt = rs.getString("amount");
            }
            
        }
        catch (Exception e) {
            System.out.println(e);
        }
        if(ae.getSource() == checkBalance) {
            checkBalance.setText(amt+".00 /-");
        }
        if(ae.getSource() == accountHolder) {
            setVisible(false);
            new AccountHolder(acNo).setVisible(true);
            
        }
        if(ae.getSource() == deposits) {
            setVisible(false);
            new Deposit(acNo).setVisible(true);
        }
        if(ae.getSource() == yonoCash) {
            setVisible(false);
            new CashWithdrawal(acNo).setVisible(true);
        }
        if(ae.getSource() == transitions) {
            setVisible(false);
            new Transitions(acNo).setVisible(true);
        }
        if(ae.getSource() == yonoPay) {
            setVisible(false);
            new Pay(acNo, "upi").setVisible(true);
        }
        if(ae.getSource() == acTransfar) {
            setVisible(false);
            new Pay(acNo, "ac").setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new MainFrame("3553106366983").setVisible(true);
    }
}
