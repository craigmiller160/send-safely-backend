package io.github.craigmiller160.sendsafely.service.action;

import com.sendsafely.SendSafely;
import io.github.craigmiller160.sendsafely.log.Logger;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.CreatePackageArguments;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePackageService implements ActionService {
  private final Logger logger;

  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {
    final var extractedArguments = extractArguments(arguments);
    final var sendSafely =
        new SendSafely(
            ActionService.SEND_SAFELY_URL,
            extractedArguments.apiKey(),
            extractedArguments.apiSecret());
    final var sendSafelyPackage = sendSafely.createPackage();
    logger.printf(
        "Created new SendSafely Package. ID: %s KeyCode: %s%n",
        sendSafelyPackage.getPackageId(), sendSafelyPackage.getKeyCode());
  }

  private CreatePackageArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final var extractedArguments =
        new CreatePackageArguments(
            arguments.get(ArgumentKey.API_KEY), arguments.get(ArgumentKey.API_SECRET));
    extractedArguments.validate();
    return extractedArguments;
  }
}
