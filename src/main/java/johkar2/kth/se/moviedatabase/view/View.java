package johkar2.kth.se.moviedatabase.view;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class View extends Pane {

    private Button tv_seriesButton, movieButton;
    private ImageView imageView;
    private Image mainMenuImage;
    private ApplicationState applicationState;

    public View(Stage stage){
        initView();
        this.applicationState = ApplicationState.MAIN_MENU;
    }

    void mainMenuView(){
        this.getChildren().clear();
        imageView.setImage(mainMenuImage);
        this.getChildren().add(imageView);
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(30));
        transition.setToY(-3300);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(imageView);
        transition.play();
    }

    private void initView(){

        this.setPrefSize(1500,700);
        tv_seriesButton = new Button();
        movieButton = new Button();
        imageView = new ImageView();

        this.getChildren().addAll(tv_seriesButton, movieButton, imageView);
        mainMenuImage = new Image("backgroundImage.png");

        mainMenuView();
    }

    void addEventHandlers(Controller controller){
        tv_seriesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.handleTvSeriesSelected();
            }
        });

        movieButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.handleMovieSelected();
            }
        });
    }
}
