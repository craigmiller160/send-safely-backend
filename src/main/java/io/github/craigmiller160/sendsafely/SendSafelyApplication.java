package io.github.craigmiller160.sendsafely;

import io.github.craigmiller160.sendsafely.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor
@Profile("!test")
public class SendSafelyApplication implements CommandLineRunner {
  private final ApplicationService applicationService;

  public static void main(final String[] args) {
    SpringApplication.run(SendSafelyApplication.class, args);
  }

  @Override
  public void run(final String[] args) throws Exception {
    applicationService.runApplication(args);
  }
}
