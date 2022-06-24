package io.github.craigmiller160.sendsafely;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {
  @Override
  public void run(String... args) throws Exception {
    System.out.println("Hello Universe");
  }
}
