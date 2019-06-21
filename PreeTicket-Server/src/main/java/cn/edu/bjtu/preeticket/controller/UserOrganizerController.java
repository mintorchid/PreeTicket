package cn.edu.bjtu.preeticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.bjtu.preeticket.model.UserOrganizer;
import cn.edu.bjtu.preeticket.service.UserOrganizerService;

@RestController
public class UserOrganizerController {
    @Autowired
    private UserOrganizerService userOrganizerService;

    @RequestMapping(value = "/org_index", method = RequestMethod.GET)
    public UserOrganizer getUserByUsername(@RequestParam("username") String username) {
        return userOrganizerService.getUserByUsername(username);
    }

    @RequestMapping(value = "/org_login", method = RequestMethod.POST)
    public int checkPwd(UserOrganizer userOrganizer) {
        return userOrganizerService.checkPwd(userOrganizer);
    }

    @RequestMapping(value = "/org_register", method = RequestMethod.POST)
    public int addUser(UserOrganizer userOrganizer) {
        return userOrganizerService.addUser(userOrganizer);
    }
}
