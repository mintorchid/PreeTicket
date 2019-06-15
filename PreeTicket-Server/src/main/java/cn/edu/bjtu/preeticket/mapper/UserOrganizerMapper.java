package cn.edu.bjtu.preeticket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.bjtu.preeticket.model.UserOrganizer;

@Mapper
public interface UserOrganizerMapper {
    @Insert("insert into user_organizer(username, password, organize, tel_num, email, introduce) values (#{username}, #{password}, #{organize}, #{tel_num}, #{email}, #{introduce})")
    @Options(useGeneratedKeys = true, keyProperty = "id_organizer", keyColumn = "id_organizer")
    void addUserOrganizer(UserOrganizer userOrganizer);

    @Select("select * from user_organizer")
    List<UserOrganizer> getUsers();

    @Select({"select password from user_organizer where username = #{username}"})
    String getPwdByUsername(@Param("username") String username);

    @Select({"select * from user_organizer where username = #{username}"})
    UserOrganizer getUserByUsername(@Param("username") String username);
}
