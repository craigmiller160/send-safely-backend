package io.github.craigmiller160.sendsafely.model;

public record ArgPair(ArgumentKey key, String value) {
  public static ArgPair fromArray(final String[] array) {
    if (array.length != 2) {
      throw new RuntimeException("Invalid argument. Must be formatted as 'key=value'");
    }
    return new ArgPair(ArgumentKey.valueOf(array[0]), array[1]);
  }
}
