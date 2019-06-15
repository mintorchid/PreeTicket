package cn.edu.bjtu.preeticket.controller;

import cn.edu.bjtu.preeticket.model.Activity;
import cn.edu.bjtu.preeticket.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
