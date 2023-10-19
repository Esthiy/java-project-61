package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.LEVELS_QUANTITY;
import static hexlet.code.Engine.runGame;

public final class CalcGame {

    private static final char[] AVAILABLE_OPERATIONS = {'+', '-', '*'};
    private static final int MIN_INT_TO_CALC = 0;
    private static final int MAX_INT_TO_CALC = 100;

    public static void startGame() {

        String rule = "What is the result of the expression?";
        String[][] gameData = new String[LEVELS_QUANTITY][2];

        for (int i = 0; i < gameData.length; i++) {
            var random = new Random();
            var firstNumber = random.nextInt(MIN_INT_TO_CALC, MAX_INT_TO_CALC);
            var secondNumber = random.nextInt(MIN_INT_TO_CALC, MAX_INT_TO_CALC);
            var operation = AVAILABLE_OPERATIONS[random.nextInt(0, AVAILABLE_OPERATIONS.length)];

            String question = String.join(" ", String.valueOf(firstNumber),
                    String.valueOf(operation), String.valueOf(secondNumber));
            int correctAnswer = calculateCorrectResult(firstNumber, secondNumber, operation);

            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(correctAnswer);
        }

        runGame(rule, gameData);
    }

    private static int calculateCorrectResult(int a, int b, char operation) {
        switch (operation) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                return a * b;
            }
            default -> throw new UnsupportedOperationException("Operation was not implemented");
        }
    }
}
