package cn.edu.bjtu.preeticket.model;

import java.io.Serializable;

public class UserOrganizer implements Serializable {
    private int id_organizer;
    private String username;
    private String password;
    private String organize;
    private String tel_num;
    private String email;
    private String introduce;

    public int getId_organizer() {
        return id_organizer;
    }

    public void setId_organizer(int id_organizer) {
        this.id_organizer = id_organizer;
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

    public String getOrganize() {
        return organize;
    }

    public void setOrganize(String organize) {
        this.organize = organize;
    }

    public String getTel_num() {
        return tel_num;
    }

    public void setTel_num(String tel_num) {
        this.tel_num = tel_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "UserOrganizer{" +
                "id_organizer=" + id_organizer +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", organize='" + organize + '\'' +
                ", tel_num='" + tel_num + '\'' +
                ", email='" + email + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
