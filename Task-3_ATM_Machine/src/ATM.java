import javax.swing.JTextArea;

public record ATM(BankAccount account) {

    public void withdraw(double amount, JTextArea displayArea) {
        if (amount <= 0) {
            displayArea.setText("Amount must be greater than zero.");
        } else if (amount > account.getBalance()) {
            displayArea.setText("Insufficient balance.");
        } else {
            account.withdraw(amount);
            displayArea.setText("Withdrawal successful. New balance: " + account.getBalance());
        }
    }

    public void deposit(double amount, JTextArea displayArea) {
        if (amount <= 0) {
            displayArea.setText("Amount must be greater than zero.");
        } else {
            account.deposit(amount);
            displayArea.setText("Deposit successful. New balance: " + account.getBalance());
        }
    }
}
