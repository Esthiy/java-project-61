package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.LEVELS_QUANTITY;
import static hexlet.code.Engine.runGame;

public final class GcdGame {

    private static final int MIN_INT_TO_CALC = -100;
    private static final int MAX_INT_TO_CALC = 100;

    public static void startGame() {
        String rule = "Find the greatest common divisor of given numbers.";
        String[][] gameData = new String[LEVELS_QUANTITY][2];

        for (int i = 0; i < gameData.length; i++) {
            var random = new Random();
            var firstNumber = random.nextInt(MIN_INT_TO_CALC, MAX_INT_TO_CALC);
            var secondNumber = random.nextInt(MIN_INT_TO_CALC, MAX_INT_TO_CALC);

            String question = String.join(" ", String.valueOf(firstNumber), String.valueOf(secondNumber));
            int correctAnswer = calculateGcd(firstNumber, secondNumber);

            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(correctAnswer);
        }

        runGame(rule, gameData);
    }

    private static int calculateGcd(int a, int b) {
        int t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a);
    }
}
