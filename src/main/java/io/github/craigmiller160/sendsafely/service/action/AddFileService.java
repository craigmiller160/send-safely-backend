package io.github.craigmiller160.sendsafely.service.action;

import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.AddFileArguments;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AddFileService implements ActionService {
  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {}

  private AddFileArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    return null;
  }
}
