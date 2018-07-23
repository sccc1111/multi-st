package admin;

import com.google.common.collect.Maps;
import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by songbo on 2018/7/23.
 */
@SpringBootApplication
@EnableAdminServer // 开启管控台
@RestController
public class AdminApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }

    @GetMapping("/")
    public Map<String, Object> index() {
        ConcurrentMap<String, Object> ret = Maps.newConcurrentMap();
        ret.put("msg", "Hello Spring Boot Admin");
        return ret;
    }
}
