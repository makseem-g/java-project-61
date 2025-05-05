package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static void gamePreparation() {
        String gameTask = "Find the greatest common divisor of given numbers.";
        // Count of array elements (questions) equals count of rounds in game
        String[] questions = new String[Engine.getCountOfRounds()];
        String[] answers = new String[questions.length];

        for (int i = 0; i < questions.length; i++) {
            int num1 = Utils.getRandomNumber();
            int num2 = Utils.getRandomNumber();

            questions[i] = num1 + " " + num2;

            int a = num1;
            int b = num2;

            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            answers[i] = String.valueOf(a);
        }

        Engine.gameRoutine(gameTask, questions, answers);
    }
}
