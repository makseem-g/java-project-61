package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static void gamePreparation() {
        String gameTask = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        // Count of array elements (questions) equals count of rounds in game
        String[] questions = new String[Engine.getCountOfRounds()];
        String[] answers = new String[questions.length];

        for (int i = 0; i < questions.length; i++) {
            int questionElement = Utils.getRandomNumber();
            questions[i] = String.valueOf(questionElement);
            answers[i] = questionElement % 2 == 0 ? "yes" : "no";
        }

        Engine.gameRoutine(gameTask, questions, answers);
    }
}
