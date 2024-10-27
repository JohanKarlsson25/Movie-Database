package johkar2.kth.se.moviedatabase.view;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class View extends Pane {

    private final int windowWidth = 1500, windowHeight = 700;
    private final int animationYTransition = -3300;
    private final int animationDuration = 30;

    private ImageView backgroundImageView, movieImageview, tv_seriesImageview;
    private Image mainMenuImage, mainMenuOutlineIcon;
    private ApplicationState applicationState;

    public View(Stage stage){
        initView();
        this.applicationState = ApplicationState.MAIN_MENU;
    }

    void mainMenuView(){

        this.getChildren().clear();
        backgroundImageView.setImage(mainMenuImage);
        this.getChildren().add(backgroundImageView);
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(animationDuration));
        transition.setToY(animationYTransition);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(backgroundImageView);
        transition.play();

        this.getChildren().addAll(movieImageview, tv_seriesImageview);
        movieImageview.relocate(400,500);
        tv_seriesImageview.relocate(windowWidth-400-mainMenuOutlineIcon.getWidth(),500);
    }

    void movieView(){
        this.getChildren().clear();
    }

    private void initView(){

        this.setPrefSize(windowWidth,windowHeight);
        mainMenuOutlineIcon = new Image("mainMenuOutlineIcon.png");
        movieImageview = new ImageView();
        movieImageview.setImage(mainMenuOutlineIcon);
        tv_seriesImageview = new ImageView();
        tv_seriesImageview.setImage(mainMenuOutlineIcon);
        backgroundImageView = new ImageView();
        mainMenuImage = new Image("backgroundImage.png");

        mainMenuView();
    }

    void addEventHandlers(Controller controller){

        movieImageview.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleMovieSelected();
            }
        });

        tv_seriesImageview.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleTvSeriesSelected();
            }
        });

        movieImageview.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleHover(mouseEvent.getSource());
            }
        });

        tv_seriesImageview.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleHover(mouseEvent.getSource());
            }
        });
    }

    ImageView getMovieImageview(){
        return movieImageview;
    }

    ImageView getTv_seriesImageview(){
        return tv_seriesImageview;
    }
}
