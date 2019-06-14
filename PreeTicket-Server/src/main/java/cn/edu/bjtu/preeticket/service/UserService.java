package cn.edu.bjtu.preeticket.service;

import cn.edu.bjtu.preeticket.model.User;

import java.util.List;

public interface UserService {

    void addUser(int id_user, String username, String password, String tel_num, String email);

    void delUserById(int id_user);

    void updateUserByNo(String username, int id_user);

    List<User> getUsers();
}
