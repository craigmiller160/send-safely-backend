package io.github.craigmiller160.sendsafely.service.action;

import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import java.util.Map;

public interface ActionService {
  void perform(final Map<ArgumentKey, String> arguments);
}
