package io.github.craigmiller160.sendsafely.service.action;

import io.github.craigmiller160.sendsafely.log.Logger;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinalizePackageService implements ActionService {
  private final Logger logger;

  @Override
  public void perform(Map<ArgumentKey, String> arguments) throws Exception {}
}
