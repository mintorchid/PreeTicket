package cn.edu.bjtu.preeticket.model;

import java.io.Serializable;

public class UserOrganizer implements Serializable {
    private int id_organizer;
    private String username;
    private String password;
    private String tel;
    private String email;

    public int getId() {
        return id_organizer;
    }

    public void setId(int id) {
        this.id_organizer = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserOrganizer{" +
                "id=" + id_organizer +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
