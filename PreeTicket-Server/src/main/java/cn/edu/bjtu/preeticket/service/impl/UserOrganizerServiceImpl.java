package cn.edu.bjtu.preeticket.service.impl;

import cn.edu.bjtu.preeticket.mapper.UserOrganizerMapper;
import cn.edu.bjtu.preeticket.model.UserOrganizer;
import cn.edu.bjtu.preeticket.service.UserOrganizerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrganizerServiceImpl implements UserOrganizerService {
    @Autowired
    private UserOrganizerMapper userOrganizerMapper;

    @Override
    public int addUser(UserOrganizer userOrganizer) {
        userOrganizerMapper.addUserOrganizer(userOrganizer);
        return 1;
    }

    @Override
    public List<UserOrganizer> getUsers() {
        return userOrganizerMapper.getUsers();
    }

    @Override
    public int checkPwd(UserOrganizer userOrganizer) {
        String realPassword = userOrganizerMapper.getPwdByUsername(userOrganizer.getUsername());
        if (realPassword.equals(userOrganizer.getPassword())) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public UserOrganizer getUserByUsername(String username) {
        return userOrganizerMapper.getUserByUsername(username);
    }
}
