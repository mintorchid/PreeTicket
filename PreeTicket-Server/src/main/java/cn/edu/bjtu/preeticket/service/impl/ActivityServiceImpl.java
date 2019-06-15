package cn.edu.bjtu.preeticket.service.impl;

import cn.edu.bjtu.preeticket.mapper.ActivityMapper;
import cn.edu.bjtu.preeticket.model.Activity;
import cn.edu.bjtu.preeticket.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> getActivities(){
        return activityMapper.getActivities();
    }
}
