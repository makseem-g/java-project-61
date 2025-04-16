package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    public static void getGameQuestion() {
        System.out.println("What number is missing in the progression?");
    }

    private static Integer result;

    // Creating randomized length of array from 5 to 10
    private static final int RANDOM_NUMBER_MAX = 6;
    private static final int OFFSET_VALUE = 4;
    private static final int NUMBERS_COUNT = Engine.getRandomNumber(RANDOM_NUMBER_MAX) + OFFSET_VALUE;
    public static String getTask() {
        int[] numbers = new int[NUMBERS_COUNT];
        int randomNumberRange = 13; // For get random number from 1 to 13
        int offset = 2; // To increase the randomNumberRange value by 2, from 3 to 15
        // In my opinion random coefficient of progression from 3 to 15 is enough for this game
        int progressionCoefficient = Engine.getRandomNumber(randomNumberRange) + offset;
        int hiddenNumberIndex = Engine.getRandomNumber(NUMBERS_COUNT) - 1;
        StringBuilder sb = new StringBuilder();

        // Filling array by numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i == 0) ? Engine.getRandomNumber() : numbers[i - 1] + progressionCoefficient;

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
        result = numbers[hiddenNumberIndex];
        return sb.toString();
    }

    public static boolean checkAnswer() {
        String answer = Engine.getAnswer();
        return (String.valueOf(result).equals(answer));
    }

    public static String getRightAnswer() {
        return String.valueOf(result);
    }
}
