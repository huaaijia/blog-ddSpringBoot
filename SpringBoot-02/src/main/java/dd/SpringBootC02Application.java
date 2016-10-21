package dd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by huaaijia on 2016/10/21.
 */
@SpringBootApplication
@ComponentScan({"dd.*"})
public class SpringBootC02Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootC02Application.class, args);
    }

}
