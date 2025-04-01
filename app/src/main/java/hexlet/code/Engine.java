package hexlet.code;
import java.util.Scanner;
import java.util.Random;

public class Engine {
    private static Scanner userInput = new Scanner(System.in);
    private static String name;
    private static Random random = new Random();

    private static String taskOfTheGame = "";

    public static String getChoice() {
        return userInput.nextLine();
    }
    public static void getGreeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        name = getChoice();
        System.out.println("Hello, " + name + "!");
    }

    public static String getName() {
        return name;
    }

    public static int getRandomNumber() {
        int defaultRange = 30; //set range of random numbers
        return random.nextInt(defaultRange) + 1;
    }

    public static int getRandomNumber(int range) { //when need specific range
        return random.nextInt(range) + 1;
    }

    public static void startChosenGame(String choice) {
        if (choice.equals("1")) {
            Engine.getGreeting();
        }

        if (choice.equals("2")) {
            Even.gameEven();
            taskOfTheGame = Even.taskOfTheGame();
        }

        if (choice.equals("3")) {
            Calc.gameCalc();
        }

        if (choice.equals("0")) {
            System.out.println("Bye.");
        }
    }

    public static void gameRoutine() {
        int rightAnswers = 0;

        for (var i = 1; i <= 3; i++) {
            System.out.println("Question: " + taskOfTheGame);
            System.out.print("Your answer: ");
            String choice = Engine.getChoice();
        }
    }

    public static void setClose() {
        userInput.close();
    }
}
