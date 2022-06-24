package io.github.craigmiller160.sendsafely.service.action;

import io.github.craigmiller160.sendsafely.model.Action;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActionServiceManager {
  private final CreatePackageService createPackageService;
  private final AddFileService addFileService;
  private final GetPackageInfoService getPackageInfoService;

  public ActionService getActionService(final Action action) {
    return switch (action) {
      case CREATE_PACKAGE -> createPackageService;
      case ADD_FILE -> addFileService;
      case GET_PACKAGE_INFO -> getPackageInfoService;
      default -> throw new RuntimeException();
    };
  }
}
