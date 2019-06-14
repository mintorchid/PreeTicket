package cn.edu.bjtu.preeticket.controller;

import cn.edu.bjtu.preeticket.mapper.UserMapper;
import cn.edu.bjtu.preeticket.model.User;
import cn.edu.bjtu.preeticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
           return userService.getUsers();
    }
}
