package hexlet.code;

import java.util.Random;

public class Utils {
    // Creating a static Random instance for generating random numbers
    private static final Random RANDOM = new Random();

    public static int getRandomNumber() {
        int defaultRange = 30; // Set default range of random numbers
        return RANDOM.nextInt(defaultRange) + 1; // Offsets result by 1 to exclude zero from range
    }

    public static int getRandomNumber(int range) { // When need specific range
        return RANDOM.nextInt(range) + 1; // Offsets result by 1 to exclude zero from range
    }

    public static int getRandomNumber(int numberFrom, int numberTo) {
        return RANDOM.nextInt(numberFrom, (numberTo + 1)); // Offsets "numberTo" by 1 to include it in range
    }
}
