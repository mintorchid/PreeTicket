package cn.edu.bjtu.preeticket.service.impl;

import cn.edu.bjtu.preeticket.mapper.TicketMapper;
import cn.edu.bjtu.preeticket.model.Ticket;
import cn.edu.bjtu.preeticket.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public int chooseSeat(Ticket ticket) {
        String seat_map  = ticketMapper.getSeatMap(ticket);
        if (seat_map.charAt(ticket.getSeat()) == '1') {
            return 0;
        } else {
            StringBuilder strBuilder = new StringBuilder(seat_map);
            strBuilder.setCharAt(ticket.getSeat(), '1');
            seat_map = strBuilder.toString();
            ticketMapper.setSeatMap(seat_map, ticket.getId_activity());
            return 1;
        }
    }

    @Override
    public int getTicket(int actid, int userid) {
        Integer res = ticketMapper.getTicket(actid, userid);
        if (res != null) {
            return res.intValue();
        } else {
            return -1;
        }
    }
}
