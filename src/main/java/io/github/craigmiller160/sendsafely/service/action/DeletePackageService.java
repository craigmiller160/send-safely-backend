package io.github.craigmiller160.sendsafely.service.action;

import com.sendsafely.SendSafely;
import io.github.craigmiller160.sendsafely.log.Logger;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.DeletePackageArguments;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePackageService implements ActionService {
  private final Logger logger;

  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {
    final var extractedArguments = extractArguments(arguments);
    final var sendSafely =
        new SendSafely(
            ActionService.SEND_SAFELY_URL,
            extractedArguments.apiKey(),
            extractedArguments.apiSecret());

    sendSafely.deleteTempPackage(extractedArguments.packageId());
    logger.printf("Successfully deleted package %s%n", extractedArguments.packageId());
  }

  private DeletePackageArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final var extractedArguments =
        new DeletePackageArguments(
            arguments.get(ArgumentKey.API_KEY),
            arguments.get(ArgumentKey.API_SECRET),
            arguments.get(ArgumentKey.PACKAGE_ID));
    extractedArguments.validate();
    return extractedArguments;
  }
}
