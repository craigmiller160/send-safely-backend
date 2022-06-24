package io.github.craigmiller160.sendsafely.log;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Getter
@Component
@Profile("test")
public class TestLogger implements Logger {
  private final List<String> messages = new ArrayList<>();

  public void reset() {
    messages.clear();
  }

  @Override
  public void println(final String message) {
    messages.add(message);
  }

  @Override
  public void printf(final String message, final Object... args) {
    messages.add(message.formatted(args));
  }
}
