package com.example.connection;

import java.util.HashMap;
import java.util.Map;

public class SingletoneSession {

    private static SingletoneSession instance;
    private String username;
    private String password;
    private static Map<String,String> users = new HashMap<>();

    private SingletoneSession() {}

    public static SingletoneSession Instance()
    {
        if (instance == null)
        {
            instance = new SingletoneSession();
        }
        return instance;
    }

    public Map<String, String> getUser() {
        return users;
    }

    public void setUser(String login,String pass) {
        users.put(login,pass);
    }
}
