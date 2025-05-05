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
                Engine.getGreeting();
                break;
            case "2":
                Even.gamePreparation();
                break;
            case "3":
                Calc.gamePreparation();
                break;
            case "4":
                GCD.gamePreparation();
                break;
            case "5":
                Progression.gamePreparation();
                break;
            case "6":
                Prime.gamePreparation();
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
