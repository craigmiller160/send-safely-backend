package io.github.craigmiller160.sendsafely.service.action;

import io.github.craigmiller160.sendsafely.log.Logger;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.RemoveFileArguments;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveFileService implements ActionService {
  private final Logger logger;

  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {}

  private RemoveFileArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final var extractedArguments =
        new RemoveFileArguments(
            arguments.get(ArgumentKey.API_KEY), arguments.get(ArgumentKey.API_SECRET),
            arguments.get(ArgumentKey.PACKAGE_ID), arguments.get(ArgumentKey.SS_ID));
    extractedArguments.validate();
    return extractedArguments;
  }
}
