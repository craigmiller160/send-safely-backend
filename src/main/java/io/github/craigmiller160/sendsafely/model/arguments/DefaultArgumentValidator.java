package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultArgumentValidator {
  public static void validate(final Arguments arguments) {
    if (arguments.apiKey() == null) {
      throw new RuntimeException("Must include %s".formatted(ArgumentKey.API_KEY.name()));
    }

    if (arguments.apiSecret() == null) {
      throw new RuntimeException("Must include %s".formatted(ArgumentKey.API_SECRET.name()));
    }

    if (arguments.action() == null) {
      throw new RuntimeException("Must include %s".formatted(ArgumentKey.ACTION.name()));
    }
  }
}
