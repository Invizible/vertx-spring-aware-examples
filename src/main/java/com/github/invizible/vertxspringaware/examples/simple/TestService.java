package com.github.invizible.vertxspringaware.examples.simple;

import org.springframework.stereotype.Service;

/**
 * @author Alex
 */
@Service
public class TestService {
  public String getMessage() {
    return "Hello, World!";
  }
}
