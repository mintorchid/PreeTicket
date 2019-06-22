package cn.edu.bjtu.preeticket.model;

import java.io.Serializable;

public class Activity implements Serializable {
    private int id_activity;
    private int id_organizer;
    private int status;
    private int capacity;
    private int seat_selectable;
    private int seat_row;
    private int seat_col;
    private String name;
    private String place;
    private String time_signup;
    private String time_start;
    private String detail;
    private String seat_map;

    public int getId_activity() {
        return id_activity;
    }

    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
    }

    public int getId_organizer() {
        return id_organizer;
    }

    public void setId_organizer(int id_organizer) {
        this.id_organizer = id_organizer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSeat_selectable() {
        return seat_selectable;
    }

    public void setSeat_selectable(int seat_selectable) {
        this.seat_selectable = seat_selectable;
    }

    public int getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(int seat_row) {
        this.seat_row = seat_row;
    }

    public int getSeat_col() {
        return seat_col;
    }

    public void setSeat_col(int seat_col) {
        this.seat_col = seat_col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime_signup() {
        return time_signup;
    }

    public void setTime_signup(String time_signup) {
        this.time_signup = time_signup;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSeat_map() {
        return seat_map;
    }

    public void setSeat_map(String seat_map) {
        this.seat_map = seat_map;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id_activity=" + id_activity +
                ", id_organizer=" + id_organizer +
                ", status=" + status +
                ", capacity=" + capacity +
                ", seat_selectable=" + seat_selectable +
                ", seat_row=" + seat_row +
                ", seat_col=" + seat_col +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", time_signup='" + time_signup + '\'' +
                ", time_start='" + time_start + '\'' +
                ", detail='" + detail + '\'' +
                ", seat_map='" + seat_map + '\'' +
                '}';
    }
}
