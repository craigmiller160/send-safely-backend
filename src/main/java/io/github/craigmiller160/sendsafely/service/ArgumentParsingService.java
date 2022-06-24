package io.github.craigmiller160.sendsafely.service;

import io.github.craigmiller160.sendsafely.model.Arguments;
import io.github.craigmiller160.sendsafely.utils.ArgumentKey;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import org.apache.commons.collections4.SetUtils;
import org.springframework.stereotype.Service;

@Service
public class ArgumentParsingService {
  public Arguments parseArguments(final String[] args) {
    final Arguments arguments =
        Arrays.stream(args)
            .map(arg -> arg.split("="))
            .map(ArgPair::fromArray)
            .map(this::argPairToArguments)
            .reduce(new Arguments(null, null, Set.of(), Set.of()), this::argumentsReducer);
    arguments.validate();
    return arguments;
  }

  private Arguments argumentsReducer(final Arguments argumentsA, final Arguments argumentsB) {
    final String apiKey = Optional.ofNullable(argumentsB.apiKey()).orElse(argumentsA.apiKey());
    final String apiSecret =
        Optional.ofNullable(argumentsB.apiSecret()).orElse(argumentsA.apiKey());
    final Set<String> filePaths = SetUtils.union(argumentsA.filePaths(), argumentsB.filePaths());
    final Set<String> recipients = SetUtils.union(argumentsA.recipients(), argumentsB.recipients());
    return new Arguments(apiKey, apiSecret, filePaths, recipients);
  }

  private Arguments argPairToArguments(final ArgPair argPair) {
    return switch (argPair.key()) {
      case API_KEY -> new Arguments(argPair.value(), null, Set.of(), Set.of());
      case API_SECRET -> new Arguments(null, argPair.value(), Set.of(), Set.of());
      case FILE_PATH -> new Arguments(null, null, Set.of(argPair.value()), Set.of());
      case RECIPIENT -> new Arguments(null, null, Set.of(), Set.of());
    };
  }

  private record ArgPair(ArgumentKey key, String value) {
    public static ArgPair fromArray(final String[] array) {
      if (array.length != 2) {
        throw new RuntimeException("Invalid argument. Must be formatted as 'key=value'");
      }
      return new ArgPair(ArgumentKey.fromRawArgument(array[0]), array[1]);
    }
  }
}
