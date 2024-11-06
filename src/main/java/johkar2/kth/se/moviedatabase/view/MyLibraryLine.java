package johkar2.kth.se.moviedatabase.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MyLibraryLine extends Pane {

    private String title;
    private int year, hours, minutes, index;
    private double rating;
    private Image image;
    private Border border;

    private Text titleText, yearText, timeText, ratingText;

    MyLibraryLine(String title, int year, int hours, int minutes, double rating){
        this.title = title;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
        this.rating = rating;

        border = new Border(new BorderStroke(Color.web("0x040404"), BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));

        this.setPrefSize(500,40);
        this.setBorder(border);
        titleText = new Text(title);
        yearText = new Text(String.valueOf(year));
        timeText = new Text(hours + ":" + minutes);
        ratingText = new Text(String.valueOf(rating));

        this.getChildren().addAll(titleText,yearText,timeText,ratingText);
        titleText.relocate(50,10);
        yearText.relocate(50,25);
        timeText.relocate(100,25);
        ratingText.relocate(200,20);

        this.setBackground(new Background(new BackgroundFill(Color.web("0x1C1B1D"),CornerRadii.EMPTY,new Insets(0))));
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
