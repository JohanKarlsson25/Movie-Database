package johkar2.kth.se.moviedatabase.view;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class View extends Pane {

    private final int windowWidth = 1500, windowHeight = 900;
    private ApplicationState applicationState;

    //GUI Components
    private ImageView backgroundIV, movieButtonIV, tv_seriesButtonIV, exitButtonIV, menuHamburgerButtonIV;
    private Pane movieButton, tv_seriesButton, exitButton, menuHamburgerButton, previewWindow;
    private Image mainMenuImage, mainMenuOutlineIcon, exitButtonImage, menuHamburgerButtonImage;
    private Background smallIconBackground;

    public View(Stage stage){
        initView();
        this.applicationState = ApplicationState.MAIN_MENU;
    }

    void mainMenuView(){

        this.getChildren().clear();
        this.getChildren().add(backgroundIV);
        startTransition(30,-3000,true,Animation.INDEFINITE,backgroundIV);
        this.getChildren().addAll(movieButton,tv_seriesButton);
        movieButton.relocate(400,500);
        tv_seriesButton.relocate(windowWidth-400-mainMenuOutlineIcon.getWidth(),500);
    }

    void movieView(){

        this.getChildren().clear();
        this.applicationState = ApplicationState.MOVIE_SUBMENU;
        this.setStyle("-fx-background-color: #05031a;");
        this.getChildren().addAll(exitButton,menuHamburgerButton,previewWindow);
        exitButton.relocate(1400,25);
        menuHamburgerButton.relocate(100,100);
        previewWindow.relocate(1100,100);
        previewWindow.setPrefSize(350,700);
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
        exitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.HAND);
                exitButton.setBackground(smallIconBackground);
            }
        });
        exitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.DEFAULT);
                exitButton.setBackground(null);
            }
        });
        menuHamburgerButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //Start transition
            }
        });
        menuHamburgerButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.HAND);
                menuHamburgerButton.setBackground(smallIconBackground);
            }
        });
        menuHamburgerButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.DEFAULT);
                menuHamburgerButton.setBackground(null);
            }
        });
    }

    private void startTransition(int animationDuration, int animationYTransition, boolean transitionAutoReverse, int transitionCycleCount, Node node){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(animationDuration));
        transition.setToY(animationYTransition);
        transition.setAutoReverse(transitionAutoReverse);
        transition.setCycleCount(transitionCycleCount);
        transition.setNode(node);
        transition.play();
    }

    ImageView getMovieButton(){
        return movieButtonIV;
    }
    ImageView getTv_seriesButton(){
        return tv_seriesButtonIV;
    }
    //ImageView getExitButton(){
        //return exitButton;
    //}

    private void initView(){

        this.setPrefSize(windowWidth,windowHeight);

        //TODO kolla om dessa images ska flyttas till IO (förmodligen)
        mainMenuOutlineIcon = new Image("mainMenuOutlineIcon.png");
        mainMenuImage = new Image("backgroundImage.png");
        exitButtonImage = new Image("cross.png");
        menuHamburgerButtonImage = new Image("menu-burger.png");
        movieButtonIV = new ImageView();
        tv_seriesButtonIV = new ImageView();
        backgroundIV = new ImageView();
        exitButtonIV = new ImageView();
        menuHamburgerButtonIV = new ImageView();
        exitButton = new Pane();
        movieButton = new Pane();
        tv_seriesButton = new Pane();
        menuHamburgerButton = new Pane();
        previewWindow = new Pane();
        exitButton.getChildren().add(exitButtonIV);
        movieButton.getChildren().add(movieButtonIV);
        tv_seriesButton.getChildren().add(tv_seriesButtonIV);
        menuHamburgerButton.getChildren().add(menuHamburgerButtonIV);
        movieButtonIV.setImage(mainMenuOutlineIcon);
        tv_seriesButtonIV.setImage(mainMenuOutlineIcon);
        backgroundIV.setImage(mainMenuImage);
        exitButtonIV.setImage(exitButtonImage);
        menuHamburgerButtonIV.setImage(menuHamburgerButtonImage);
        smallIconBackground = new Background(new BackgroundFill(Color.web("0x0f094d"),new CornerRadii(10),new Insets(-5)));
        previewWindow.setBorder(new Border(new BorderStroke(Color.web("0xF4F4F4"),BorderStrokeStyle.SOLID,new CornerRadii(10),BorderWidths.DEFAULT)));

        mainMenuView();
    }
}






//????
//Border previewWindowBorder = new Border(new BorderStroke(Color.web("0x000000"),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));
//        this.setBorder(previewWindowBorder);