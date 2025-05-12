package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final String GAME_TASK = "What is the result of the expression?";

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
        String[] questionAndAnswerElements = new String[2]; // Elements: 1 - question; 2 - answer
        int num1 = Utils.getRandomNumber();
        int num2 = Utils.getRandomNumber();
        String randomOperator = generateRandomOperator();

        switch (randomOperator) {
            case "+":
                questionAndAnswerElements[0] = num1 + " + " + num2; // question element
                questionAndAnswerElements[1] = String.valueOf(num1 + num2); // answer element
                break;
            case "-":
                questionAndAnswerElements[0] = num1 + " - " + num2; // question element
                questionAndAnswerElements[1] = String.valueOf(num1 - num2); // answer element
                break;
            case "*":
                questionAndAnswerElements[0] = num1 + " * " + num2; // question element
                questionAndAnswerElements[1] = String.valueOf(num1 * num2); // answer element
                break;
            default:
                System.out.println("Unknown operator!");
                break;
        }

        return questionAndAnswerElements;
    }

    private static String generateRandomOperator() {
        String[] randomOperators = {"+", "-", "*"};
        return randomOperators[Utils.getRandomNumber(randomOperators.length) - 1]; // '- 1' because need array index
    }
}
