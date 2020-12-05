package top.fuyuaaa.testboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.fuyuaaa.brush.spring.EnableBrush;

@SpringBootApplication
@EnableBrush
public class TestBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBootApplication.class, args);
    }

}
