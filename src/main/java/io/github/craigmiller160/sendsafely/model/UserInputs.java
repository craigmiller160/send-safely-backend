package io.github.craigmiller160.sendsafely.model;

import java.util.Set;

public record UserInputs(
    String apiKey, String apiSecret, Set<String> filePaths, Set<String> recipients) {}
