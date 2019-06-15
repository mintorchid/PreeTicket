package cn.edu.bjtu.preeticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.bjtu.preeticket.model.Notice;
import cn.edu.bjtu.preeticket.service.NoticeService;

public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/addNotice", method = RequestMethod.POST)
    public int addNotice(Notice notice) {
        return noticeService.addNotice(notice);
    }
}
