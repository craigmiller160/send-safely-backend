package io.github.craigmiller160.sendsafely.log;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class AppLogger implements Logger {
  @Override
  public void println(final String message) {
    System.out.println(message);
  }

  @Override
  public void printf(final String message, final Object... args) {
    System.out.printf(message, args);
  }
}
