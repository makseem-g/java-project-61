package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    public static void getGameQuestion() {
        System.out.println("What number is missing in the progression?");
    }

    private static Integer result;

    // Creating randomized length of array from 5 to 10
    private static int numbersCount = Engine.getRandomNumber(6) + 4;
    public static String getTask() {
        int[] numbers = new int[numbersCount];
        int progressionCoefficient = Engine.getRandomNumber(13) + 2; // In my opinion from 3 to 15 is good
        int hiddenNumberIndex = Engine.getRandomNumber(numbersCount) - 1;
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
