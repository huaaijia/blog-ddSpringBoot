package dd;

import dd.rabbitComponent.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by huaaijia on 2016/11/23.
 */
@SpringBootApplication
//public class RabbitApplication implements ApplicationRunner {
public class RabbitApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class, args);
    }
//
//    @Autowired
//    private Sender sender;

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Thread.sleep(2000L);
//
//        sender.send();
//    }

}