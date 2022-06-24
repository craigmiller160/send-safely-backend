package io.github.craigmiller160.sendsafely.service.action;

import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.CreatePackageArguments;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CreatePackageService implements ActionService {

  @Override
  public void perform(final Map<ArgumentKey, String> arguments) {
    final var createPackageArguments = extractArguments(arguments);
  }

  private CreatePackageArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final CreatePackageArguments extractedArguments =
        new CreatePackageArguments(
            arguments.get(ArgumentKey.API_KEY), arguments.get(ArgumentKey.API_SECRET));
    extractedArguments.validate();
    return extractedArguments;
  }
}
