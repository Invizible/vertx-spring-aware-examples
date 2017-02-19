package com.github.invizible.vertx.springaware.examples.clustered;

import com.github.invizible.vertx.springaware.ClusteredVertxConfiguration;
import io.vertx.core.DeploymentOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(ClusteredVertxConfiguration.class) // 1. Import Vertx configuration, so clustered Vert.x instance will be available
@SpringBootApplication
public class SpringVertxApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringVertxApplication.class, args); // 2. Run app (will create Spring context)
  }

  @Bean
  public DeploymentOptions commonVerticleDeploymentOptions() { // 3. (optional) Specify some common configuration for verticles
    return new DeploymentOptions().setInstances(2); //deploy 2 instances of each Verticle. Just for fun :)
  }
}
