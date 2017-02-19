package com.github.invizible.vertx.springaware.examples.clustered;

import com.github.invizible.vertx.springaware.Verticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Verticle(deploymentOptionsBeanName = "options1")
public class ServerVerticleWithConfiguration extends AbstractVerticle {

  @Autowired
  private TestService testService;

  @Bean
  public DeploymentOptions options1() {
    return new DeploymentOptions().setConfig(new JsonObject().put("author", "Invizible"));
  }

  @Override
  public void start() throws Exception {
    HttpServer httpServer = vertx.createHttpServer()
      .requestHandler(request -> request.response().end(config().toString()))
      .listen(8081);
  }
}
