package dd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huaaijia on 2016/10/25.
 *
 * 通过@EnableDiscoveryClient注解来添加发现服务能力
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonApplication {

    /**
     * 并通过@LoadBalanced注解开启均衡负载能力
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}
