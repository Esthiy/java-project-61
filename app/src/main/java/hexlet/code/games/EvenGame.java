package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.LEVELS_QUANTITY;
import static hexlet.code.Engine.checkUserAnswer;
import static hexlet.code.Engine.greetUser;
import static hexlet.code.Engine.showGameRules;
import static hexlet.code.Engine.showQuestion;
import static hexlet.code.Engine.showSuccessMessage;

public final class EvenGame {

    public static void startGame() {
        greetUser();

        showGameRules("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < LEVELS_QUANTITY; i++) {
            var number = new Random().nextInt();
            String correctAnswer = number % 2 == 0 ? "yes" : "no";

            showQuestion(String.valueOf(number));

            checkUserAnswer(correctAnswer);
        }

        showSuccessMessage();
    }
}
