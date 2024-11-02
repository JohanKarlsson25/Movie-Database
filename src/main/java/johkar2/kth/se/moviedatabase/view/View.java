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

    private final int windowWidth = 1500, windowHeight = 900;
    private final int animationYTransition = -3300;
    private final int animationDuration = 30;
    private ApplicationState applicationState;

    //GUI Components
    private ImageView background, movieButton, tv_seriesButton, exitButton;
    private Image mainMenuImage, mainMenuOutlineIcon, exitButtonImage;

    public View(Stage stage){
        initView();
        this.applicationState = ApplicationState.MAIN_MENU;
    }

    void mainMenuView(){

        this.getChildren().clear();
        this.getChildren().add(background);
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(animationDuration));
        transition.setToY(animationYTransition);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(background);
        transition.play();

        this.getChildren().addAll(movieButton, tv_seriesButton);
        movieButton.relocate(400,500);
        tv_seriesButton.relocate(windowWidth-400-mainMenuOutlineIcon.getWidth(),500);
    }

    void movieView(){

        this.getChildren().clear();
        this.applicationState = ApplicationState.MOVIE_SUBMENU;
        this.setStyle("-fx-background-color: #05031a;");
        this.getChildren().add(exitButton);
        exitButton.relocate(1400,25);
    }

    private void initView(){

        this.setPrefSize(windowWidth,windowHeight);

        //TODO kolla om dessa images ska flyttas till IO (förmodligen)
        mainMenuOutlineIcon = new Image("mainMenuOutlineIcon.png");
        mainMenuImage = new Image("backgroundImage.png");
        exitButtonImage = new Image("cross.png");
        movieButton = new ImageView();
        tv_seriesButton = new ImageView();
        background = new ImageView();
        exitButton = new ImageView();
        movieButton.setImage(mainMenuOutlineIcon);
        tv_seriesButton.setImage(mainMenuOutlineIcon);
        background.setImage(mainMenuImage);
        exitButton.setImage(exitButtonImage);

        mainMenuView();
    }

    void addEventHandlers(Controller controller){

        movieButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleMovieSelected();
            }
        });

        tv_seriesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleTvSeriesSelected();
            }
        });

        movieButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleHover(mouseEvent.getSource());
            }
        });

        tv_seriesButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleHover(mouseEvent.getSource());
            }
        });

        exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleExitRequest();
            }
        });
    }

    ImageView getMovieButtonImageview(){
        return movieButton;
    }

    ImageView getTv_seriesButton(){
        return tv_seriesButton;
    }
}
