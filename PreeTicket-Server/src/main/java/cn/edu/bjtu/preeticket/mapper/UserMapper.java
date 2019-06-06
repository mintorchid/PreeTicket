package cn.edu.bjtu.preeticket.mapper;

import cn.edu.bjtu.preeticket.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
//    @Results({
//            @Result(property = "id_user",  column = "id_user"),
//            @Result(property = "username", column = "username")
//    })
    List<User> getAll();
}
