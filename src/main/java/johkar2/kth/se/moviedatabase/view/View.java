package johkar2.kth.se.moviedatabase.view;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
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
    private ImageView backgroundIV, movieButtonIV, tv_seriesButtonIV, exitButtonIV, menuHamburgerButtonIV,
            myLibraryButtonIV, watchListButtonIV, hallOfFameButtonIV, mountRushmoreButtonIV, homeButtonIV, mostRecentWatchIV;
    private Pane movieButton, tv_seriesButton, exitButton, menuHamburgerButton, previewWindow, myLibrary,
            myLibraryButton, centerStage, watchListButton, hallOfFameButton, mountRushmoreButton, homeButton;
    private ScrollPane myLibraryScrollPane;
    private Image mainMenuImage, mainMenuOutlineIcon, exitButtonImage, menuHamburgerButtonImage, myLibraryButtonImage,
            watchListButtonImage, hallOfFameButtonImage, mountRushmoreButtonImage, homeButtonImage, mostRecentWatchImage;
    private Background smallIconBackground;
    private Border border;
    private List<MyLibraryLine> myLibraryList;
    private Text myLibraryText, watchListText, hallOfFameText, mountRushmoreText;
    private boolean flipped;

    public View(Stage stage){
        initView();
        this.applicationState = ApplicationState.MAIN_MENU;
    }

    void mainMenuView(){

        this.getChildren().clear();
        this.getChildren().add(backgroundIV);
        startTransition(30000,-3000,true,Animation.INDEFINITE,backgroundIV);
        this.getChildren().addAll(movieButton,tv_seriesButton);
        movieButton.relocate(400,500);
        tv_seriesButton.relocate(windowWidth-400-mainMenuOutlineIcon.getWidth(),500);
    }

    void showMyLibrary(){

        centerStage.getChildren().clear();
        myLibraryScrollPane.setContent(myLibrary);
        centerStage.getChildren().add(myLibraryScrollPane);
    }

    void showSubMenuButtons() throws InterruptedException {
        this.getChildren().addAll(myLibraryButton,watchListButton,hallOfFameButton,mountRushmoreButton);
        Thread transitionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                startTransition(500,75,false,1,myLibraryButton);
                startTransition(500,150,false,1,watchListButton);
                startTransition(500,225,false,1,hallOfFameButton);
                startTransition(500,300,false,1,mountRushmoreButton);
            }
        });
        transitionThread.start();
        transitionThread.join();
        flipped = true;
    }

    void hideSubMenuButtons() throws InterruptedException { //Ska ju INTE uppdatera detta från en tråd
        Thread transitionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                startTransition(500,0,false,1,myLibraryButton);
                startTransition(500,0,false,1,watchListButton);
                startTransition(500,0,false,1,hallOfFameButton);
                startTransition(500,0,false,1,mountRushmoreButton);
            }
        });
        transitionThread.start();
        //this.getChildren().removeAll(myLibraryButton,watchListButton,hallOfFameButton,mountRushmoreButton);
        flipped = false;
    }

    void movieView(){

        this.getChildren().clear();
        this.applicationState = ApplicationState.MOVIE_SUBMENU;
        this.setStyle("-fx-background-color: #05031a;");
        centerStage.getChildren().clear();
        centerStage.getChildren().add(mostRecentWatchIV);
        this.getChildren().addAll(exitButton,menuHamburgerButton,previewWindow,centerStage,homeButton);
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
                System.out.println(flipped);
                controller.handleMenuHamburger(flipped);
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
        watchListButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.HAND);
                watchListButton.setBackground(smallIconBackground);
            }
        });
        watchListButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.DEFAULT);
                watchListButton.setBackground(null);
            }
        });
        watchListButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //controller.handleWatchlist();
            }
        });
        hallOfFameButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.HAND);
                hallOfFameButton.setBackground(smallIconBackground);
            }
        });
        hallOfFameButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.DEFAULT);
                hallOfFameButton.setBackground(null);
            }
        });
        hallOfFameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //controller.handleHallOfFame();
            }
        });
        homeButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.HAND);
                homeButton.setBackground(smallIconBackground);
            }
        });
        homeButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.DEFAULT);
                homeButton.setBackground(null);
            }
        });
        homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                applicationState = ApplicationState.MAIN_MENU;
                mainMenuView();
            }
        });
        mountRushmoreButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.HAND);
                mountRushmoreButton.setBackground(smallIconBackground);
            }
        });
        mountRushmoreButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.DEFAULT);
                mountRushmoreButton.setBackground(null);
            }
        });
    }

    private void startTransition(int animationDuration, int animationYTransition, boolean transitionAutoReverse, int transitionCycleCount, Node node){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(animationDuration));
        transition.setToY(animationYTransition);
        transition.setAutoReverse(transitionAutoReverse);
        transition.setCycleCount(transitionCycleCount);
        transition.setNode(node);
        transition.play();
        if (animationYTransition < 1){
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getChildren().remove(node);
            }
        });}
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
        watchListButtonImage = new Image("to-do.png");
        hallOfFameButtonImage = new Image("crown.png");
        mountRushmoreButtonImage = new Image("mount-rushmore (1).png");
        homeButtonImage = new Image("home.png");
        mostRecentWatchImage = new Image("Django-Unchained.png");
        movieButtonIV = new ImageView();
        tv_seriesButtonIV = new ImageView();
        backgroundIV = new ImageView();
        exitButtonIV = new ImageView();
        menuHamburgerButtonIV = new ImageView();
        myLibraryButtonIV = new ImageView();
        watchListButtonIV = new ImageView();
        hallOfFameButtonIV = new ImageView();
        mountRushmoreButtonIV = new ImageView();
        homeButtonIV = new ImageView();
        mostRecentWatchIV = new ImageView();
        homeButton = new Pane();
        mountRushmoreButton = new Pane();
        exitButton = new Pane();
        movieButton = new Pane();
        tv_seriesButton = new Pane();
        menuHamburgerButton = new Pane();
        previewWindow = new Pane();
        myLibrary = new Pane();
        myLibraryButton = new Pane();
        centerStage = new Pane();
        watchListButton = new Pane();
        hallOfFameButton = new Pane();
        myLibraryScrollPane = new ScrollPane();
        myLibraryScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        exitButton.getChildren().add(exitButtonIV);
        movieButton.getChildren().add(movieButtonIV);
        tv_seriesButton.getChildren().add(tv_seriesButtonIV);
        menuHamburgerButton.getChildren().add(menuHamburgerButtonIV);
        myLibraryButton.getChildren().add(myLibraryButtonIV);
        watchListButton.getChildren().add(watchListButtonIV);      //Tänk på TODO Varför har jag olika imageviews? måste gå att göra annat
        hallOfFameButton.getChildren().add(hallOfFameButtonIV);
        mountRushmoreButton.getChildren().add(mountRushmoreButtonIV);
        homeButton.getChildren().add(homeButtonIV);
        movieButtonIV.setImage(mainMenuOutlineIcon);
        tv_seriesButtonIV.setImage(mainMenuOutlineIcon);
        backgroundIV.setImage(mainMenuImage);
        exitButtonIV.setImage(exitButtonImage);
        menuHamburgerButtonIV.setImage(menuHamburgerButtonImage);
        myLibraryButtonIV.setImage(myLibraryButtonImage);
        watchListButtonIV.setImage(watchListButtonImage);
        hallOfFameButtonIV.setImage(hallOfFameButtonImage);
        mountRushmoreButtonIV.setImage(mountRushmoreButtonImage);
        homeButtonIV.setImage(homeButtonImage);
        mostRecentWatchIV.setImage(mostRecentWatchImage);
        mostRecentWatchIV.setViewport(new Rectangle2D(0,0,500,700));
        myLibraryText = new Text("My Library");
        watchListText = new Text("Watchlist");
        hallOfFameText = new Text("Hall of Fame");
        mountRushmoreText = new Text("Mount Rushmore");
        myLibraryText.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        myLibraryText.setFill(Color.WHITE);
        myLibraryButton.getChildren().add(myLibraryText);
        myLibraryText.relocate(50,0);
        watchListText.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        watchListText.setFill(Color.WHITE);
        watchListButton.getChildren().add(watchListText);
        watchListText.relocate(50,0);
        hallOfFameText.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        hallOfFameText.setFill(Color.WHITE);
        hallOfFameButton.getChildren().add(hallOfFameText);
        mountRushmoreText.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        mountRushmoreText.setFill(Color.WHITE);
        mountRushmoreButton.getChildren().add(mountRushmoreText);
        mountRushmoreText.relocate(50,0);
        hallOfFameText.relocate(50,0);
        exitButton.relocate(1400,25);
        homeButton.relocate(1300,25);
        centerStage.relocate(500,100);
        centerStage.setPrefSize(500,700);
        myLibraryScrollPane.setPrefSize(500,700);
        menuHamburgerButton.relocate(100,100);
        previewWindow.relocate(1100,100);
        previewWindow.setPrefSize(350,700);
        myLibraryButton.relocate(100,100);
        watchListButton.relocate(100,100);
        hallOfFameButton.relocate(100,100);
        mountRushmoreButton.relocate(100,100);

        smallIconBackground = new Background(new BackgroundFill(Color.web("0x0f094d"),new CornerRadii(10),new Insets(-5)));
        border = new Border(new BorderStroke(Color.web("0xF4F4F4"),BorderStrokeStyle.SOLID,new CornerRadii(10),BorderWidths.DEFAULT));
        previewWindow.setBorder(border);
        centerStage.setBorder(border);

        myLibraryList = new ArrayList<>();

        flipped = false;

        mainMenuView();
    }
}