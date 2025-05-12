package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static final String GAME_TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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
            boolean isEven = isEvenNumber(questionElement);
            questionsAnswers[i][0] = String.valueOf(questionElement); // question
            questionsAnswers[i][1] = isEven ? "yes" : "no"; // answer
        }

        return questionsAnswers;
    }

    private static int generateQuestionElement() {
        return Utils.getRandomNumber();
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
