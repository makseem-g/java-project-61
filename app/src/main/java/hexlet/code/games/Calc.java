package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static void gamePreparation() {
        String gameTask = "What is the result of the expression?";
        // Count of array elements (questions) equals count of rounds in game
        String[] questions = new String[Engine.getCountOfRounds()];
        String[] answers = new String[questions.length];

        for (int i = 0; i < questions.length; i++) {
            int num1 = Utils.getRandomNumber();
            int num2 = Utils.getRandomNumber();

            // Creating random math operator
            final int randomOperatorsCount = 3; // Because need only '+', '-', '*'
            int randomOperator = Utils.getRandomNumber(randomOperatorsCount);

            switch (randomOperator) {
                case 1:
                    questions[i] = num1 + " + " + num2;
                    answers[i] = String.valueOf(num1 + num2);
                    break;
                case 2:
                    questions[i] = num1 + " - " + num2;
                    answers[i] = String.valueOf(num1 - num2);
                    break;
                case 3:
                    questions[i] = num1 + " * " + num2;
                    answers[i] = String.valueOf(num1 * num2);
                    break;
                default:
                    System.out.println("Unknown operator!");
                    break;
            }
        }

        Engine.gameRoutine(gameTask, questions, answers);
    }
}
