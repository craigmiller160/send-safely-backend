package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;

public record AddRecipientArguments(
    String apiKey, String apiSecret, String packageId, String recipientEmail) implements Arguments {
  @Override
  public Action action() {
    return Action.ADD_RECIPIENT;
  }

  @Override
  public void validate() {
    DefaultArgumentValidator.validate(this);
    if (packageId == null) {
      DefaultArgumentValidator.missing(ArgumentKey.PACKAGE_ID);
    }

    if (recipientEmail == null) {
      DefaultArgumentValidator.missing(ArgumentKey.RECIPIENT);
    }
  }
}
