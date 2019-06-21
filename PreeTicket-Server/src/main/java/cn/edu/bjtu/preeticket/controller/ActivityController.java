package cn.edu.bjtu.preeticket.controller;

import cn.edu.bjtu.preeticket.model.Activity;
import cn.edu.bjtu.preeticket.model.Notice;
import cn.edu.bjtu.preeticket.model.Seat;
import cn.edu.bjtu.preeticket.service.ActivityService;
import cn.edu.bjtu.preeticket.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    private NoticeService noticeService;

    @RequestMapping(value = "/activity",method = RequestMethod.GET)
    public String getActivities(){
        class Res {
            public Activity a;
            public Notice n[];
        }
        List<Res> res = new ArrayList<Res>();
        List<Activity> acs = activityService.getActivities();
        for (int i = 0; i < acs.size(); i++) {
            Res r = new Res();
            r.a = acs.get(i);
            noticeService.getNotices(acs.get(i).getId_activity()).toArray(r.n);
            res.add(r);
        }
        return JSON.toJSONString(res);
    }

    @RequestMapping(value = "/activityByCreator", method = RequestMethod.GET)
    public String getActivities(@RequestParam("userID") int id) {
        class Res {
            public Activity a;
            public Notice n[];
        }
        List<Res> res = new ArrayList<Res>();
        List<Activity> acs = activityService.getActivities(id);
        for (int i = 0; i < acs.size(); i++) {
            Res r = new Res();
            r.a = acs.get(i);
            noticeService.getNotices(acs.get(i).getId_activity()).toArray(r.n);
            res.add(r);
        }
        return JSON.toJSONString(res);
    }

    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    public int addActivity(Activity activity) {
        return activityService.addActivity(activity);
    }

    @RequestMapping(value = "/updateActivity", method = RequestMethod.POST)
    public int updateActivity(Activity activity) {
        return activityService.updateActivity(activity);
    }

    @RequestMapping(value = "/getSeat", method = RequestMethod.GET)
    public String getSeat(@RequestParam("actID") int id) {
        Activity act = activityService.getActivity(id);
        Seat s = new Seat();
        s.seat_col = act.getSeat_col();
        s.seat_map = act.getSeat_map();
        s.seat_row = act.getSeat_row();
        s.seat_selectable = act.getSeat_selectable();

        return JSON.toJSONString(s);
    }
}
