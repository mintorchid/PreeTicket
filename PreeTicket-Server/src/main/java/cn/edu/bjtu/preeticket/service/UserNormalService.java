package cn.edu.bjtu.preeticket.service;

import cn.edu.bjtu.preeticket.model.UserNormal;

import java.util.List;

public interface UserNormalService {

    void addUser(UserNormal userNormal);

    int checkPwd(UserNormal userNormal);

    List<UserNormal> getUsers();
}
