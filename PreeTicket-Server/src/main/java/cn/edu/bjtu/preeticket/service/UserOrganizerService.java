package cn.edu.bjtu.preeticket.service;

import java.util.List;

import cn.edu.bjtu.preeticket.model.UserOrganizer;

public interface UserOrganizerService {

    int addUser(UserOrganizer userOrganizer);

    int checkPwd(UserOrganizer userOrganizer);

    UserOrganizer getUserByUsername(String username);

    List<UserOrganizer> getUsers();
}
