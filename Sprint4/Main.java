import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    static ArrayList<Movie> movieArray = new ArrayList<Movie>();
    static ArrayList<Movie> builtInMovies = new ArrayList<Movie>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        seedBuiltInMovies();
        boolean running = true;
        while (running) {
            showMenu();
            String choice = userInput();
            switch (choice) {
                case "1":
                    pickFromList(builtInMovies, "built-in movies");
                    break;
                case "2":
                    pickFromList(movieArray, "your movies");
                    break;
                case "3":
                    pickFromCombined();
                    break;
                case "4":
                    listMovies(builtInMovies, "Built-in Movies");
                    break;
                case "5":
                    listMovies(movieArray, "Your Movies");
                    break;
                case "6":
                    addMovie("");
                    break;

                case "7":
                    listUnwatched(combinedList(), "combined");
                    break;
                case "8":
                    markMovieWatched(combinedList(), "combined");
                    break;
                case "0":
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        input.close();

    }

    static void showMenu() {
        System.out.println("--- Movie Menu ---");
        System.out.println("1) Pick movie from built-in list");
        System.out.println("2) Pick movie from your list");
        System.out.println("3) Pick movie from combined list");
        System.out.println("4) List built-in movies");
        System.out.println("5) List your movies");
        System.out.println("6) Add a movie to your list");
        System.out.println("7) List unwatched movies");
        System.out.println("8) Mark a movie as watched");
        System.out.println("0) Exit");
        System.out.println("Choose please: ");
    }

    public static String userInput() {
        return input.nextLine();
    }

    static void addMovie(String movie) {
        System.out.println("Enter a movie to add:");
        String newMovie = userInput().trim();

        if (newMovie.isEmpty()) {
            System.out.println("No empty titles. Please.");
            return;
        }

        // sets a new movie with default zeroes and adds it to the movie array
        movieArray.add(new Movie(newMovie));
        System.out.println("'" + newMovie + "' has been added to your movie list.");
    }

    static void listMovies(ArrayList<Movie> list, String label) {
        System.out.println("--- " + label + " ---");
        if (list.size() == 0) {
            System.out.println("Nothing here chief.");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }

    }

    static void listUnwatched(ArrayList<Movie> list, String label) {
        System.out.println("--- Unwatched Movies in " + label + " ---");

        boolean any = false;
        for (Movie movie : list) {
            if (!movie.isWatched()) {
                System.out.println(movie);
                any = true;
            }
        }

        if (!any) {
            System.out.println("All movies in " + label + " have been watched.");
        }
    }

    static void markMovieWatched(ArrayList<Movie> list, String label) {
        if (list.isEmpty()) {
            System.out.println(label + " is empty.");
            return;
        }

        listMovies(list, label);
        int choice = readInt("Pick a movie number to mark watched: ");

        int index = choice - 1;
        if (index < 0 || index >= list.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Movie m = list.get(index);
        m.incrementTimesSeen();

        System.out.println("Updated: " + m);
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String inputStr = userInput();
            try {
                return Integer.parseInt(inputStr);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static void pickFromList(ArrayList<Movie> list, String label) {
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

    static ArrayList<Movie> combinedList() {
        ArrayList<Movie> combined = new ArrayList<>(builtInMovies);
        combined.addAll(userMovies);
        return combined;
    }

    static void seedBuiltInMovies() {
        builtInMovies.add(new Movie("Spiderman: Into the Spider-Verse"));
        builtInMovies.add(new Movie("Princess Mononoke"));
        builtInMovies.add(new Movie("Spirited Away"));
        builtInMovies.add(new Movie("The Lord of the Rings: The Fellowship of the Ring"));
        builtInMovies.add(new Movie("The Lord of the Rings: The Two Towers"));
        builtInMovies.add(new Movie("The Lord of the Rings: The Return of the King"));
        builtInMovies.add(new Movie("F1"));
    }
}