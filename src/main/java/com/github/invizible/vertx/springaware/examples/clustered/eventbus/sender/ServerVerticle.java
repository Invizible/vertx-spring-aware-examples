package com.github.invizible.vertx.springaware.examples.clustered.eventbus.sender;

import com.github.invizible.vertx.springaware.Verticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

@Verticle
public class ServerVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    HttpServer httpServer = vertx.createHttpServer()
      .requestHandler(request -> {
        vertx.eventBus().send("example.test", request.params().toString()); // this will be consumed in another verticle in cluster
        request.response().end("Put some params in url: e.g. ?message=hi");
      })
      .listen(8080);
  }
}
