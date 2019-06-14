package cn.edu.bjtu.preeticket.service.impl;

import cn.edu.bjtu.preeticket.mapper.UserMapper;
import cn.edu.bjtu.preeticket.model.User;
import cn.edu.bjtu.preeticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(int id_user, String username, String password, String tel_num, String email){
        System.out.println("addUser");
    }

    @Override
    public void delUserById(int id_user){
        System.out.println("delUserById");
    }

    @Override
    public void updateUserByNo(String username, int id_user){
        System.out.println("updateUserByNo");
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

}
