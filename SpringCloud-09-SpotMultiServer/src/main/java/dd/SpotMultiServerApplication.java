package dd;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by huaaijia on 2016/10/31.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpotMultiServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpotMultiServerApplication.class).web(true).run(args);
    }
}
