package cn.edu.bjtu.preeticket.service;

import cn.edu.bjtu.preeticket.model.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> getActivities();
    List<Activity> getActivities(int id);

    int addActivity(Activity activity);
    int updateActivity(Activity activity);
}
