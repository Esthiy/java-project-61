package hexlet.code;

import static hexlet.code.App.SCANNER;

public final class Engine {

    public static final int LEVELS_QUANTITY = 3;

    public static void runGame(String rule, String[][] gameData) {
        String userName = Cli.getUsernameAndGreet();

        System.out.println(rule);

        for (int i = 0; i < LEVELS_QUANTITY; i++) {
            System.out.printf("Question: %s%n", gameData[i][0]);

            var guess = SCANNER.next();
            if (guess.equalsIgnoreCase(gameData[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", guess, gameData[i][1]);
                System.out.printf("Let's try again, %s!%n", userName);
                System.exit(0);
            }
        }

        System.out.printf("Congratulations, %s!%n", userName);
    }
}
