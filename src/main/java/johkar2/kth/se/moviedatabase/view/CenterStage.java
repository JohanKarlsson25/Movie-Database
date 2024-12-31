package johkar2.kth.se.moviedatabase.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.List;

public class CenterStage extends Pane {

    private Text mainText, secondaryText;
    private ImageView mostRecentWatchImageView;
    private Image mostRecentWatchImage;
    private List<IconObject> movieIconObjectList, tv_SeriesIconObjectList;

    private final Font textFont = new Font("Book Antiqua Bold",20);

    CenterStage(){
        initUI();
    }

    void startScreen(){
        this.getChildren().clear();
        this.getChildren().addAll(mostRecentWatchImageView,mainText);
    }

    void browseScreen(List<IconObject> movieIconObjectList, List<IconObject> tv_SeriesIconObjectList){
        this.getChildren().clear();
        this.getChildren().addAll(mainText,secondaryText);
        mainText.setText("Movies");

        this.movieIconObjectList = movieIconObjectList;
        this.tv_SeriesIconObjectList = tv_SeriesIconObjectList;
        initialPosition();
    }

    void relocateMovieIconObject(IconObject iconObject, int yCoordinate){
        iconObject.relocate(movieIconObjectList.indexOf(iconObject)*210 + 10, yCoordinate);
    }

    void relocateTv_SeriesIconObject(IconObject iconObject, int yCoordinate){
        iconObject.relocate(tv_SeriesIconObjectList.indexOf(iconObject)*210 + 10, yCoordinate);
    }

    void setMostRecentWatchImage(String mostRecentWatchImageTitle){
        if (mostRecentWatchImage == null) this.mostRecentWatchImage = new Image(mostRecentWatchImageTitle + ".png"); //What happens when I change a movie to watchedStatus??
        mostRecentWatchImageView.setImage(mostRecentWatchImage); //This Image needs to be cropped. I have different Images but all quadratic
    }

    private void initialPosition(){
        int spacingValue = 0;
        for (IconObject iconObject : movieIconObjectList){
            this.getChildren().add(iconObject);
            iconObject.relocate(200*spacingValue++ + spacingValue*10,50);
        }
        spacingValue = 0;
        for (IconObject iconObject : tv_SeriesIconObjectList){
            this.getChildren().add(iconObject);
            iconObject.relocate(200*spacingValue++ + spacingValue*10,360);
        }
    }

    private void initUI(){

        this.setPrefSize(850,600);

        mostRecentWatchImageView = new ImageView();
        mostRecentWatchImageView.relocate(0,88);
        mainText = new Text("Most Recent Watch");
        secondaryText = new Text("Tv-Series"); //?
        mainText.relocate(10,10);
        secondaryText.relocate(10,320);
        mainText.setFont(textFont);
        mainText.setFill(Color.WHITESMOKE);
        secondaryText.setFont(textFont);
        secondaryText.setFill(Color.WHITESMOKE);
        this.getChildren().addAll(mostRecentWatchImageView,mainText);
    }
}
