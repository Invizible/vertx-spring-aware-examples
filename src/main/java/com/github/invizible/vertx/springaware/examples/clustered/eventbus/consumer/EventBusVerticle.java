package com.github.invizible.vertx.springaware.examples.clustered.eventbus.consumer;

import com.github.invizible.vertx.springaware.Verticle;
import io.vertx.core.AbstractVerticle;
import lombok.extern.apachecommons.CommonsLog;

/**
 * @author Alex
 */
@CommonsLog
@Verticle
public class EventBusVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    vertx.eventBus().consumer("example.test", message -> {
      log.info("Message received from Event Bus");
      log.info(message.body());
    });
  }
}
