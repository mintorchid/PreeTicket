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
    private UserNormalMapper userNormalService;

    @Override
    public void addUser(UserNormal userNormal) {
        userNormalService.addUserNormal(userNormal);
    }

    @Override
    public List<UserNormal> getUsers() {
        return userNormalService.getUsers();
    }

    @Override
    public int checkPwd(UserNormal userNormal) {
        String realPassword = userNormalService.getPwdByUsername(userNormal.getUsername());
        if (realPassword.equals(userNormal.getPassword())) {
            return 1;
        } else {
            return 0;
        }
    }
}
