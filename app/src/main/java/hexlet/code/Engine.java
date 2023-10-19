package hexlet.code;

import static hexlet.code.App.SCANNER;

public final class Engine {

    public static final int LEVELS_QUANTITY = 3;
    private static String userName;

    public static void greetUser() {
        userName = Cli.getUsernameAndGreet();
    }

    public static void showGameRules(String rules) {
        System.out.println(rules);
    }

    public static void showQuestion(String question) {
        System.out.printf("Question: %s%n", question);
    }

    public static void checkUserAnswer(String correctAnswer) {
        var guess = SCANNER.next();
        if (guess.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", guess, correctAnswer);
            System.out.printf("Let's try again, %s!%n", userName);
            System.exit(0);
        }
    }

    public static void showSuccessMessage() {
        System.out.printf("Congratulations, %s!%n", userName);
    }
}
