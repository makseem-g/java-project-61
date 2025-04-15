package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void getGameQuestion() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    private static Boolean result;
    public static int getTask() {
        int number = Engine.getRandomNumber();

        if (number == 1) {
            // 1 is not Prime
            result = false;
        } else if (number > 2 && number % 2 == 0) {
            // All even numbers, if it is not 2 - is not Prime
            result = false;
        } else {
            result = true;
        }

        // Checking odd divisors up to square root of number
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return number;
    }

    public static boolean checkAnswer() {
        String answer = Engine.getAnswer();
        return (answer.equalsIgnoreCase("yes") && result)
                || (answer.equalsIgnoreCase("no") && !result);
    }

    public static String getRightAnswer() {
        return result ? "yes" : "no";
    }
}
