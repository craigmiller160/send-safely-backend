package io.github.craigmiller160.sendsafely.log;

public interface Logger {
  void println(final String message);

  void printf(final String message, final Object... args);
}
