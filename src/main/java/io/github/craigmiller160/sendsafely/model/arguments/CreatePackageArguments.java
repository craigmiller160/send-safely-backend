package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;

public record CreatePackageArguments(String apiKey, String apiSecret, Action action)
    implements Arguments {
  @Override
  public void validate() {}
}
