import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    static ArrayList<String> movieArray = new ArrayList<String>();
    static ArrayList<String> builtInMovies = new ArrayList<String>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Howdy World");
        System.out.println("Huh:");
        String imp = userInput();
        System.out.println("What do you mean '" + imp + "'?");
    }

    // Insert Show Menu and revamp main

    public static String userInput() {
        return input.nextLine();
    }

    static void addMovie(String movie) {
        System.out.println("Enter a movie to add:");
        String newMovie = userInput().trim();
        if (newMovie.isEmpty()) {
            System.out.println("No movie entered. Please try again.");
            return;
        }

        movieArray.add(newMovie);
        System.out.println("'" + newMovie + "' has been added to your movie list.");
    }

    static void listMovies(ArrayList<String> list, String label) {
        System.out.println("--- " + label + " ---");
        if (list.size() == 0) {
            System.out.println("Nothing here chief.");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }

    }

    static void pickFromList(ArrayList<String> list, String label) {
        if (list.size() == 0) {
            System.out.println(label + "is empty.");
            return;
        }
        Random randy = new Random();
        int randomIndex = randy.nextInt(list.size());
        System.out.println("Randomly selected movie from " + label + ": " + list.get(randomIndex));
    }

    static void pickFromCombined() {
        ArrayList<String> combined = new ArrayList<>(builtInMovies);
        combined.addAll(movieArray);
        pickFromList(combined, "combined");
    }

    static void seedBuiltInMovies() {
        builtInMovies.add("The Shawshank Redemption");
        builtInMovies.add("The Godfather");
        builtInMovies.add("The Dark Knight");
        builtInMovies.add("Pulp Fiction");
        builtInMovies.add("The Lord of the Rings: The Return of the King");
    }
}