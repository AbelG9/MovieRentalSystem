package Models;

public class Movie extends RentalItem {
    private String director;
    private int duration;
    private String ageRating;
    private String genre;

    public Movie(String itemName, int itemID, boolean available, String director, int duration, String ageRating, String genre) {
        super(itemName, itemID, available);
        this.director = director;
        this.duration = duration;
        this.ageRating = ageRating;
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void showDetails(){
        System.out.println("Item id: " + this.getItemID());
        System.out.println("Item name: " + this.getItemName());
        System.out.println("Is available: " + this.getItemName());
        System.out.println("Director: " + this.director);
        System.out.println("Duration: " + this.duration);
        System.out.println("Age Rating: " + this.ageRating);
        System.out.println("Genre: " + this.genre);
        System.out.println("--------------------------------------------");
    }
}
