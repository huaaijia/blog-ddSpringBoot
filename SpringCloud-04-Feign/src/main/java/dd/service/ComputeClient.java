package dd.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by huaaijia on 2016/10/25.
 *
 * 使用@FeignClient("compute-service")注解来绑定该接口对应compute-service服务
 */
@FeignClient("compute-service")
public interface ComputeClient {

    /**
     * 通过Spring MVC的注解来配置compute-service服务下的具体实现
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}