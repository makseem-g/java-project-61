package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;
import java.util.Random;

public class Engine {
    // Creating input stream handler; the final modifier intentionally omitted
    private static Scanner userInput = new Scanner(System.in);
    private static String name;
    private static String currentGame;

    // Creating a static Random instance for generating random numbers
    // The final modifier intentionally omitted
    private static Random random = new Random();
    private static int countOfRounds = 3; // The final modifier intentionally omitted for flexibility
    private static String task;
    private static String answer;
    private static Boolean isCorrectAnswer;
    private static String rightAnswer;

    public static String getChoice() {
        return userInput.nextLine();
    }

    public static void getGreeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        name = getChoice();
        System.out.println("Hello, " + name + "!");
    }

    public static int getRandomNumber() {
        int defaultRange = 30; // Set default range of random numbers
        return random.nextInt(defaultRange) + 1; // Offsets result by 1 to exclude zero from range
    }

    public static int getRandomNumber(int range) { // When need specific range
        return random.nextInt(range) + 1; // Offsets result by 1 to exclude zero from range
    }

    public static void startChosenGame(String choice) {
        if (choice.equals("1")) {
            currentGame = "Greet";
            Engine.getGreeting();
        }

        if (choice.equals("2")) {
            currentGame = "Even";
            Engine.getGreeting();
            Even.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("3")) {
            currentGame = "Calc";
            Engine.getGreeting();
            Calc.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("4")) {
            currentGame = "GCD";
            Engine.getGreeting();
            GCD.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("5")) {
            currentGame = "Progression";
            Engine.getGreeting();
            Progression.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("6")) {
            currentGame = "Prime";
            Engine.getGreeting();
            Prime.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("0")) {
            System.out.println("Bye.");
        }
    }

    public static void setTask() {
        switch (currentGame) {
            case "Even":
                task = String.valueOf(Even.getTask());
                break;
            case "Calc":
                task = Calc.getTask();
                break;
            case "GCD":
                task = GCD.getTask();
                break;
            case "Progression":
                task = Progression.getTask();
                break;
            case "Prime":
                task = String.valueOf(Prime.getTask());
                break;
            default:
                break;
        }
    }

    public static void setCheckingOptions() {
        switch (currentGame) {
            case "Even":
                isCorrectAnswer = Even.checkAnswer();
                rightAnswer = Even.getRightAnswer();
                break;
            case "Calc":
                isCorrectAnswer = Calc.checkAnswer();
                rightAnswer = Calc.getRightAnswer();
                break;
            case "GCD":
                isCorrectAnswer = GCD.checkAnswer();
                rightAnswer = GCD.getRightAnswer();
                break;
            case "Progression":
                isCorrectAnswer = Progression.checkAnswer();
                rightAnswer = Progression.getRightAnswer();
                break;
            case "Prime":
                isCorrectAnswer = Prime.checkAnswer();
                rightAnswer = Prime.getRightAnswer();
                break;
            default:
                break;
        }
    }

    public static String getTask() {
        return task;
    }

    public static String getAnswer() {
        return answer;
    }

    public static void gameRoutine() {
        int rightAnswers = 0; // Initial counter for tracking correct responses

        for (var i = 1; i <= countOfRounds; i++) {
            setTask();
            System.out.println("Question: " + task);
            System.out.print("Your answer: ");
            answer = Engine.getChoice();
            setCheckingOptions();
            if (isCorrectAnswer) {
                System.out.println("Correct!");
                rightAnswers += 1;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'");
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
        userInput.close();
    }
}
