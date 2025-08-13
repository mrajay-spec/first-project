import java.util.Scanner;

// Abstract class Bank
abstract class Bank {
    // Abstract method to get customer details
    abstract void customerDetails();
}

// Class Customer extending Bank
class Customer extends Bank {
    String name;
    int accountNumber;
    double balance;

    // Constructor to take details
    Customer(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Implement abstract method
    @Override
    void customerDetails() {
        System.out.println("=== Customer Account Details ===");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

public class abstractmain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();

        System.out.print("Enter Account Balance: ");
        double bal = sc.nextDouble();

        // Create Customer object
        Customer c = new Customer(name, accNum, bal);

        // Show customer details
        c.customerDetails();

        sc.close();
    }
}