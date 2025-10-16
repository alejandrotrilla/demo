package ar.com.trilla.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class DemoApiProjectApplication {

    static void main(String[] args) {
        SpringApplication.run(
                DemoApiProjectApplication.class,
                args
        );
    }
}
