import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<String> movieArray = new ArrayList<String>();

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

    public static ArrayList moviesToArray(String movie) {
        movieArray.add(movie);
        return movieArray;
    }
}