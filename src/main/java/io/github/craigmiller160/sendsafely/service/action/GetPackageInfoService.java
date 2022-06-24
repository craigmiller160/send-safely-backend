package io.github.craigmiller160.sendsafely.service.action;

import com.sendsafely.SendSafely;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.GetPackageInfoArguments;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class GetPackageInfoService implements ActionService {
  @Override
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {
    final var extractedArguments = extractArguments(arguments);
    final var sendSafely =
        new SendSafely(
            ActionService.SEND_SAFELY_URL,
            extractedArguments.apiKey(),
            extractedArguments.apiSecret());
    final var packageInfo = sendSafely.getPackageInformation(extractedArguments.packageId());
    System.out.printf("Getting Info for SendSafely package: %s%n", packageInfo.getPackageId());
    System.out.println("Files");
    packageInfo
        .getFiles()
        .forEach(file -> System.out.printf("  %s = %s%n", file.getFileId(), file.getFileName()));
    System.out.println("Recipients");
    packageInfo
        .getRecipients()
        .forEach(
            recipient ->
                System.out.printf("  %s = %s%n", recipient.getRecipientId(), recipient.getEmail()));
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
