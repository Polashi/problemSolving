package model;

import splitType.Split;

import java.util.List;

public class Expense {
    private final long ID;
    private final User paidBy;
    private final String description;
    private final double amount;
    private final List<Split> splitList;

    public Expense(long ID, User paidBy, String description, double amount, List<Split> splitList) {
        this.ID = ID;
        this.paidBy = paidBy;
        this.description = description;
        this.amount = amount;
        this.splitList = splitList;
    }
}
