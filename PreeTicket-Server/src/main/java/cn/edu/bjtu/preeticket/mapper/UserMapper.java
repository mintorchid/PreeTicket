package cn.edu.bjtu.preeticket.mapper;

import cn.edu.bjtu.preeticket.model.UserNormal;
import cn.edu.bjtu.preeticket.model.UserOrganizer;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user_normal(username,password,nickname,avator,gender,tel_num,email) values (#{username},#{password},#{nickname},#{avator},#{gender},#{tel_num},#{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id_normal", keyColumn = "id_normal")
    void addNormalUser(UserNormal userNormal);

    @Select({"select * from user_normal where username = #{username}"})
    UserNormal getNormalUser(@Param("username") String username);

    @Select({"select * from user_organizer where username = #{username}"})
    UserOrganizer getOrgUser(@Param("username") String username);
}
