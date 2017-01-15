package com.example;

import com.github.invizible.VerticleDeployBeanPostProcessor;
import io.vertx.core.Vertx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringVertxApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringVertxApplication.class, args);
  }

  @Bean
  public Vertx vertx() {
    return Vertx.vertx();
  }

  @Bean
  public VerticleDeployBeanPostProcessor verticleDeployBeanPostProcessor() {
    return new VerticleDeployBeanPostProcessor();
  }
}
