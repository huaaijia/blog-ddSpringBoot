package dd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by huaaijia on 2016/10/21.
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@ComponentScan({"dd.*"})
public class SpringBootC04Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootC04Application.class, args);
    }

}
