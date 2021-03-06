package dd.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huaaijia on 2016/10/24.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/hello_user")
    public ModelAndView hello_User() {
        return new ModelAndView("hello_user");
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name){
        return "Hello "+name;
        /**
         * 2016-10-24 15:47:02.693  INFO 6471 --- [nio-8091-exec-8] dd.aspect.WebLogAspect                   : URL : http://localhost:8091/hello
         2016-10-24 15:47:02.693  INFO 6471 --- [nio-8091-exec-8] dd.aspect.WebLogAspect                   : HTTP_METHOD : GET
         2016-10-24 15:47:02.693  INFO 6471 --- [nio-8091-exec-8] dd.aspect.WebLogAspect                   : IP : 0:0:0:0:0:0:0:1
         2016-10-24 15:47:02.694  INFO 6471 --- [nio-8091-exec-8] dd.aspect.WebLogAspect                   : CLASS_METHOD : dd.web.HelloController.hello
         2016-10-24 15:47:02.694  INFO 6471 --- [nio-8091-exec-8] dd.aspect.WebLogAspect                   : ARGS : [abc]
         2016-10-24 15:47:02.701  INFO 6471 --- [nio-8091-exec-8] dd.aspect.WebLogAspect                   : RESPONSE : Hello abc
         */
    }


}
