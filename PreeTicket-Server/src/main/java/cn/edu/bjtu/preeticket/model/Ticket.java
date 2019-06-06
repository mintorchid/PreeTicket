package cn.edu.bjtu.preeticket.model;

import java.io.Serializable;

public class Ticket implements Serializable {
    private int id_activity;
    private int id_user;
    private int seat;

    public int getId_activity() {
        return id_activity;
    }

    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id_activity=" + id_activity +
                ", id_user=" + id_user +
                ", seat=" + seat +
                '}';
    }
}
