package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final String GAME_TASK = "What number is missing in the progression?";

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
        // Creating array with randomized numbers count from 5 to 10 numbers
        final int minRangeNumber = 5;
        final int maxRangeNumber = 10;
        int numbersCount = Utils.getRandomNumber(minRangeNumber, maxRangeNumber);
        int[] numbers = new int[numbersCount]; // Creating empty array for progression

        // Creating progression coefficient
        // In my opinion random coefficient of progression from 3 to 15 is enough for this game
        final int minProgressionRange = 3;
        final int maxProgressionRange = 15;
        int progressionCoefficient = Utils.getRandomNumber(minProgressionRange, maxProgressionRange);

        // Creating random index of progression numbers array to be hidden
        int hiddenNumberIndex = Utils.getRandomNumber(numbers.length) - 1; // '- 1' because it is index of array

        StringBuilder sb = new StringBuilder();

        // Filling array of progression by numbers for getting hidden number and building string data for question
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i == 0) ? Utils.getRandomNumber() : numbers[i - 1] + progressionCoefficient;

            // Set rules for String Builder
            if (i > 0) {
                sb.append(" ");
            }
            if (i == hiddenNumberIndex) {
                sb.append("..");
            } else {
                sb.append(numbers[i]);
            }
        }

        questionAndAnswerElements[0] = sb.toString(); // question element
        questionAndAnswerElements[1] = String.valueOf(numbers[hiddenNumberIndex]); // answer element
        return questionAndAnswerElements;
    }
}
