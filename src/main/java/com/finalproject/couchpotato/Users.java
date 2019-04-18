//Class coded by Danillo

package com.finalproject.couchpotato;

import java.util.ArrayList;

public class Users {

    private int user_id;
    private String user_username;
    private String user_password;
    private String user_name;
    private int user_age;
    private String user_joinDate;
    InitialiseDB initDB = new InitialiseDB();
    public static ArrayList<Users> users = new ArrayList<>();

    public Users(int user_id, String user_username, String user_password,
                 String user_name, int user_age, String user_joinDate) {
        this.user_id = user_id;
        this.user_username = user_username;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_age = user_age;
        this.user_joinDate = user_joinDate;
    }

    public Users(){}

    //Getters and Setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {this.user_id = user_id;}

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {this.user_name = user_name;}

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_joinDate() {
        return user_joinDate;
    }

    public void setUser_joinDate(String user_joinDate) {
        this.user_joinDate = user_joinDate;
    }


    public ArrayList<Users>getUsers(){users = initDB.getUsers(initDB.getDBConnection());
        return users;}


    //Methods (Add, Update and Delete User)
    public void addNewUser(Users user) {
        initDB.addNewUser(initDB.getDBConnection(), user);
    }

    public void updateUserRecord(Users user) {initDB.updateUserRecord(initDB.getDBConnection(), user);}

    public void deleteUser(Users user) {initDB.deleteUser(initDB.getDBConnection(), user);}

}
