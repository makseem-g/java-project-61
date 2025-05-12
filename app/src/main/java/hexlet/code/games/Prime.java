package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final String GAME_TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void prepareGame() {
        String[][] questionsAnswers = generateQuestionsAndAnswers();
        Engine.runGame(GAME_TASK, questionsAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        // Creating double-dimensional array
        // Count of array pair-elements (question and answer) equals count of rounds in game
        final int elementsCountInPair = 2;
        String[][] questionsAnswers = new String[Engine.getCountOfRounds()][elementsCountInPair];

        for (int i = 0; i < questionsAnswers.length; i++) {
            int questionElement = generateQuestionElement();
            boolean isPrime = isPrimeNumber(questionElement);
            questionsAnswers[i][0] = String.valueOf(questionElement); // question
            questionsAnswers[i][1] = isPrime ? "yes" : "no"; // answer
        }

        return questionsAnswers;
    }

    private static int generateQuestionElement() {
        return Utils.getRandomNumber();
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) {
            // 1 is not Prime
            return false;
        }
        if (number > 2 && number % 2 == 0) {
            // All even numbers, if it is not 2 - is not Prime
            return false;
        }

        // Checking odd divisors up to square root of number
        final int initialOddDivisor = 3;
        for (int i = initialOddDivisor; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
