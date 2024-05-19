public class task3 {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.00); // Initialize with $500 balance
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
