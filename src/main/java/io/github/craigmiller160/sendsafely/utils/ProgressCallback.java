package io.github.craigmiller160.sendsafely.utils;

import com.sendsafely.ProgressInterface;

public class ProgressCallback implements ProgressInterface {
  @Override
  public void updateProgress(final String fileId, final double progress) {
    System.out.printf("Upload progress for file %s: %f%n", fileId, progress);
  }

  @Override
  public void gotFileId(final String fileId) {
    System.out.printf("Received file id: %s%n", fileId);
  }
}
