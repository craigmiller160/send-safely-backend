package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import java.io.File;

public record AddFileArguments(String apiKey, String apiSecret, String packageId, String filePath)
    implements Arguments {
  @Override
  public Action action() {
    return Action.ADD_FILE;
  }

  @Override
  public void validate() {
    DefaultArgumentValidator.validate(this);
    if (packageId == null) {
      throw new RuntimeException("Must include %s".formatted(ArgumentKey.PACKAGE_ID));
    }

    if (filePath == null) {
      throw new RuntimeException("Must include %s".formatted(ArgumentKey.FILE_PATH));
    }

    final var file = new File(filePath);
    if (!file.exists() || !file.isFile()) {
      throw new RuntimeException("File path is invalid: %s".formatted(filePath));
    }
  }
}
