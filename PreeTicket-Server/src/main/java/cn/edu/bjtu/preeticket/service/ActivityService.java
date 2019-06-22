package cn.edu.bjtu.preeticket.service;

import cn.edu.bjtu.preeticket.model.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> getActivities();
    List<Activity> getActivities(int id);
    Activity getActivity(int id);

    void addActivity(Activity activity);
    void updateActivity(Activity activity);
}
