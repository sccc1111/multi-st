package mybaits;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by songbo on 2018/7/25.
 */
@SpringBootApplication
@MapperScan("mybaits.mapper")
public class MybaitsApp {
    public static void main(String[] args){
        SpringApplication.run(MybaitsApp.class,args);
    }
}
