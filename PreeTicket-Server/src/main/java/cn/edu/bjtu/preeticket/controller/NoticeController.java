package cn.edu.bjtu.preeticket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.bjtu.preeticket.model.Notice;
import cn.edu.bjtu.preeticket.service.NoticeService;

public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/addNotice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addNotice(@RequestBody JSONObject noticeInfo) {
        Notice notice = JSON.toJavaObject(noticeInfo, Notice.class);

        noticeService.addNotice(notice);

        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("msg", "成功");
        return result.toJSONString();
    }
}
