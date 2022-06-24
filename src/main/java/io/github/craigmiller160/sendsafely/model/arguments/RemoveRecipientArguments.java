package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;

public record RemoveRecipientArguments(String apiKey, String apiSecret, String ssId)
    implements Arguments {
  @Override
  public Action action() {
    return Action.REMOVE_RECIPIENT;
  }

  @Override
  public void validate() {
    DefaultArgumentValidator.validate(this);
    if (ssId == null) {
      DefaultArgumentValidator.missing(ArgumentKey.SS_ID);
    }
  }
}
