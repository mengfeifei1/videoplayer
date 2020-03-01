package cn.edu.hebtu.software.player.Bean;

import java.io.Serializable;

public class UserBean implements Serializable{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
