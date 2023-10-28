package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.LEVELS_QUANTITY;
import static hexlet.code.Engine.runGame;

public final class Progression {

    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final int MAX_PROGRESSION_SIZE = 11;
    private static final int MIN_START_NUMBER = -100;
    private static final int MAX_START_NUMBER = 100;
    private static final int MIN_INTERVAL = -10;
    private static final int MAX_INTERVAL = 11;
    private static final Random RANDOM = new Random();

    public static void startGame() {
        String rule = "What number is missing in the progression?";
        String[][] gameData = new String[LEVELS_QUANTITY][2];

        for (int i = 0; i < gameData.length; i++) {

            var progression = generateProgression();
            int correctAnswer = progression[RANDOM.nextInt(0, progression.length)];
            String correctAnswerStr = String.valueOf(correctAnswer);

            var questionBuilder = new StringBuilder();
            for (int number : progression) {
                if (number == correctAnswer) {
                    questionBuilder.append("..");
                } else {
                    questionBuilder.append(number);
                }
                questionBuilder.append(" ");
            }

            String question = questionBuilder.toString().trim();

            gameData[i][0] = question;
            gameData[i][1] = correctAnswerStr;
        }

        runGame(rule, gameData);
    }

    private static int[] generateProgression() {
        var progressionSize = RANDOM.nextInt(MIN_PROGRESSION_SIZE, MAX_PROGRESSION_SIZE);
        var start = RANDOM.nextInt(MIN_START_NUMBER, MAX_START_NUMBER);
        var interval = RANDOM.nextInt(MIN_INTERVAL, MAX_INTERVAL);
        while (interval == 0) {
            interval = RANDOM.nextInt(MIN_INTERVAL, MAX_INTERVAL);
        }

        var result = new int[progressionSize];
        result[0] = start;

        for (int i = 1; i < progressionSize; i++) {
            result[i] = result[i - 1] + interval;
        }

        return result;
    }
}
