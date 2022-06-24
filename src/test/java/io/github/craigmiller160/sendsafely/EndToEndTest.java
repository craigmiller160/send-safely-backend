package io.github.craigmiller160.sendsafely;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = TestContainerConfig.class)
@ExtendWith(SpringExtension.class)
public class EndToEndTest {
  private String apiKey;
  private String apiSecret;

  @BeforeEach
  public void setup() {
    System.out.println("KEY: " + System.getenv("SS_API_KEY"));
  }

  @Test
  public void createAndTearDownPackage() {
    throw new RuntimeException();
  }

  @Test
  public void createAndFinalizePackage() {
    throw new RuntimeException();
  }
}
