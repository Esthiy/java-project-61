package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Objects;
import java.util.Random;

import static hexlet.code.App.SCANNER;

public class EvenGame {
    private static final int REQUIRED_SUCCESS_ATTEMPTS = 3;

    public static void startGame(String username) {
        if (Objects.isNull(username)) {
            username = Cli.getUsernameAndGreet();
        }
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var counter = 0;
        while (counter < REQUIRED_SUCCESS_ATTEMPTS) {
            var number = new Random().nextInt();
            String correctAnswer = number % 2 == 0 ? "yes" : "no";

            System.out.printf("Question: %s%n", number);
            var guess = SCANNER.next();
            if (guess.equals(correctAnswer)) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", guess, correctAnswer);
                System.out.printf("Let's try again, %s!%n", username);
                break;
            }
        }
        if (counter == REQUIRED_SUCCESS_ATTEMPTS) {
            System.out.printf("Congratulations, %s!%n", username);
        }
    }
}
