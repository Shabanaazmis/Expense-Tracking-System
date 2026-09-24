import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static ArrayList<Transaction> transactions =
            new ArrayList<>();

    static int transactionId = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("          EXPENSE TRACKER");
            System.out.println("======================================");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Show Summary");
            System.out.println("5. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addIncome(sc);
                    break;

                case 2:
                    addExpense(sc);
                    break;

                case 3:
                    viewTransactions();
                    break;

                case 4:
                    showSummary();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using Expense Tracker!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }

        } while (choice != 5);

        sc.close();
    }

    // Add Income
    static void addIncome(Scanner sc) {

        sc.nextLine();

        System.out.println("\n----- Add Income -----");

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        if (amount <= 0) {

            System.out.println("Amount must be greater than zero.");
            return;
        }

        Transaction transaction = new Transaction(
                transactionId++,
                "Income",
                category,
                amount,
                description
        );

        transactions.add(transaction);

        System.out.println("Income added successfully!");
    }

    // Add Expense
    static void addExpense(Scanner sc) {

        sc.nextLine();

        System.out.println("\n----- Add Expense -----");

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        if (amount <= 0) {

            System.out.println("Amount must be greater than zero.");
            return;
        }

        Transaction transaction = new Transaction(
                transactionId++,
                "Expense",
                category,
                amount,
                description
        );

        transactions.add(transaction);

        System.out.println("Expense added successfully!");
    }

    // View Transactions
    static void viewTransactions() {

        System.out.println("\n========== TRANSACTIONS ==========");

        if (transactions.isEmpty()) {

            System.out.println("No transactions available.");

        } else {

            for (Transaction transaction : transactions) {
                transaction.displayTransaction();
            }
        }
    }

    // Show Summary
    static void showSummary() {

        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction transaction : transactions) {

            if (transaction.getType().equals("Income")) {

                totalIncome =
                        totalIncome + transaction.getAmount();

            } else if (transaction.getType().equals("Expense")) {

                totalExpense =
                        totalExpense + transaction.getAmount();
            }
        }

        double balance = totalIncome - totalExpense;

        System.out.println("\n========== FINANCIAL SUMMARY ==========");
        System.out.println("Total Income  : ₹" + totalIncome);
        System.out.println("Total Expense : ₹" + totalExpense);
        System.out.println("Balance       : ₹" + balance);
        System.out.println("=======================================");
    }
}