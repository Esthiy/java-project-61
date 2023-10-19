package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.LEVELS_QUANTITY;
import static hexlet.code.Engine.runGame;

public final class EvenGame {
    public static void startGame() {

        String rule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] gameData = new String[LEVELS_QUANTITY][2];

        for (int i = 0; i < gameData.length; i++) {
            var number = new Random().nextInt();
            String correctAnswer = number % 2 == 0 ? "yes" : "no";

            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = correctAnswer;
        }

        runGame(rule, gameData);
    }
}
