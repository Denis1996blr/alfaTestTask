package SpringStarts;

import SpringStarts.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class MyClass {

    public static void main(String[] args) {
        SpringApplication.run(MyClass.class, args);
    }

}