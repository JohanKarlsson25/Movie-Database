package johkar2.kth.se.moviedatabase.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        this.getChildren().add(imageView);
        imageView.setImage(mainMenuImage);
        Thread background = new Thread(new MainMenuBackground(this));
        background.start();
    }

    void setViewPort(int yPixelValue){
        imageView.setViewport(new Rectangle2D(0,yPixelValue,1280,720));
    }

    private void initView(){

        this.setPrefSize(1280,720);
        tv_seriesButton = new Button();
        movieButton = new Button();
        imageView = new ImageView();

        this.getChildren().addAll(tv_seriesButton, movieButton, imageView);
        mainMenuImage = new Image("download.png");

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
