import java.util.Scanner;

class ATM {
    private double balance;
    private final int PIN = 1234;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean login(int enteredPin) {
        return enteredPin == PIN;
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs." + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rs." + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(5000.0); // Initial balance

        System.out.print("Enter your PIN: ");
        int pin = sc.nextInt();

        if (atm.login(pin)) {
            int choice;
            do {
                System.out.println("\n---- ATM Menu ----");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: Rs.");
                        double deposit = sc.nextDouble();
                        atm.deposit(deposit);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: Rs.");
                        double withdraw = sc.nextDouble();
                        atm.withdraw(withdraw);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            } while (choice != 4);
        } else {
            System.out.println("Incorrect PIN. Access Denied!");
        }

        sc.close();
    }
}
