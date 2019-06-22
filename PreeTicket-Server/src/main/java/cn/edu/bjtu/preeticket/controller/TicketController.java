package cn.edu.bjtu.preeticket.controller;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.bjtu.preeticket.model.Ticket;
import cn.edu.bjtu.preeticket.service.TicketService;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/chooseSeat", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String chooseSeat(Ticket ticket) {
        int success = 0;
        success = ticketService.chooseSeat(ticket);
        return JSON.toJSONString(success);
    }

    @RequestMapping(value = "/getTicket", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getTicket(@RequestParam("actID") int actid, @RequestParam("userID") int userid) {
        int success = -1;
        success = ticketService.getTicket(actid, userid);
        return JSON.toJSONString(success);
    }
}
