package cn.edu.bjtu.preeticket.service.impl;

import cn.edu.bjtu.preeticket.mapper.NoticeMapper;
import cn.edu.bjtu.preeticket.model.Notice;
import cn.edu.bjtu.preeticket.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int addNotice(Notice notice) {
        noticeMapper.addNotice(notice);
        return 1;
    }
}