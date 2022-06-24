package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultArgumentValidator {
  public static void validate(final Arguments arguments) {
    if (arguments.apiKey() == null) {
      missing(ArgumentKey.API_KEY);
    }

    if (arguments.apiSecret() == null) {
      missing(ArgumentKey.API_SECRET);
    }

    if (arguments.action() == null) {
      missing(ArgumentKey.ACTION);
    }
  }

  public static void missing(final ArgumentKey argumentKey) {
    throw new RuntimeException("Must include %s".formatted(argumentKey.name()));
  }
}
