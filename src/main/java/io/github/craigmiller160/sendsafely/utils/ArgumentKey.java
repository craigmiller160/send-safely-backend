package io.github.craigmiller160.sendsafely.utils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ArgumentKey {
  API_KEY("apiKey"),
  API_SECRET("apiSecret"),
  FILE_PATH("filePath"),
  RECIPIENT("recipient");

  private final String rawArgument;

  public static ArgumentKey fromRawArgument(final String rawArgument) {
    return switch (rawArgument) {
      case "apiKey" -> API_KEY;
      case "apiSecret" -> API_SECRET;
      case "filePath" -> FILE_PATH;
      case "recipient" -> RECIPIENT;
      default -> throw new RuntimeException("Invalid raw argument key: %s".formatted(rawArgument));
    };
  }
}
