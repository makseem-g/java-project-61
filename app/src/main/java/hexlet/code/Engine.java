package hexlet.code;

import java.util.Scanner;

public class Engine {
    // Creating input stream handler
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static String name;
    private static final int COUNT_OF_ROUNDS = 3;

    public static int getCountOfRounds() {
        return COUNT_OF_ROUNDS;
    }

    public static String getChoice() {
        return USER_INPUT.nextLine();
    }

    public static void getGreeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        name = getChoice();
        System.out.println("Hello, " + name + "!");
    }

    public static void gameRoutine(String gameTask, String[] questions, String[] answers) {
        getGreeting();
        System.out.println(gameTask);

        int rightAnswers = 0; // Initial counter for tracking correct responses

        for (var i = 0; i < COUNT_OF_ROUNDS; i++) {
            String answer;
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            answer = getChoice();
            if (answer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!");
                rightAnswers += 1;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + answers[i] + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (rightAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static void setClose() {
        // Releases system resources by closing the input stream at application termination
        USER_INPUT.close();
    }
}
