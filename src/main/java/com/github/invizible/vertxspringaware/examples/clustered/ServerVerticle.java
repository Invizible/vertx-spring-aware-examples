package com.github.invizible.vertxspringaware.examples.clustered;

import com.github.invizible.vertx.springaware.Verticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;

@Verticle
public class ServerVerticle extends AbstractVerticle {

  @Autowired
  private TestService testService;

  @Override
  public void start() throws Exception {
    HttpServer httpServer = vertx.createHttpServer()
      .requestHandler(request -> {
        testService.getBlockingMessage(result -> {
          request.response().end(result);
        });
      })
      .listen(8080);
  }
}
