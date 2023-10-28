package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.LEVELS_QUANTITY;
import static hexlet.code.Engine.runGame;

public final class Prime {
    private static final int MIN_NUMBER_TO_CHECK = -100;
    private static final int MAX_NUMBER_TO_CHECK = 100;

    public static void startGame() {

        String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] gameData = new String[LEVELS_QUANTITY][2];

        for (int i = 0; i < gameData.length; i++) {
            var number = new Random().nextInt(MIN_NUMBER_TO_CHECK, MAX_NUMBER_TO_CHECK);
            String correctAnswer = isPrime(number) ? "yes" : "no";

            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = correctAnswer;
        }

        runGame(rule, gameData);
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if ((number % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
