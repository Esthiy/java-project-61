package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class App {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static final int EXIT_ITEM_MENU_NUMBER = 0;
    private static final int GREET_ITEM_MENU_NUMBER = 1;
    private static final int EVEN_ITEM_MENU_NUMBER = 2;
    private static final int CALC_ITEM_MENU_NUMBER = 3;
    private static final int GCD_ITEM_MENU_NUMBER = 4;
    private static final int PROGRESSION_ITEM_MENU_NUMBER = 5;
    private static final int PRIME_ITEM_MENU_NUMBER = 6;

    public static void main(String[] args) {
        showMenuItem();
        selectMenuItem();
        SCANNER.close();
    }

    private static void showMenuItem() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_ITEM_MENU_NUMBER + " - Greet");
        System.out.println(EVEN_ITEM_MENU_NUMBER + " - Even");
        System.out.println(CALC_ITEM_MENU_NUMBER + " - Calc");
        System.out.println(GCD_ITEM_MENU_NUMBER + " - GCD");
        System.out.println(PROGRESSION_ITEM_MENU_NUMBER + " - Progression");
        System.out.println(PRIME_ITEM_MENU_NUMBER + " - Prime");
        System.out.println(EXIT_ITEM_MENU_NUMBER + " - Exit");
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
            case GREET_ITEM_MENU_NUMBER -> Cli.getUsernameAndGreet();
            case EVEN_ITEM_MENU_NUMBER -> EvenGame.startGame();
            case CALC_ITEM_MENU_NUMBER -> CalcGame.startGame();
            case GCD_ITEM_MENU_NUMBER -> GcdGame.startGame();
            case PROGRESSION_ITEM_MENU_NUMBER -> ProgressionGame.startGame();
            case PRIME_ITEM_MENU_NUMBER -> PrimeGame.startGame();
            case EXIT_ITEM_MENU_NUMBER -> {
                System.out.println("Good bye!");
                System.exit(0);
            }
            default -> throw new UnsupportedOperationException("Incorrect number was selected");
        }
    }
}
