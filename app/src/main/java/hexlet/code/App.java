package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");
        String choice = Engine.getChoice();

        switch (choice) {
            case "1":
                Cli.getGreeting();
                break;
            case "2":
                Even.prepareGame();
                break;
            case "3":
                Calc.prepareGame();
                break;
            case "4":
                GCD.prepareGame();
                break;
            case "5":
                Progression.prepareGame();
                break;
            case "6":
                Prime.prepareGame();
                break;
            case "0":
                System.out.println("Bye.");
                break;
            default:
                break;
        }

        Engine.setClose(); // Closing input stream
    }
}
