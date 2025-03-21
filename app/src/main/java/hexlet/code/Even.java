package hexlet.code;
import java.util.Scanner;
import java.util.Random;


public class Even {
    public static void gameEven() {
        Scanner forEvenGameScanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        String name = forEvenGameScanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random random = new Random();
        int rightAnswers = 0;

        for (var i = 1; i <= 3; i++) {
            int randomNumber = random.nextInt(100) + 1;
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String choice = forEvenGameScanner.nextLine();

            if (randomNumber % 2 == 0) {
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.println("Correct!");
                    rightAnswers += 1;
                } else {
                    System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was 'yes'");
                    System.out.println("Let's try again, " + name + "!");
                    break;
                }
            }

            if (randomNumber % 2 != 0) {
                if (choice.equalsIgnoreCase("no")) {
                    System.out.println("Correct!");
                    rightAnswers += 1;
                } else {
                    System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was 'no'");
                    System.out.println("Let's try again, " + name + "!");
                    break;
                }
            }
        }

        if (rightAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
