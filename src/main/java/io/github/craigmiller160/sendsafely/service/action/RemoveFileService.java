package io.github.craigmiller160.sendsafely.service.action;

import com.sendsafely.SendSafely;
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
  public void perform(final Map<ArgumentKey, String> arguments) throws Exception {
    final var extractedArguments = extractArguments(arguments);
    final var sendSafely =
        new SendSafely(
            ActionService.SEND_SAFELY_URL,
            extractedArguments.apiKey(),
            extractedArguments.apiSecret());
    final var packageInfo = sendSafely.getPackageInformation(extractedArguments.packageId());
    sendSafely.deleteFile(
        packageInfo.getPackageId(), packageInfo.getRootDirectoryId(), extractedArguments.ssId());
    logger.println("File successfully removed");
  }

  private RemoveFileArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final var extractedArguments =
        new RemoveFileArguments(
            arguments.get(ArgumentKey.API_KEY), arguments.get(ArgumentKey.API_SECRET),
            arguments.get(ArgumentKey.PACKAGE_ID), arguments.get(ArgumentKey.SS_ID));
    extractedArguments.validate();
    return extractedArguments;
  }
}
