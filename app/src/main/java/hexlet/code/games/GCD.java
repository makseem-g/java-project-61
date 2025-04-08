package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void getGameQuestion() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    private static Integer result;
    public static String getTask() {
        int num1 = Engine.getRandomNumber();
        int num2 = Engine.getRandomNumber();
        String textOfTask = num1 + " " + num2;
        int a = num1;
        int b = num2;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        result = a;
        return textOfTask;
    }

    public static boolean checkAnswer() {
        String answer = Engine.getAnswer();
        return (String.valueOf(result).equals(answer));
    }

    public static String getRightAnswer() {
        return String.valueOf(result);
    }
}
