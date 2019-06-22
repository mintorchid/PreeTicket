package cn.edu.bjtu.preeticket.service.impl;

import cn.edu.bjtu.preeticket.mapper.NoticeMapper;
import cn.edu.bjtu.preeticket.model.Notice;
import cn.edu.bjtu.preeticket.service.NoticeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public void addNotice(Notice notice) {
        noticeMapper.addNotice(notice);
    }

    @Override
    public List<Notice> getNotices(int acid) {
        return noticeMapper.getNoticesByAcId(acid);
    }
}
