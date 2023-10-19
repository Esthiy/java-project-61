package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.LEVELS_QUANTITY;
import static hexlet.code.Engine.checkUserAnswer;
import static hexlet.code.Engine.greetUser;
import static hexlet.code.Engine.showGameRules;
import static hexlet.code.Engine.showQuestion;
import static hexlet.code.Engine.showSuccessMessage;

public final class CalcGame {

    private static final char[] AVAILABLE_OPERATIONS = {'+', '-', '*'};

    public static void startGame() {
        greetUser();

        showGameRules("What is the result of the expression?");

        for (int i = 0; i < LEVELS_QUANTITY; i++) {
            var random = new Random();
            var firstNumber = random.nextInt(0, 100);
            var secondNumber = random.nextInt(0, 100);
            var operation = AVAILABLE_OPERATIONS[random.nextInt(0, AVAILABLE_OPERATIONS.length)];

            String question = String.join(" ", String.valueOf(firstNumber),
                    String.valueOf(operation), String.valueOf(secondNumber));
            int correctAnswer = calculateCorrectResult(firstNumber, secondNumber, operation);

            showQuestion(question);

            checkUserAnswer(String.valueOf(correctAnswer));
        }

        showSuccessMessage();
    }

    private static int calculateCorrectResult(int firstNumber, int secondNumber, char operation) {
        switch (operation) {
            case '+' -> {
                return firstNumber + secondNumber;
            }
            case '-' -> {
                return firstNumber - secondNumber;
            }
            case '*' -> {
                return firstNumber * secondNumber;
            }
            default -> throw new UnsupportedOperationException("Operation was not implemented");
        }
    }
}
