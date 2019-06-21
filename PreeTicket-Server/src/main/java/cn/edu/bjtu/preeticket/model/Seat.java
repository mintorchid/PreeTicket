package cn.edu.bjtu.preeticket.model;

import java.io.Serializable;

public class Seat implements Serializable {
    public int seat_selectable;
    public int seat_row;
    public int seat_col;
    public String seat_map;

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