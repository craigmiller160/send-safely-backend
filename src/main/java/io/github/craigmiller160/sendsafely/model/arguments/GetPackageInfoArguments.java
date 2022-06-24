package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;

public record GetPackageInfoArguments(String apiKey, String apiSecret, String packageId)
    implements Arguments {
  @Override
  public Action action() {
    return Action.GET_PACKAGE_INFO;
  }

  @Override
  public void validate() {
    DefaultArgumentValidator.validate(this);
    if (packageId == null) {
      throw new RuntimeException("Must include %s".formatted(ArgumentKey.PACKAGE_ID));
    }
  }
}
