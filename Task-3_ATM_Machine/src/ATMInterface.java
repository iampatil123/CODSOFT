import javax.swing.*;

public class ATMInterface {
    private final JTextField amountField;
    private final JTextArea displayArea;

    public ATMInterface(ATM atm) {
        JFrame frame = new JFrame("ATM Machine");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 30, 100, 30);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(130, 30, 200, 30);
        frame.add(amountField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(30, 80, 100, 30);
        frame.add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(150, 80, 100, 30);
        frame.add(depositButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(270, 80, 130, 30);
        frame.add(checkBalanceButton);

        displayArea = new JTextArea();
        displayArea.setBounds(30, 130, 340, 100);
        displayArea.setEditable(false);
        frame.add(displayArea);

        withdrawButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            atm.withdraw(amount, displayArea);
        });

        depositButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            atm.deposit(amount, displayArea);
        });

        checkBalanceButton.addActionListener(e -> displayArea.setText("Current balance: " + atm.account().getBalance()));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        new ATMInterface(atm);
    }
}
