package cn.apeius.springmvc.pojo;

/**
 * Created by Asus on 2016/9/3.
 */
public class User {

    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString(){
        return userName + " " + password;
    }
}
