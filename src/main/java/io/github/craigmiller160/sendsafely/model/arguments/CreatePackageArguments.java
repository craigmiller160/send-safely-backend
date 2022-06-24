package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;

public record CreatePackageArguments(String apiKey, String apiSecret) implements Arguments {
  @Override
  public Action action() {
    return Action.CREATE_PACKAGE;
  }

  @Override
  public void validate() {
    DefaultArgumentValidator.validate(this);
  }
}
