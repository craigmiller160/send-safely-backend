package io.github.craigmiller160.sendsafely.service.action;

import com.sendsafely.SendSafely;
import io.github.craigmiller160.sendsafely.log.Logger;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.GetPackageInfoArguments;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPackageInfoService implements ActionService {
  private final Logger logger;

  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {
    final var extractedArguments = extractArguments(arguments);
    final var sendSafely =
        new SendSafely(
            ActionService.SEND_SAFELY_URL,
            extractedArguments.apiKey(),
            extractedArguments.apiSecret());
    final var packageInfo = sendSafely.getPackageInformation(extractedArguments.packageId());
    logger.printf("Getting Info for SendSafely package: %s%n", packageInfo.getPackageId());
    logger.printf("Files (%d)%n", packageInfo.getFiles().size());
    packageInfo
        .getFiles()
        .forEach(file -> logger.printf("  %s = %s%n", file.getFileId(), file.getFileName()));
    logger.printf("Recipients (%d)%n", packageInfo.getRecipients().size());
    packageInfo
        .getRecipients()
        .forEach(
            recipient ->
                logger.printf("  %s = %s%n", recipient.getRecipientId(), recipient.getEmail()));
  }

  private GetPackageInfoArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final var extractedArguments =
        new GetPackageInfoArguments(
            arguments.get(ArgumentKey.API_KEY),
            arguments.get(ArgumentKey.API_SECRET),
            arguments.get(ArgumentKey.PACKAGE_ID));
    extractedArguments.validate();
    return extractedArguments;
  }
}
