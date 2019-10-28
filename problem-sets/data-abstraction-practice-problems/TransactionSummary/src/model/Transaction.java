package model;

public class Transaction {

    private String name;
    private String date;
    private int amount;
    private TransactionType type;

    public Transaction(String name, String date, int amount, TransactionType type) {
       // TODO: complete the implementation of this method
        this.name= name;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    // getters
    public String getName() {
        // TODO: complete the implementation of this method
        return name;
    }
    public String getDate() {
        // TODO: complete the implementation of this method
        return date;
    }
    public int getAmount() {
        // TODO: complete the implementation of this method
        return amount;
    }
    public TransactionType getType() {
        // TODO: complete the implementation of this method
        return type;
    }


}
