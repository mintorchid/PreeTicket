package cn.edu.bjtu.preeticket.mapper;

import cn.edu.bjtu.preeticket.model.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityMapper {

    @Select("select * from activity")
    List<Activity> getActivities();
}
