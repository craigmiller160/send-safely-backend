package io.github.craigmiller160.sendsafely.service.action;

import com.sendsafely.SendSafely;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.CreatePackageArguments;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CreatePackageService implements ActionService {

  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {
    final var extractedArguments = extractArguments(arguments);
    final var sendSafely =
        new SendSafely(
            ActionService.SEND_SAFELY_URL,
            extractedArguments.apiKey(),
            extractedArguments.apiSecret());
    final var sendSafelyPackage = sendSafely.createPackage();
    System.out.printf(
        "Created new SendSafely Package with ID: %s%n", sendSafelyPackage.getPackageId());
  }

  private CreatePackageArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final var extractedArguments =
        new CreatePackageArguments(
            arguments.get(ArgumentKey.API_KEY), arguments.get(ArgumentKey.API_SECRET));
    extractedArguments.validate();
    return extractedArguments;
  }
}
