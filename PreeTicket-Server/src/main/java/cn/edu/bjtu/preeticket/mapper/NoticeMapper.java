package cn.edu.bjtu.preeticket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.bjtu.preeticket.model.Notice;

@Mapper
public interface NoticeMapper {
    @Insert("insert into notice(id_act, time_publish, detail) values (#{id_act}, #{time_publish}, #{detail})")
    @Options(useGeneratedKeys = true, keyProperty = "id_notice", keyColumn = "id_notice")
    void addNotice(Notice notice);

    @Select({"select * from notice where id_act=#{acid}"})
    List<Notice> getNoticesByAcId(@Param("acid") int acid);
}
