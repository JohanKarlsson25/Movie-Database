package johkar2.kth.se.moviedatabase.view;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class MyLibraryLine extends Pane {

    private String title;
    private int year, hours, minutes, index;
    private double rating;
    private Image image;

    MyLibraryLine(String title, int year, int hours, int minutes, double rating){
        this.title = title;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getIndex() {
        return index;
    }

    public double getRating() {
        return rating;
    }

    public Image getImage() {
        return image;
    }
}
