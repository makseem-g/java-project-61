package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static void gamePreparation() {
        String gameTask = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        // Count of array elements (questions) equals count of rounds in game
        String[] questions = new String[Engine.getCountOfRounds()];
        String[] answers = new String[questions.length];

        for (int i = 0; i < questions.length; i++) {
            int number = Utils.getRandomNumber();
            String result;

            if (number == 1) {
                // 1 is not Prime
                result = "no";
            } else if (number > 2 && number % 2 == 0) {
                // All even numbers, if it is not 2 - is not Prime
                result = "no";
            } else {
                result = "yes";
            }

            // Checking odd divisors up to square root of number
            final int initialOddDivisor = 3;
            for (int j = initialOddDivisor; j <= Math.sqrt(number); j += 2) {
                if (number % j == 0) {
                    result = "no";
                    break;
                }
            }

            questions[i] = String.valueOf(number);
            answers[i] = result;
        }

        Engine.gameRoutine(gameTask, questions, answers);
    }
}
