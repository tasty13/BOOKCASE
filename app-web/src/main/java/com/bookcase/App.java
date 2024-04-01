package com.bookcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource({
        "classpath:config/ncp.properties",
//        "classpath:config/ncp-secret.properties"
})
@Controller
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
