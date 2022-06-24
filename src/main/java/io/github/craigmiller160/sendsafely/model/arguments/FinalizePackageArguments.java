package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;

public record FinalizePackageArguments(String apiKey, String apiSecret, String packageId)
    implements Arguments {
  @Override
  public Action action() {
    return Action.FINALIZE_PACKAGE;
  }

  @Override
  public void validate() {
    DefaultArgumentValidator.validate(this);
    if (packageId == null) {
      DefaultArgumentValidator.missing(ArgumentKey.PACKAGE_ID);
    }
  }
}
