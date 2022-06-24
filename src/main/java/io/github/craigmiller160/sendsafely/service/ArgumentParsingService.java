package io.github.craigmiller160.sendsafely.service;

import io.github.craigmiller160.sendsafely.model.Action;
import io.github.craigmiller160.sendsafely.model.ArgPair;
import io.github.craigmiller160.sendsafely.model.ArgumentKey;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ArgumentParsingService {
  public Map<ArgumentKey, String> parseArguments(final String[] args) {
    return Arrays.stream(args)
        .map(arg -> arg.split("="))
        .map(ArgPair::fromArray)
        .collect(Collectors.toMap(ArgPair::key, ArgPair::value));
  }

  public Action getAction(final Map<ArgumentKey, String> arguments) {
    final String action =
        Optional.ofNullable(arguments.get(ArgumentKey.ACTION))
            .orElseThrow(
                () -> new RuntimeException("Must specify the %s".formatted(ArgumentKey.ACTION)));
    try {
      return Action.valueOf(action);
    } catch (IllegalArgumentException ex) {
      throw new RuntimeException("Invalid action: %s".formatted(action));
    }
  }
}
