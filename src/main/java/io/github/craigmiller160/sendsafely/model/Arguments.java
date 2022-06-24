package io.github.craigmiller160.sendsafely.model;

import java.util.Set;
import lombok.NonNull;
import org.springframework.lang.Nullable;

public record Arguments(
    @Nullable String apiKey,
    @Nullable String apiSecret,
    @NonNull Set<String> filePaths,
    @NonNull Set<String> recipients) {
  public void validate() {
    if (apiKey == null) {
      throw new RuntimeException("Must provide 'apiKey' argument");
    }

    if (apiSecret == null) {
      throw new RuntimeException("Must provide 'apiSecret' argument");
    }

    if (filePaths.isEmpty()) {
      throw new RuntimeException("Must provide at least one file");
    }

    if (recipients.isEmpty()) {
      throw new RuntimeException("Must provide at least one recipient");
    }
  }
}
