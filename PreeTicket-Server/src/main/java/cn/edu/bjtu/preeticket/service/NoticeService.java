package cn.edu.bjtu.preeticket.service;

import java.util.List;

import cn.edu.bjtu.preeticket.model.Notice;

public interface NoticeService {
    List<Notice> getNotices(int acid);

    int addNotice(Notice notice);
}
