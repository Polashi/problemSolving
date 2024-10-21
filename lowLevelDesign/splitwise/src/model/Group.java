package model;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Group {
    private final String  ID;
    private final String name;
    private final List<User> memberList;
    private final List<Expense> expenseList;

    public Group(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.memberList = new CopyOnWriteArrayList<>();
        this.expenseList = new CopyOnWriteArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public List<User> getUserList() {
        return memberList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void addExpense(Expense expense){

    }
}
