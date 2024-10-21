import model.Expense;
import model.Group;
import model.User;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SplitwiseService {
    private static SplitwiseService instance;
    private final Map<String, User> userMap;
    private final Map<String, Group> groupMap;

    private SplitwiseService(){
        userMap = new ConcurrentHashMap<>();
        groupMap = new ConcurrentHashMap<>();
    }

    public synchronized static SplitwiseService getInstance(){
        if(instance == null){
            return new SplitwiseService();
        }
        return instance;
    }

    public void addUser(User user){
        userMap.put(user.getID(), user);
    }

    public void addGroup(Group group){
        groupMap.put(group.getID(), group);
    }

    public void addExpense(String groupId, Expense expense){
        Group group = groupMap.get(groupId);
        if(group != null){
            group.addExpense(expense);
            splitExpense(expense);
            updateBalances(expense);
        }
    }

    private void splitExpense(Expense expense) {
    }

    private void updateBalances(Expense expense){

    }
}
