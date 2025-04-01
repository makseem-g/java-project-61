package hexlet.code;

public class Calc {
    public static void gameCalc() {
        Engine.getGreeting();
        String name = Engine.getName();
        System.out.println("What is the result of the expression?");

        int rightAnswers = 0;//уехало, к удалению

        for (var i = 1; i <= 3; i++) {//уехало, к удалению
            int num1 = Engine.getRandomNumber();
            int num2 = Engine.getRandomNumber();
            int randomOperator = Engine.getRandomNumber(3);
            int result;

            switch (randomOperator) {
                case 1:
                    result = num1 + num2;
                    System.out.println("Question: " + num1 + " + " + num2);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.println("Question: " + num1 + " - " + num2);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.println("Question: " + num1 + " * " + num2);
                    break;
                default:
                    result = 0;
                    System.out.println("Unknown operator!");
                    break;
            }

            System.out.print("Your answer: ");
            String choice = Engine.getChoice();

            if (String.valueOf(result).equals(choice)) {
                System.out.println("Correct!");
                rightAnswers += 1;
            } else {
                System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was '" + result + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (rightAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
