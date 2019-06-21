package cn.edu.bjtu.preeticket.service;

import cn.edu.bjtu.preeticket.model.Ticket;

public interface TicketService {
    int chooseSeat(Ticket ticket);
    int getTicket(int actid, int userid);
}
