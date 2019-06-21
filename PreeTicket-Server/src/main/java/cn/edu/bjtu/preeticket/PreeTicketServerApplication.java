package cn.edu.bjtu.preeticket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("cn.edu.bjtu.pree ticket.mapper")
@EnableSwagger2
public class PreeTicketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreeTicketServerApplication.class, args);
    }
}
