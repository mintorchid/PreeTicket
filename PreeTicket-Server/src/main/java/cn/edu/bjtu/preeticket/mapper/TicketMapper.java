package cn.edu.bjtu.preeticket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.bjtu.preeticket.model.Ticket;

@Mapper
public interface TicketMapper {

    @Select({"select seat_map from activity where id_activity=#{id_activity}"})
    String getSeatMap(Ticket ticket);

    @Update("update activity set seat_map=#{seat_map} where id_activity=#{id_activity}")
    void setSeatMap(@Param("seat_map") String seat_map, Ticket ticket);

    @Select({"select seat from ticket where id_activity=#{id_activity} and id_user=#{id_user}"})
    Integer getTicket(@Param("id_activity") int id_activity, @Param("id_user") int id_user);
}
