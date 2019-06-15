package cn.edu.bjtu.preeticket.controller;

import cn.edu.bjtu.preeticket.model.UserNormal;
import cn.edu.bjtu.preeticket.service.UserNormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserNormalController {
    @Autowired
    private UserNormalService userNormalService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserNormal> getUsers() {
        return userNormalService.getUsers();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int checkPwd(UserNormal userNormal) {
        return userNormalService.checkPwd(userNormal);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void addUser(UserNormal userNormal) {
        userNormalService.addUser(userNormal);
    }
}
