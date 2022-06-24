package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import java.io.File;

public record AddFileArguments(
    String apiKey, String apiSecret, String packageId, String keyCode, String filePath)
    implements Arguments {
  @Override
  public Action action() {
    return Action.ADD_FILE;
  }

  @Override
  public void validate() {
    DefaultArgumentValidator.validate(this);
    if (packageId == null) {
      DefaultArgumentValidator.missing(ArgumentKey.PACKAGE_ID);
    }

    if (keyCode == null) {
      DefaultArgumentValidator.missing(ArgumentKey.KEY_CODE);
    }

    if (filePath == null) {
      DefaultArgumentValidator.missing(ArgumentKey.FILE_PATH);
    }

    final var file = new File(filePath);
    if (!file.exists() || !file.isFile()) {
      throw new RuntimeException("File path is invalid: %s".formatted(filePath));
    }
  }
}
