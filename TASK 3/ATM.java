import java.util.Scanner;

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // Display the ATM menu and handle user input
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw(scanner);
                    break;
                case 2:
                    handleDeposit(scanner);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    // Handle withdraw operation
    private void handleWithdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        withdraw(amount);
    }

    // Handle deposit operation
    private void handleDeposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        deposit(amount);
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && account.getBalance() >= amount) {
            account.withdraw(amount);
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    // Check the account balance
    public void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }
}
