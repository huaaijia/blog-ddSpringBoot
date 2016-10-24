package dd.web;

import dd.components.AjProperties;
import dd.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huaaijia on 2016/10/19.
 */
@RestController
public class HelloController {

    @Autowired
    private AjProperties ajProperties;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/")
    public ModelAndView index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return new ModelAndView("index");
    }

    @RequestMapping("/error_global")
    public String error_global() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/error_global_json")
    public String error_global_json() throws Exception {
        throw new MyException("发生错误_json");
    }

    @RequestMapping("/self_properties")
    @ResponseBody
    public Object fetch_properties(){
        return ajProperties;
    }
}
