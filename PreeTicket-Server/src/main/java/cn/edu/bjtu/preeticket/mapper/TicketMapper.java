package cn.edu.bjtu.preeticket.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.bjtu.preeticket.model.Ticket;

@Mapper
public interface TicketMapper {

    @Select({"select seat_map from activity where id_activity=#{id_activity}"})
    String getSeatMap(Ticket ticket);

    @Update("update activity set seat_map=#{seat_map}")
    void updateSeatMap(String seat_map);
}
