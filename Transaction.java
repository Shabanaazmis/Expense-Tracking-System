public class Transaction {

    private int transactionId;
    private String type;
    private String category;
    private double amount;
    private String description;

    // Constructor
    public Transaction(int transactionId, String type,
                       String category, double amount,
                       String description) {

        this.transactionId = transactionId;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    // Getter methods
    public int getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    // Display transaction
    public void displayTransaction() {

        System.out.println("--------------------------------------");
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Type           : " + type);
        System.out.println("Category       : " + category);
        System.out.println("Amount         : ₹" + amount);
        System.out.println("Description    : " + description);
        System.out.println("--------------------------------------");
    }
}