package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static void gamePreparation() {
        String gameTask = "What number is missing in the progression?";
        // Count of array elements (questions) equals count of rounds in game
        String[] questions = new String[Engine.getCountOfRounds()];
        String[] answers = new String[questions.length];

        for (int i = 0; i < questions.length; i++) {
            // Creating array with randomized numbers count from 5 to 10 numbers
            final int minRangeNumber = 5;
            final int maxRangeNumber = 10;
            int numbersCount = Utils.getRandomNumber(minRangeNumber, maxRangeNumber);
            int[] numbers = new int[numbersCount]; // Getting empty array for progression

            // Creating progression coefficient
            // In my opinion random coefficient of progression from 3 to 15 is enough for this game
            final int minProgressionRange = 3;
            final int maxProgressionRange = 15;
            int progressionCoefficient = Utils.getRandomNumber(minProgressionRange, maxProgressionRange);

            // Creating random index of progression numbers array to be hidden
            int hiddenNumberIndex = Utils.getRandomNumber(numbers.length) - 1; // '- 1' because it is index of array

            StringBuilder sb = new StringBuilder();

            // Filling array of progression by numbers
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = (j == 0) ? Utils.getRandomNumber() : numbers[j - 1] + progressionCoefficient;

                // Set rules for String Builder
                if (j > 0) {
                    sb.append(" ");
                }
                if (j == hiddenNumberIndex) {
                    sb.append("..");
                } else {
                    sb.append(numbers[j]);
                }
            }

            questions[i] = sb.toString();
            answers[i] = String.valueOf(numbers[hiddenNumberIndex]);
        }

        Engine.gameRoutine(gameTask, questions, answers);
    }
}
