package task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by songbo on 2018/7/26.
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "task.job")
public class TaskApp {
    public static void main(String[] args) {
        SpringApplication.run(TaskApp.class, args);
    }
}
