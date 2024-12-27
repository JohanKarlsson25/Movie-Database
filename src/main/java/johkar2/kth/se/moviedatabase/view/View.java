package johkar2.kth.se.moviedatabase.view;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.List;

public class View extends Pane {

    protected final int windowWidth, windowHeight;
    protected ApplicationState applicationState;
    protected final Border border = new Border(new BorderStroke(Color.web("0xF4F4F4"),BorderStrokeStyle.SOLID,new CornerRadii(10),BorderWidths.DEFAULT));
    protected final Background smallIconBackground = new Background(new BackgroundFill(Color.web("0x0f094d"),new CornerRadii(10),new Insets(-5)));
    protected final Font buttonTextFont = new Font("Book Antiqua Bold",20);

    //GUI Components
    private ScrollPane myLibraryScrollPane;
    private List<MyLibraryLine> myLibraryList;
    private Text myLibraryText, watchListText, hallOfFameText, mountRushmoreText;

    public View(){
        //initView();
        this.applicationState = ApplicationState.MAIN_MENU;
        Rectangle2D screenSize = Screen.getPrimary().getBounds();
        System.out.println(screenSize);
        windowWidth = (int) (screenSize.getWidth()*0.9);
        windowHeight = (int) (screenSize.getHeight()*0.9); //big issues, I need to make every fixed component bind to screensize
        this.setPrefSize(windowWidth,windowHeight);
    }
/*
    void mainMenuView(){

        this.getChildren().clear();
        this.getChildren().add(backgroundIV);
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
    }*/
/*
    void movieView(){

        this.getChildren().clear();
        this.applicationState = ApplicationState.MOVIE_SUBMENU;
        this.setStyle("-fx-background-color: #05031a;");
        centerStage.getChildren().clear();
        centerStage.getChildren().add(mostRecentWatchIV);
        this.getChildren().addAll(exitButton,menuHamburgerButton,previewWindow,centerStage,homeButton);
    }*/

    /*void addEventHandlers(Controller controller){

        movieButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //controller.handleMovieSelected();
            }
        });
        tv_seriesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //controller.handleTvSeriesSelected();
            }
        });
        movieButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //controller.handleHover(mouseEvent.getSource());
            }
        });
        tv_seriesButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //controller.handleHover(mouseEvent.getSource());
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
                //controller.handleMenuHamburger(flipped);
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
                //controller.handleMyLibrary(applicationState);
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
    }*/
/*
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


        previewWindow = new Pane();
        centerStage = new Pane();

        centerStage.relocate(500,100);
        centerStage.setPrefSize(500,700);

        previewWindow.relocate(1100,100);
        previewWindow.setPrefSize(350,700);

        previewWindow.setBorder(border);
        centerStage.setBorder(border);

        myLibraryList = new ArrayList<>();

        flipped = false;

        mainMenuView();
    }*/
}