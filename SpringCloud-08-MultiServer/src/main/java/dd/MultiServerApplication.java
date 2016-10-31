package dd;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by huaaijia on 2016/10/31.
 */
@EnableEurekaServer
@SpringBootApplication
public class MultiServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MultiServerApplication.class).web(true).run(args);
    }
}