package io.github.craigmiller160.sendsafely.service.action;

import com.sendsafely.SendSafely;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.AddRecipientArguments;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AddRecipientService implements ActionService {
  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {
    final var extractedArguments = extractArguments(arguments);
    final var sendSafely =
        new SendSafely(
            ActionService.SEND_SAFELY_URL,
            extractedArguments.apiKey(),
            extractedArguments.apiSecret());
    final var recipient =
        sendSafely.addRecipient(
            extractedArguments.packageId(), extractedArguments.recipientEmail());
    System.out.printf(
        "Added new recipient to SendSafely. Recipient ID: %s%n", recipient.getRecipientId());
  }

  private AddRecipientArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final var extractedArguments =
        new AddRecipientArguments(
            arguments.get(ArgumentKey.API_KEY), arguments.get(ArgumentKey.API_SECRET),
            arguments.get(ArgumentKey.PACKAGE_ID), arguments.get(ArgumentKey.RECIPIENT));
    extractedArguments.validate();
    return extractedArguments;
  }
}
