package io.github.craigmiller160.sendsafely;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {
  // TODO probably combine with application

  @Override
  public void run(final String[] args) throws Exception {
    System.out.println(Arrays.toString(args));
  }
}
