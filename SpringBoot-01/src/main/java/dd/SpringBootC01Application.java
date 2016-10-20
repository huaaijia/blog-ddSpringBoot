package dd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"dd.*"})
public class SpringBootC01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootC01Application.class, args);
	}
}
