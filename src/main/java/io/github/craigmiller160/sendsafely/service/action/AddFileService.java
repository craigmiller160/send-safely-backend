package io.github.craigmiller160.sendsafely.service.action;

import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.AddFileArguments;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AddFileService implements ActionService {
  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {
    final var extractedArguments = extractArguments(arguments);
  }

  private AddFileArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final AddFileArguments extractedArguments =
        new AddFileArguments(
            arguments.get(ArgumentKey.API_KEY), arguments.get(ArgumentKey.API_SECRET),
            arguments.get(ArgumentKey.PACKAGE_ID), arguments.get(ArgumentKey.FILE_PATH));
    extractedArguments.validate();
    return extractedArguments;
  }
}
