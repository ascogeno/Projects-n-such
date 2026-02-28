import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Howdy World");
        System.out.println("Huh:");
        String imp = userInput();
        System.out.println("What do you mean '" + imp + "'?");
    }

    public static String userInput() {
        try (Scanner userScannner = new Scanner(System.in)) {
            String userInput = userScannner.nextLine();
            return userInput;
        }
    }
}