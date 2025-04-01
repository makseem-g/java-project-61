package hexlet.code;

public class Even {
    public static void gameEven() {
        Engine.getGreeting();
        String name = Engine.getName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        //int rightAnswers = 0;

        for (var i = 1; i <= 3; i++) {//уехало, к удалению
            int randomNumber = Engine.getRandomNumber();//уехало здесь в метод, к удалению
            System.out.println("Question: " + randomNumber);//уехало, к удалению
            System.out.print("Your answer: ");//уехало, к удалению
            String choice = Engine.getChoice();//уехало, к удалению

            if (randomNumber % 2 == 0) {
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.println("Correct!");
                    rightAnswers += 1;
                } else {
                    System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was 'yes'");
                    System.out.println("Let's try again, " + name + "!");
                    break;
                }
            }

            if (randomNumber % 2 != 0) {
                if (choice.equalsIgnoreCase("no")) {
                    System.out.println("Correct!");
                    rightAnswers += 1;
                } else {
                    System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was 'no'");
                    System.out.println("Let's try again, " + name + "!");
                    break;
                }
            }
        }

        if (rightAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static String taskOfTheGame() {
        int randomNumber = Engine.getRandomNumber();
        return String.valueOf(randomNumber);
    }

    public static boolean checkAnswer() {
        if(здесь я закончил, нужно дописать уникальность проверки ответа для этой игры)
    }
}
