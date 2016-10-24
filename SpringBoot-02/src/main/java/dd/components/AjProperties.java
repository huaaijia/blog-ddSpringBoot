package dd.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by huaaijia on 2016/10/24.
 */
@Component
public class AjProperties {

    @Value("${aj.study.name}")
    private String name;

    @Value("${aj.study.title}")
    private String title;

    @Value("${aj.study.desc}")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
