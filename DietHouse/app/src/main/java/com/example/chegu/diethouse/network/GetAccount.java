package com.example.chegu.diethouse.network;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chegu on 20/11/16.
 */
public class GetAccount {
    private String email;
    private String password;
    private String userName;

    private static GetAccount ourInstance = new GetAccount();

    public static GetAccount getInstance() {
        return ourInstance;
    }





    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName The userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }


}


