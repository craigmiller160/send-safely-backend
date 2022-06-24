package io.github.craigmiller160.sendsafely.service;

import io.github.craigmiller160.sendsafely.model.UserInputs;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class UserInputService {
  public UserInputs collectUserInputs() {
    try (final Scanner scanner = new Scanner(System.in)) {
      System.out.print("Send Safely API Key: ");
      final String apiKey = scanner.nextLine();
      System.out.printf("|%s|", apiKey);
    }

    return null;
  }
}
