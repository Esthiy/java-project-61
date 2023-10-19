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

    public static void main(String[] args) {
        showMenuItem();
        selectMenuItem();
        SCANNER.close();
    }

    private static void showMenuItem() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
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
            case 1 -> Cli.getUsernameAndGreet();
            case 2 -> EvenGame.startGame();
            case 3 -> CalcGame.startGame();
            case 4 -> GcdGame.startGame();
            case 5 -> ProgressionGame.startGame();
            case 6 -> PrimeGame.startGame();
            case 0 -> {
                System.out.println("Good bye!");
                System.exit(0);
            }
            default -> throw new UnsupportedOperationException("Incorrect number was selected");
        }
    }
}
