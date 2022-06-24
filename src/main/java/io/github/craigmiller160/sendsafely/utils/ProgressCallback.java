package io.github.craigmiller160.sendsafely.utils;

import com.sendsafely.ProgressInterface;
import io.github.craigmiller160.sendsafely.log.Logger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProgressCallback implements ProgressInterface {
  private final Logger logger;

  @Override
  public void updateProgress(final String fileId, final double progress) {
    logger.printf("Upload progress for file %s: %f%n", fileId, progress);
  }

  @Override
  public void gotFileId(final String fileId) {
    logger.printf("Received file id: %s%n", fileId);
  }
}
