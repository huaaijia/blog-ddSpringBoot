package dd;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by huaaijia on 2016/10/25.
 *
 * @EnableEurekaServer
 * 注解启动一个服务注册中心提供给其他应用进行对话
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringBootCloudServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootCloudServerApplication.class).web(true).run(args);
    }
}