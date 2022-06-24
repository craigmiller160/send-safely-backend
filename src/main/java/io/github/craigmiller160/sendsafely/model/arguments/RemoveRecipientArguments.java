package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;

public record RemoveRecipientArguments(
    String apiKey, String apiSecret, String packageId, String ssId) implements Arguments {
  @Override
  public Action action() {
    return Action.REMOVE_RECIPIENT;
  }

  @Override
  public void validate() {
    DefaultArgumentValidator.validate(this);
    if (packageId == null) {
      DefaultArgumentValidator.missing(ArgumentKey.PACKAGE_ID);
    }
    if (ssId == null) {
      DefaultArgumentValidator.missing(ArgumentKey.SS_ID);
    }
  }
}
