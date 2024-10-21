package model;

public class Transaction {
    private final long ID;
    private final User sender;
    private final User receiver;
    private final double amount;

    public Transaction(long ID, User sender, User receiver, double amount) {
        this.ID = ID;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

}
