public class Movie {
    private final String title;
    private boolean watched;
    private int timesSeen;

    public Movie(String title) {
        this(title, false, 0);
    }

    public Movie(String title, boolean watched, int timesSeen) {
        this.title = title;
        this.watched = watched;
        this.timesSeen = timesSeen;
    }

    public String getTitle() {
        return title;
    }

    public boolean isWatched() {
        return watched;
    }

    public int getTimesSeen() {
        return timesSeen;
    }

    public void incrementTimesSeen() {
        timesSeen++;
        watched = true;
    }

    @Override
    public String toString() {
        String seenText = "seen " + timesSeen + " time" + (timesSeen == 1 ? "" : "s");
        String watchedText = watched ? "watched" : "unwatched";
        return title + " - " + seenText + " (" + watchedText + ")";
    }
}
