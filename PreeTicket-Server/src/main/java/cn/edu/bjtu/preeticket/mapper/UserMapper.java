package cn.edu.bjtu.preeticket.mapper;

import cn.edu.bjtu.preeticket.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert({"insert into user(id_user, username, password, tel_num, email) value(#{id_user}, #{username}, #{password}, #{tel_num}, #{email})"})
    void addUser(int id_user, String username, String password, String tel_num, String email);

    @Delete({"delete from user where id_user = #{id_user}"})
    void delUserById(@Param("id_user") int id_user);

    @Update("update user set username = #{username} where id_user = #{id_user}")
    void updateUserByNo(@Param("username") String username, @Param("id_user") int id_user);

    @Select("select * from user")
    List<User> getUsers();
}
