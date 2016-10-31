package dd;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by huaaijia on 2016/10/31.
 *
 * @SpringBootApplication : SpringBoot服务
 * @EnableConfigServer : 是一个config服务从配置参数【git】获取数据
 * @EnableDiscoveryClient : 用来将config-server注册到上面配置的服务注册中心上去。
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerExtendApplication {

    public static void main(String[] args){
        new SpringApplicationBuilder(ConfigServerExtendApplication.class).web(true).run(args);
    }
}
