package cn.edu.bjtu.preeticket.controller;

import cn.edu.bjtu.preeticket.model.Activity;
import cn.edu.bjtu.preeticket.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/activity",method = RequestMethod.GET)
    public List<Activity> getActivities(){
        return activityService.getActivities();
    }

    @RequestMapping(value = "/activityByCreator", method = RequestMethod.GET)
    public List<Activity> getActivities(@RequestParam("userID") int id) {
        return activityService.getActivities(id);
    }

    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    public int addActivity(Activity activity) {
        return activityService.addActivity(activity);
    }

    @RequestMapping(value = "/updateActivity", method = RequestMethod.POST)
    public int updateActivity(Activity activity) {
        return activityService.updateActivity(activity);
    }
}
