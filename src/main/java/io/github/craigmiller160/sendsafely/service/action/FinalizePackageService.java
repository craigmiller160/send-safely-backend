package io.github.craigmiller160.sendsafely.service.action;

import io.github.craigmiller160.sendsafely.log.Logger;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.FinalizePackageArguments;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinalizePackageService implements ActionService {
  private final Logger logger;

  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {}

  private FinalizePackageArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final var extractedArguments =
        new FinalizePackageArguments(
            arguments.get(ArgumentKey.API_KEY),
            arguments.get(ArgumentKey.API_SECRET),
            arguments.get(ArgumentKey.PACKAGE_ID));
    extractedArguments.validate();
    return extractedArguments;
  }
}
