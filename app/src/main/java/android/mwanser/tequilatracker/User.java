package android.mwanser.tequilatracker;

import java.util.Date;

/**
 * Created by Wanser on 12/9/16.
 */

public class User {


    private String name=null;
    private String hometown=null;
    private String username=null;
    private String password=null;
    private Date joinDate=null;



    private static Integer numberOfUsers;

    public User(String Name, String Hometown){
        this.name=Name;
        this.hometown=Hometown;
        this.joinDate= new Date();

    }
    public User(String name, String hometown,String u, String p, Integer i, Date d) {
        this.name = name;
        this.hometown = hometown;
        this.username=u;
        this.password=p;
        this.joinDate=d;
        this.userId=i;

    }
    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Integer getNumberOfUsers() {
        return numberOfUsers;
    }

    public static void setNumberOfUsers(Integer numberOfUsers) {
        User.numberOfUsers = numberOfUsers;
    }

    private Integer userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

