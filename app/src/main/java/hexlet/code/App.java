package hexlet.code;

import hexlet.code.games.EvenGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static boolean running = true;

    public static String userName;

    public static void main(String[] args) {
        while (running) {
            showMenuItem();
            selectMenuItem();
        }
        SCANNER.close();
    }

    private static void showMenuItem() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
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

//        String username;
        switch (gameNumber) {
            case 1 -> {
                userName = Cli.getUsernameAndGreet();
                EvenGame.startGame(userName);
            }
            case 2 -> EvenGame.startGame(userName);
            case 0 -> {
                System.out.println("Good bye!");
                running = false;
            }
            default -> throw new UnsupportedOperationException("Incorrect number was selected");
        }
    }
}
