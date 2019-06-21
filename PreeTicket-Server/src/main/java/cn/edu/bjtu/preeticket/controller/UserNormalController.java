package cn.edu.bjtu.preeticket.controller;

import cn.edu.bjtu.preeticket.model.UserNormal;
import cn.edu.bjtu.preeticket.service.UserNormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserNormalController {
    @Autowired
    private UserNormalService userNormalService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public UserNormal getUserByUsername(@RequestParam("username") String username) {
        return userNormalService.getUserByUsername(username);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int checkPwd(UserNormal userNormal) {
        return userNormalService.checkPwd(userNormal);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public int addUser(UserNormal userNormal) {
        return userNormalService.addUser(userNormal);
    }
}
