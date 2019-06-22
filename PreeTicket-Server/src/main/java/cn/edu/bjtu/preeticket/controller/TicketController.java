package cn.edu.bjtu.preeticket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.bjtu.preeticket.model.Ticket;
import cn.edu.bjtu.preeticket.service.TicketService;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/chooseSeat", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String chooseSeat(@RequestBody JSONObject ticketInfo) {
        Ticket ticket = JSON.toJavaObject(ticketInfo, Ticket.class);

        int success = 0;
        success = ticketService.chooseSeat(ticket);

        JSONObject result = new JSONObject();
        if (success == 1) {
            result.put("code", 200);
            result.put("msg", "成功");
        } else {
            result.put("code", 400);
            result.put("msg", "失败");
        }
        return result.toJSONString();
    }

    @RequestMapping(value = "/getTicket", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getTicket(@RequestBody JSONObject getTicketInfo) {
        int actid = getTicketInfo.getIntValue("actID");
        int userid = getTicketInfo.getIntValue("userID");

        int seat = -1;
        seat = ticketService.getTicket(actid, userid);

        JSONObject result = new JSONObject();
        JSONObject data = (JSONObject) JSON.toJSON(seat);
        if (seat == -1) {
            result.put("code", 400);
            result.put("msg", "失败");
        } else {
            result.put("code", 200);
            result.put("msg", "成功");
        }
        result.put("data", data);
        return result.toJSONString();
    }
}
