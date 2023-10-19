package hexlet.code;

import static hexlet.code.App.SCANNER;

public final class Cli {

    public static String getUsernameAndGreet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = SCANNER.next();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
