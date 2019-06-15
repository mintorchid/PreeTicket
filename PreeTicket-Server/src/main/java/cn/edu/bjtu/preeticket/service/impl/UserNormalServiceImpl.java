package cn.edu.bjtu.preeticket.service.impl;

import cn.edu.bjtu.preeticket.mapper.UserNormalMapper;
import cn.edu.bjtu.preeticket.model.UserNormal;
import cn.edu.bjtu.preeticket.service.UserNormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNormalServiceImpl implements UserNormalService {
    @Autowired
    private UserNormalMapper userNormalMapper;

    @Override
    public int addUser(UserNormal userNormal) {
        userNormalMapper.addUserNormal(userNormal);
        return 1;
    }

    @Override
    public List<UserNormal> getUsers() {
        return userNormalMapper.getUsers();
    }

    @Override
    public int checkPwd(UserNormal userNormal) {
        String realPassword = userNormalMapper.getPwdByUsername(userNormal.getUsername());
        if (realPassword.equals(userNormal.getPassword())) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public UserNormal getUserByUsername(String username){
        return userNormalMapper.getUserByUsername(username);
    }
}
