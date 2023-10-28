package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class App {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static final int EXIT_ID = 0;
    private static final int GREET_ID = 1;
    private static final int EVEN_ID = 2;
    private static final int CALC_ID = 3;
    private static final int GCD_ID = 4;
    private static final int PROGRESSION_ID = 5;
    private static final int PRIME_ID = 6;

    public static void main(String[] args) {
        showMenuItem();
        selectMenuItem();
        SCANNER.close();
    }

    private static void showMenuItem() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_ID + " - Greet");
        System.out.println(EVEN_ID + " - Even");
        System.out.println(CALC_ID + " - Calc");
        System.out.println(GCD_ID + " - GCD");
        System.out.println(PROGRESSION_ID + " - Progression");
        System.out.println(PRIME_ID + " - Prime");
        System.out.println(EXIT_ID + " - Exit");
    }

    private static void selectMenuItem() {
        int gameNumber = -1;
        while (gameNumber < 0) {
            try {
                gameNumber = SCANNER.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input was not recognized as a number!");
                showMenuItem();
                SCANNER.next();
            }
        }
        System.out.printf("Your choice: %s%n", gameNumber);

        switch (gameNumber) {
            case GREET_ID -> Cli.getUsernameAndGreet();
            case EVEN_ID -> Even.startGame();
            case CALC_ID -> Calc.startGame();
            case GCD_ID -> Gcd.startGame();
            case PROGRESSION_ID -> Progression.startGame();
            case PRIME_ID -> Prime.startGame();
            case EXIT_ID -> System.out.println("Good bye!");
            default -> throw new UnsupportedOperationException("Incorrect number was selected");
        }
    }
}
