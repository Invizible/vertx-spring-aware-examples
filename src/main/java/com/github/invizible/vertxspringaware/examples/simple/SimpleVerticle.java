package com.github.invizible.vertxspringaware.examples.simple;

import com.github.invizible.vertx.springaware.Verticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;

@Verticle
public class SimpleVerticle extends AbstractVerticle {

  @Autowired
  private TestService testService;

  @Override
  public void start() throws Exception {
    HttpServer httpServer = vertx.createHttpServer()
      .requestHandler(request -> {
        request.response().end(testService.getMessage());
      })
      .listen(8080);
  }
}
