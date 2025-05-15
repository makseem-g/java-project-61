package hexlet.code;

public class Cli {
    public static void getGreeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        String name = Engine.getChoice();
        System.out.println("Hello, " + name + "!");
    }
}
