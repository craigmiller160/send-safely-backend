package io.github.craigmiller160.sendsafely.service.action;

import com.sendsafely.SendSafely;
import com.sendsafely.file.DefaultFileManager;
import io.github.craigmiller160.sendsafely.log.Logger;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import io.github.craigmiller160.sendsafely.model.arguments.AddFileArguments;
import io.github.craigmiller160.sendsafely.utils.ProgressCallback;
import java.io.File;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddFileService implements ActionService {
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
    final var fileManager = new DefaultFileManager(new File(extractedArguments.filePath()));
    final var sendSafelyFile =
        sendSafely.encryptAndUploadFile(
            packageInfo.getPackageId(),
            extractedArguments.keyCode(),
            fileManager,
            new ProgressCallback(logger));
    logger.printf(
        "Successfully uploaded file to SendSafely. File ID: %s%n", sendSafelyFile.getFileId());
  }

  private AddFileArguments extractArguments(final Map<ArgumentKey, String> arguments) {
    final var extractedArguments =
        new AddFileArguments(
            arguments.get(ArgumentKey.API_KEY),
            arguments.get(ArgumentKey.API_SECRET),
            arguments.get(ArgumentKey.PACKAGE_ID),
            arguments.get(ArgumentKey.KEY_CODE),
            arguments.get(ArgumentKey.FILE_PATH));
    extractedArguments.validate();
    return extractedArguments;
  }
}
