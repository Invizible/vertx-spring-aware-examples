package com.github.invizible.vertx.springaware.examples.simple;

import com.github.invizible.vertx.springaware.VertxConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(VertxConfiguration.class) // 1. Import Vertx configuration, so Vert.x instance will be available
@SpringBootApplication
public class SpringVertxApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringVertxApplication.class, args); // 2. Run app (will create Spring context)
  }

}
