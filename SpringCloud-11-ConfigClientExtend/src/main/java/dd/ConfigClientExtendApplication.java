package dd;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by huaaijia on 2016/10/31.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientExtendApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(ConfigClientExtendApplication.class).web(true).run(args);
    }
}
