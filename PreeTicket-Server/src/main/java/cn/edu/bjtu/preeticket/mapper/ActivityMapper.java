package cn.edu.bjtu.preeticket.mapper;

import cn.edu.bjtu.preeticket.model.Activity;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ActivityMapper {

    @Select("select * from activity")
    List<Activity> getActivities();

    @Select({"select * from activity where id_organizer=#{id}"})
    List<Activity> getActivitiesById(@Param("id") int id);

    @Insert("insert into activity(id_organizer, name, place, time_signup, time_start, capacity, detail, seat_seletable, seat_row, seat_col, seat_map) values (#{id_organizer}, #{name}, #{place}, #{time_signup}, #{time_start}, #{capacity}, #{detail}, #{seat_seletable}, #{seat_row}, #{seat_col}, #{seat_map})")
    @Options(useGeneratedKeys = true, keyProperty = "id_activity", keyColumn = "id_activity")
    void addActivity(Activity activity);

    @Update("update activity set name=#{name}, place=#{place}, time_signup=#{time_signup}, time_start=#{time_start}, capacity=#{capacity}, detail=#{detail}, seat_seletable=#{seat_seletable}, seat_row=#{seat_row}, seat_col=#{seat_col}, seat_map=#{seat_map} where id_activity=#{id_activity}")
    void updateActivity(Activity activity);
}
