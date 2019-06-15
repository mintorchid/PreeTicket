package cn.edu.bjtu.preeticket.model;

import java.io.Serializable;

public class UserNormal implements Serializable {
    private int id_normal;
    private int gender;
    private String username;
    private String password;
    private String nickname;
    private String avator;
    private String tel_num;
    private String email;

    public int getId_normal() {
        return id_normal;
    }

    public void setId_normal(int id_normal) {
        this.id_normal = id_normal;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
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

    @Override
    public String toString() {
        return "UserNormal{" +
                "id_normal=" + id_normal +
                ", gender=" + gender +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avator='" + avator + '\'' +
                ", tel_num='" + tel_num + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
