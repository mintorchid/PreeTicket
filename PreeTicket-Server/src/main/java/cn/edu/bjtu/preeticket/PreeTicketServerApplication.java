package cn.edu.bjtu.preeticket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.bjtu.pree ticket.mapper")
public class PreeTicketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreeTicketServerApplication.class, args);
    }
}
