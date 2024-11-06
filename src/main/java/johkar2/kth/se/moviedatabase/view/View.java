package johkar2.kth.se.moviedatabase.view;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import johkar2.kth.se.moviedatabase.model.Media;

import java.util.ArrayList;
import java.util.List;

public class View extends Pane {

    private final int windowWidth = 1500, windowHeight = 900;
    private ApplicationState applicationState;

    //GUI Components
    private ImageView backgroundIV, movieButtonIV, tv_seriesButtonIV, exitButtonIV, menuHamburgerButtonIV, myLibraryButtonIV;
    private Pane movieButton, tv_seriesButton, exitButton, menuHamburgerButton, previewWindow, myLibrary, myLibraryButton, centerStage;
    private ScrollPane myLibraryScrollPane;
    private Image mainMenuImage, mainMenuOutlineIcon, exitButtonImage, menuHamburgerButtonImage, myLibraryButtonImage;
    private Background smallIconBackground;
    private Border border;
    private List<MyLibraryLine> myLibraryList;

    private Text text;

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

    void showMyLibrary(){

        centerStage.getChildren().clear();
        myLibraryScrollPane.setContent(myLibrary);
        centerStage.getChildren().add(myLibraryScrollPane);
    }

    void movieView(){

        this.getChildren().clear();
        this.applicationState = ApplicationState.MOVIE_SUBMENU;
        this.setStyle("-fx-background-color: #05031a;");
        this.getChildren().addAll(exitButton,menuHamburgerButton,previewWindow,centerStage,myLibraryButton);

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
                try {
                    controller.handleExitRequest();
                } catch (Exception e) {
                    try {//WTFFFF
                        throw new Exception(e);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
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
        myLibraryButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.HAND);
                myLibraryButton.setBackground(smallIconBackground);
            }
        });
        myLibraryButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.DEFAULT);
                myLibraryButton.setBackground(null);
            }
        });
        myLibraryButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleMyLibrary(applicationState);
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

    void generateMyLibraryList(List<Media> listOfSpecificMedia){
        int yFactor = 0;
        for (Media media : listOfSpecificMedia) {
            MyLibraryLine line = new MyLibraryLine(media.getTitle(), media.getYear(),
                    media.getHours(), media.getMinutes(), media.getRating());
            myLibrary.getChildren().add(line);
            line.setTranslateY(yFactor);
            yFactor += 39;
        }
        myLibrary.setBorder(border);
    }

    private void initView(){

        this.setPrefSize(windowWidth,windowHeight);

        //TODO kolla om dessa images ska flyttas till IO (förmodligen)
        mainMenuOutlineIcon = new Image("mainMenuOutlineIcon.png");
        mainMenuImage = new Image("backgroundImage.png");
        exitButtonImage = new Image("cross.png");
        menuHamburgerButtonImage = new Image("menu-burger.png");
        myLibraryButtonImage = new Image("myLibraryIcon.png");
        movieButtonIV = new ImageView();
        tv_seriesButtonIV = new ImageView();
        backgroundIV = new ImageView();
        exitButtonIV = new ImageView();
        menuHamburgerButtonIV = new ImageView();
        myLibraryButtonIV = new ImageView();
        exitButton = new Pane();
        movieButton = new Pane();
        tv_seriesButton = new Pane();
        menuHamburgerButton = new Pane();
        previewWindow = new Pane();
        myLibrary = new Pane();
        myLibraryButton = new Pane();
        centerStage = new Pane();
        myLibraryScrollPane = new ScrollPane();
        myLibraryScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        exitButton.getChildren().add(exitButtonIV);
        movieButton.getChildren().add(movieButtonIV);
        tv_seriesButton.getChildren().add(tv_seriesButtonIV);
        menuHamburgerButton.getChildren().add(menuHamburgerButtonIV);
        myLibraryButton.getChildren().add(myLibraryButtonIV);
        movieButtonIV.setImage(mainMenuOutlineIcon);
        tv_seriesButtonIV.setImage(mainMenuOutlineIcon);
        backgroundIV.setImage(mainMenuImage);
        exitButtonIV.setImage(exitButtonImage);
        menuHamburgerButtonIV.setImage(menuHamburgerButtonImage);
        myLibraryButtonIV.setImage(myLibraryButtonImage);
        text = new Text("My Library");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        text.setFill(Color.WHITE);
        myLibraryButton.getChildren().add(text);
        text.relocate(50,0);
        exitButton.relocate(1400,25);
        centerStage.relocate(500,100);
        centerStage.setPrefSize(500,700);
        myLibraryScrollPane.setPrefSize(500,700);
        menuHamburgerButton.relocate(100,100);
        previewWindow.relocate(1100,100);
        previewWindow.setPrefSize(350,700);
        myLibraryButton.relocate(100,175);

        smallIconBackground = new Background(new BackgroundFill(Color.web("0x0f094d"),new CornerRadii(10),new Insets(-5)));
        border = new Border(new BorderStroke(Color.web("0xF4F4F4"),BorderStrokeStyle.SOLID,new CornerRadii(10),BorderWidths.DEFAULT));
        previewWindow.setBorder(border);
        centerStage.setBorder(border);

        myLibraryList = new ArrayList<>();

        mainMenuView();
    }
}