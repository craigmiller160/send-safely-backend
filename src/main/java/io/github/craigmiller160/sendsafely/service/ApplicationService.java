package io.github.craigmiller160.sendsafely.service;

import io.github.craigmiller160.sendsafely.service.action.ActionServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {
  private final ArgumentParsingService argumentParsingService;
  private final ActionServiceManager actionServiceManager;

  public void runApplication(final String[] args) throws Exception {
    final var parsedArguments = argumentParsingService.parseArguments(args);
    final var action = argumentParsingService.getAction(parsedArguments);
    final var actionService = actionServiceManager.getActionService(action);
    actionService.perform(parsedArguments);
  }
}
