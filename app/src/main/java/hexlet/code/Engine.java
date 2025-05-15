package hexlet.code;

import java.util.Scanner;

public class Engine {
    // Creating input stream handler
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static final int COUNT_OF_ROUNDS = 3;

    public static int getCountOfRounds() {
        return COUNT_OF_ROUNDS;
    }

    public static String getChoice() {
        return USER_INPUT.nextLine();
    }

    public static void runGame(String gameTask, String[][] questionsAnswers) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        String name = getChoice();
        System.out.println("Hello, " + name + "!");
        System.out.println(gameTask);

        for (var i = 0; i < COUNT_OF_ROUNDS; i++) {
            String answer;
            System.out.println("Question: " + questionsAnswers[i][0]);
            System.out.print("Your answer: ");
            answer = getChoice();

            if (!answer.equalsIgnoreCase(questionsAnswers[i][1])) {
                System.out.println("'" + answer + "' is wrong answer ;(. "
                        + "Correct answer was '" + questionsAnswers[i][1] + "'");
                System.out.println("Let's try again, " + name + "!");
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + name + "!");
    }

    public static void setClose() {
        // Releases system resources by closing the input stream at application termination
        USER_INPUT.close();
    }
}
