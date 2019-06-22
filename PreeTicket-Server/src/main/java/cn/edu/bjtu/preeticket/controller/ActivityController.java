package cn.edu.bjtu.preeticket.controller;

import cn.edu.bjtu.preeticket.model.Activity;
import cn.edu.bjtu.preeticket.model.Notice;
import cn.edu.bjtu.preeticket.model.Seat;
import cn.edu.bjtu.preeticket.service.ActivityService;
import cn.edu.bjtu.preeticket.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/activity",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getActivities(){
        class Res {
            public Activity a;
            public List<Notice> n;
        }
        List<Res> res = new ArrayList<Res>();
        List<Activity> acs = activityService.getActivities();
        for (int i = 0; i < acs.size(); i++) {
            Res r = new Res();
            r.a = acs.get(i);
            r.n = noticeService.getNotices(acs.get(i).getId_activity());
            res.add(r);
        }

        //JSONObject data = (JSONObject) JSON.toJSON(res);
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("msg", "成功");
        result.put("data", res);
        return result.toJSONString();
    }

    @RequestMapping(value = "/activityByCreator", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getActivities(@RequestBody JSONObject idJson) {
        int id = idJson.getIntValue("id_organizer");

        class Res {
            public Activity a;
            public List<Notice> n;
        }
        List<Res> res = new ArrayList<Res>();
        List<Activity> acs = activityService.getActivities(id);
        for (int i = 0; i < acs.size(); i++) {
            Res r = new Res();
            r.a = acs.get(i);
            r.n = noticeService.getNotices(acs.get(i).getId_activity());
            res.add(r);
        }

//        JSONObject data = (JSONObject) JSON.toJSON(res);
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("msg", "成功");
        result.put("data", res);
        return result.toJSONString();
    }

    @RequestMapping(value = "/addActivity", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addActivity(@RequestBody JSONObject activityJson) {
        Activity activity = JSON.toJavaObject(activityJson, Activity.class);

        activityService.addActivity(activity);

        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("msg", "成功");
        return result.toJSONString();
    }

    @RequestMapping(value = "/updateActivity", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updateActivity(@RequestBody JSONObject activityJson) {
        Activity activity = JSON.toJavaObject(activityJson, Activity.class);

        activityService.updateActivity(activity);

        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("msg", "成功");
        return result.toJSONString();
    }

    @RequestMapping(value = "/joinActivity", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String joinActivity() {
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("msg", "成功");
        return result.toJSONString();
    }

    @RequestMapping(value = "/getSeat", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getSeat(@RequestBody JSONObject idJson) {
        int id = idJson.getIntValue("id_act");

        Activity act = activityService.getActivity(id);
        Seat s = new Seat();
        s.seat_col = act.getSeat_col();
        s.seat_map = act.getSeat_map();
        s.seat_row = act.getSeat_row();
        s.seat_selectable = act.getSeat_selectable();

        JSONObject data = (JSONObject) JSON.toJSON(s);
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("msg", "成功");
        result.put("data", data);
        return result.toJSONString();
    }
}
