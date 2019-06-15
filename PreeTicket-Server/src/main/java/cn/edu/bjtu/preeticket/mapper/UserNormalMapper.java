package cn.edu.bjtu.preeticket.mapper;

import cn.edu.bjtu.preeticket.model.UserNormal;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserNormalMapper {
    @Insert("insert into user_normal(username,password,nickname,avator,gender,tel_num,email) values (#{username},#{password},#{nickname},#{avator},#{gender},#{tel_num},#{email})")
    @Options(useGeneratedKeys=true, keyProperty="id_normal", keyColumn="id_normal")
    void addUserNormal(UserNormal userNormal);

    @Select("select * from user_normal")
    List<UserNormal> getUsers();

    @Select({"select password from user_normal where username = #{username}"})
    String getPwdByUsername(@Param("username") String username);

    @Select({"select * from user_normal where username = #{username}"})
    UserNormal getUserByUsername(@Param("username") String username);
}
