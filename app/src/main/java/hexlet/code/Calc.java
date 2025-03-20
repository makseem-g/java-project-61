package hexlet.code;
import java.util.Scanner;
import java.util.Random;

public class Calc {
    public static void gameCalc() {
        Scanner forCalcGameScanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        String name = forCalcGameScanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");

        Random random = new Random();
        int rightAnswers = 0;

        for (var i = 1; i <= 3; i++) {
            int num1 = random.nextInt(30) + 1;
            int num2 = random.nextInt(30) + 1;
            int randomOperator = random.nextInt(3) + 1;
            int result;

            switch (randomOperator) {
                case 1:
                    result = num1 + num2;
                    System.out.println("Question: " + num1 + " + " + num2);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.println("Question: " + num1 + " - " + num2);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.println("Question: " + num1 + " * " + num2);
                    break;
                default:
                    result = 0;
                    System.out.println("Unknown operator!");
                    break;
            }

            System.out.print("Your answer: ");
            String choice = forCalcGameScanner.nextLine();

            if (String.valueOf(result).equals(choice)) {
                System.out.println("Correct!");
                rightAnswers += 1;
            } else {
                System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was '" + result + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (rightAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
