package model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    public User(String name, long ID, String email) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.balances = new ConcurrentHashMap<>(); // using concurrent hashmap to ensure data consistency across multithreaded environment
    }
    private final String name;
    private final long ID;
    private final String email;

    public Map<String, Double> getBalances() {
        return balances;
    }

    public String getEmail() {
        return email;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    private final Map<String, Double> balances;

}
