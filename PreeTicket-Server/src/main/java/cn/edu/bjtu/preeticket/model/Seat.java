package cn.edu.bjtu.preeticket.model;

import java.io.Serializable;

public class Seat implements Serializable {
    public int seat_selectable;
    public int seat_row;
    public int seat_col;
    public String seat_map;

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

    public String getSeat_map() {
        return seat_map;
    }

    public void setSeat_map(String seat_map) {
        this.seat_map = seat_map;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seat_selectable=" + seat_selectable +
                ", seat_row=" + seat_row +
                ", seat_col=" + seat_col +
                ", seat_map='" + seat_map + '\'' +
                '}';
    }
}