package io.github.craigmiller160.sendsafely.service.action;

import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import java.util.Map;

public interface ActionService {
  public static final String SEND_SAFELY_URL = "https://app.sendsafely.com";

  void perform(final Map<ArgumentKey, String> arguments) throws Exception;
}
