package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final String GAME_TASK = "Find the greatest common divisor of given numbers.";

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
            String[] questionAndAnswerElements = generateElementsOfQuestionAndAnswer();
            questionsAnswers[i][0] = questionAndAnswerElements[0]; // question element
            questionsAnswers[i][1] = questionAndAnswerElements[1]; // answer element
        }

        return questionsAnswers;
    }

    private static String[] generateElementsOfQuestionAndAnswer() {
        String[] questionAndAnswerElements = new String[2]; // elements: 1 - question; 2 - answer
        int num1 = Utils.getRandomNumber();
        int num2 = Utils.getRandomNumber();
        questionAndAnswerElements[0] = num1 + " " + num2; // question element
        questionAndAnswerElements[1] = calculateGreatestCommonDivisor(num1, num2); // answer element
        return questionAndAnswerElements;
    }

    private static String calculateGreatestCommonDivisor(int num1, int num2) {
        int a = num1;
        int b = num2;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return String.valueOf(a);
    }
}
