package io.github.craigmiller160.sendsafely;

import io.github.craigmiller160.sendsafely.service.ArgumentParsingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {
  // TODO probably combine with application
  private final ArgumentParsingService argumentParsingService;

  @Override
  public void run(final String[] args) throws Exception {
    final var parsedArguments = argumentParsingService.parseArguments(args);
  }
}
