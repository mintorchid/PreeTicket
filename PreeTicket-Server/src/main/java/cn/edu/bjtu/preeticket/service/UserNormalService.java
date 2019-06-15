package cn.edu.bjtu.preeticket.service;

import cn.edu.bjtu.preeticket.model.UserNormal;

import java.util.List;

public interface UserNormalService {

    int addUser(UserNormal userNormal);

    int checkPwd(UserNormal userNormal);

    UserNormal getUserByUsername(String username);

    List<UserNormal> getUsers();
}
