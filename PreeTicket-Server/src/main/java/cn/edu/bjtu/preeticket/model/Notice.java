package cn.edu.bjtu.preeticket.model;

import java.io.Serializable;

public class Notice implements Serializable {
    private int id_notice;
    private int id_activity;
    private String time_publish;
    private String detail;

    public int getId_notice() {
        return id_notice;
    }

    public void setId_notice(int id_notice) {
        this.id_notice = id_notice;
    }

    public int getId_activity() {
        return id_activity;
    }

    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
    }

    public String getTime_publish() {
        return time_publish;
    }

    public void setTime_publish(String time_publish) {
        this.time_publish = time_publish;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id_notice=" + id_notice +
                ", id_activity=" + id_activity +
                ", time_publish='" + time_publish + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
