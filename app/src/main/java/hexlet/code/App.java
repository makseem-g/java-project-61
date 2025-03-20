package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");

        Scanner initialInput = new Scanner(System.in);
        System.out.print("Your choice: ");

        String choice = initialInput.next();

        if (choice.equals("1")) {
            Cli.greeting();
        }

        if (choice.equals("2")) {
            Even.gameEven();
        }

        if (choice.equals("3")) {
            Calc.gameCalc();
        }

        if (choice.equals("0")) {
            System.out.println("Bye.");
        }

        initialInput.close();
    }
}
