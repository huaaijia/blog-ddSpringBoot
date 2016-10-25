package dd;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by huaaijia on 2016/10/25.
 *
 * @EnableEurekaServer
 * 注解启动一个服务注册中心提供给其他应用进行对话
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootCloudServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootCloudServiceApplication.class).web(true).run(args);
    }

}