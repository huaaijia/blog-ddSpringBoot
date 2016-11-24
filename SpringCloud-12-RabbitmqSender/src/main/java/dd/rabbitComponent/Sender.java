package dd.rabbitComponent;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by huaaijia on 2016/11/23.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        this.rabbitTemplate.convertAndSend("hello_springBoot", context);

        System.out.println("Sender : " + context);
    }
}