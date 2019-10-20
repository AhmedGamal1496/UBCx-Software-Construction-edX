package model;

import java.util.ArrayList;
import java.util.List;

public class TransactionSummary {

    private String name;
    private List<Transaction> transactions;

    public TransactionSummary(String name) {
        // TODO: complete the implementation of this method
        this.name = name;
        transactions = new ArrayList<>();
    }

    // getters
    public String getName() {
        // TODO: complete the implementation of this method
        return name;
    }
    public List<Transaction> getTransactions() {
        // TODO: complete the implementation of this method
        return transactions;
    }
    public int getNumTransactions() {
        // TODO: complete the implementation of this method
        return transactions.size();
    }

    // REQUIRES: t is not already within transactions
    // MODIFIES: this
    // EFFECTS: adds the given transaction t to the list of transactions
    public void addTransaction(Transaction t) {
        // TODO: complete the implementation of this method
        transactions.add(t);
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: computes the average amount of money spent on a transaction
    public double averageTransactionCost() {
        // TODO: complete the implementation of this method
        int totalAmount = 0;
        for (Transaction t : transactions) {
            totalAmount += t.getAmount();
        }

        return totalAmount/transactions.size();
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS:  returns the average cost of all transactions of type specificType in this
    //           TransactionSummary
    public double specificTypeAverage(TransactionType specificType) {
        // TODO: complete the implementation of this method
        int totalAmount = 0;
        int typeSize = 0;

        for (Transaction t : transactions) {
            if (t.getType().equals(specificType)) {
                totalAmount += t.getAmount();
                typeSize++;
            }
        }

        return totalAmount/typeSize;
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: returns the largest transaction (in terms of cost) in this TransactionSummary
    public Transaction largestTransaction() {
        // TODO: complete the implementation of this method
        int max = 0;
        Transaction largestTransaction = transactions.get(0);

        for (Transaction t : transactions) {
            if (t.getAmount() > max) {
                max = t.getAmount();
                largestTransaction = t;
            }
        }

        return largestTransaction;
    }

    // EFFECTS: returns true if the given transaction is contained within the list of transactions
    public boolean contains(Transaction t) {
        // TODO: complete the implementation of this method
        return transactions.contains(t);
    }


}
