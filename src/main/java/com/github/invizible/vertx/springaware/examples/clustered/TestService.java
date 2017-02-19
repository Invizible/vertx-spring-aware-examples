package com.github.invizible.vertx.springaware.examples.clustered;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alex Korobko
 */
@Service
public class TestService {

  @Autowired
  private Vertx vertx; // yes, you can inject Vertx instance as well. So you can access Vertx api in any Spring component.

  /**
   * Run some blocking code. It can be queering to DB or working with Vertx filesystem API or whatever you want.
   *
   * @param handler
   */
  public void getBlockingMessage(Handler<String> handler) {
    vertx.<String>executeBlocking(future -> {
        vertx.setTimer(3000,
          id -> future.complete("Hello from blocking code in Spring Service"));
      },
      result -> handler.handle(result.result())
    );
  }
}
