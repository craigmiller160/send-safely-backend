package io.github.craigmiller160.sendsafely.model.arguments;

import io.github.craigmiller160.sendsafely.model.Action;

public interface Arguments {
  String apiKey();

  String apiSecret();

  Action action();

  void validate();
}
