package cn.edu.bjtu.preeticket.model;

import java.io.Serializable;

public class UserNormal implements Serializable {
    private int id_normal;
    private int gender;
    private String nikename;
    private String avator;

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

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    @Override
    public String toString() {
        return "UserNormal{" +
                "id_normal=" + id_normal +
                ", gender=" + gender +
                ", nikename='" + nikename + '\'' +
                ", avator='" + avator + '\'' +
                '}';
    }
}
