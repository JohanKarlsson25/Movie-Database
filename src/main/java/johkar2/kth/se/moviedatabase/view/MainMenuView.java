package johkar2.kth.se.moviedatabase.view;

import javafx.scene.Cursor;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class MainMenuView extends View {

    private boolean flipped;

    private ImageView exitButtonImageView,menuHamburgerButtonImageView,myLibraryButtonImageView,watchListButtonImageView,
            hallOfFameButtonImageView,mountRushmoreButtonImageView,homeButtonImageView,mostRecentWatchImageView;
    private Image exitButtonImage,menuHamburgerImage,myLibraryButtonImage,watchListButtonImage,hallOfFameButtonImage,
            mountRushmoreButtonImage,homeButtonImage,mostRecentWatchImage;
    private Pane exitButton,menuHamburgerButton,previewWindow,myLibraryButton,centerStage,watchListButton,hallOfFameButton,mountRushmoreButton,homeButton;
    private Text myLibraryText, watchListText, hallOfFameText, mountRushmoreText;
    //Skulle va snyggt med egen definierad Button class som gör att man kan lägga text hur som helst.

    List<IconObject> iconObjectList = new ArrayList<>();

    private ScrollPane myLibraryScrollPane;
    private List<MyLibraryLine> myLibraryList;

    public MainMenuView(){
        super();
        initUI();
        flipped = false;
    }

    void showBrowse(List<IconObject> iconObjectList){
        centerStage.getChildren().clear();

        this.iconObjectList = iconObjectList;

        int spacingValue = 0;
        for (IconObject iconObject : iconObjectList){
            centerStage.getChildren().add(iconObject);
            iconObject.relocate(200*spacingValue++ + spacingValue*10,10); //I want two Rows. Maybe one with TV_series one movies or category switch between TV movie //DESIGN
        }
    }

    void hoverIconObject(IconObject objectToBeHovered){
        objectToBeHovered.relocate(iconObjectList.indexOf(objectToBeHovered)*210 + 10, 5);
    }

    void unHoverIconObject(IconObject currentHoveredObject){
        currentHoveredObject.relocate(iconObjectList.indexOf(currentHoveredObject)*210 + 10,10);
    }

    void addEventHandlers(Controller controller){
        exitButton.setOnMouseClicked(mouseEvent -> {
            controller.handleExitRequest();});
        exitButton.setOnMouseEntered(mouseEvent -> {
            setCursor(Cursor.HAND);
            exitButton.setBackground(smallIconBackground);});
        exitButton.setOnMouseExited(mouseEvent -> {
            setCursor(Cursor.DEFAULT);
            exitButton.setBackground(null);});

        homeButton.setOnMouseClicked(mouseEvent -> {
            controller.handleHomeSelected();});
        homeButton.setOnMouseEntered(mouseEvent -> {
            setCursor(Cursor.HAND);
            homeButton.setBackground(smallIconBackground);});
        homeButton.setOnMouseExited(mouseEvent -> {
            setCursor(Cursor.DEFAULT);
            homeButton.setBackground(null);});

        menuHamburgerButton.setOnMouseClicked(mouseEvent -> {
            AnimationHandler.rotateObject(menuHamburgerButton,500,180,false,1);
            controller.handleMenuHamburger(flipped);});
        menuHamburgerButton.setOnMouseEntered(mouseEvent -> {
            setCursor(Cursor.HAND);
            menuHamburgerButton.setBackground(smallIconBackground);});
        menuHamburgerButton.setOnMouseExited(mouseEvent -> {
            setCursor(Cursor.DEFAULT);
            menuHamburgerButton.setBackground(null);});

        myLibraryButton.setOnMouseClicked(mouseEvent -> {
            controller.handleMyLibrarySelected();});
        myLibraryButton.setOnMouseEntered(mouseEvent -> {
            setCursor(Cursor.HAND);
            myLibraryButton.setBackground(smallIconBackground);});
        myLibraryButton.setOnMouseExited(mouseEvent -> {
            setCursor(Cursor.DEFAULT);
            myLibraryButton.setBackground(null);});

        watchListButton.setOnMouseClicked(mouseEvent -> {
            controller.handleWatchListSelected();});
        watchListButton.setOnMouseEntered(mouseEvent -> {
            setCursor(Cursor.HAND);
            watchListButton.setBackground(smallIconBackground);});
        watchListButton.setOnMouseExited(mouseEvent -> {
            setCursor(Cursor.DEFAULT);
            watchListButton.setBackground(null);});

        hallOfFameButton.setOnMouseClicked(mouseEvent -> {
            controller.handleHallOfFameSelected();});
        hallOfFameButton.setOnMouseEntered(mouseEvent -> {
            setCursor(Cursor.HAND);
            hallOfFameButton.setBackground(smallIconBackground);});
        hallOfFameButton.setOnMouseExited(mouseEvent -> {
            setCursor(Cursor.DEFAULT);
            hallOfFameButton.setBackground(null);});

        mountRushmoreButton.setOnMouseClicked(mouseEvent -> {
            controller.handleMountRushmoreSelected();});
        mountRushmoreButton.setOnMouseEntered(mouseEvent -> {
            setCursor(Cursor.HAND);
            mountRushmoreButton.setBackground(smallIconBackground);});
        mountRushmoreButton.setOnMouseExited(mouseEvent -> {
            setCursor(Cursor.DEFAULT);
            mountRushmoreButton.setBackground(null);});
    }

    void showMenuHamburgerSubMenu(){
        this.getChildren().addAll(myLibraryButton,watchListButton,hallOfFameButton,mountRushmoreButton);
        AnimationHandler.startFadeTransition(myLibraryButton,this,400,75,false,1,false);
        AnimationHandler.startFadeTransition(watchListButton,this,400,150,false,1,false);
        AnimationHandler.startFadeTransition(hallOfFameButton,this,400,225,false,1,false);
        AnimationHandler.startFadeTransition(mountRushmoreButton,this,400,300,false,1,false);
        flipped = true;
    }

    void hideMenuHamburgerSubMenu(){
        AnimationHandler.startFadeTransition(myLibraryButton,this,400,0,false,1,true);
        AnimationHandler.startFadeTransition(watchListButton,this,400,0,false,1,true);
        AnimationHandler.startFadeTransition(hallOfFameButton,this,400,0,false,1,true);
        AnimationHandler.startFadeTransition(mountRushmoreButton,this,400,0,false,1,true);
        flipped = false;
    }

    private void initUI(){

        //Init Background color
        this.setStyle("-fx-background-color: #05031a;");

        //Load all component images
        menuHamburgerImage = new Image("menu-burger.png");
        exitButtonImage = new Image("cross.png");
        myLibraryButtonImage = new Image("myLibraryIcon.png");
        watchListButtonImage = new Image("to-do.png");
        hallOfFameButtonImage = new Image("crown.png");
        mountRushmoreButtonImage = new Image("mount-rushmore (1).png");
        homeButtonImage = new Image("home.png");

        //Create all Imageviews
        exitButtonImageView = new ImageView();
        menuHamburgerButtonImageView = new ImageView();
        myLibraryButtonImageView = new ImageView();
        watchListButtonImageView = new ImageView();
        hallOfFameButtonImageView = new ImageView();
        mountRushmoreButtonImageView = new ImageView();
        homeButtonImageView = new ImageView();
        mostRecentWatchImageView = new ImageView();

        //Create all the components Panes
        exitButton = new Pane();
        menuHamburgerButton = new Pane();
        previewWindow = new Pane();
        myLibraryButton = new Pane();
        centerStage = new Pane();
        watchListButton = new Pane();
        hallOfFameButton = new Pane();
        mountRushmoreButton = new Pane();
        homeButton = new Pane();

        //Create all the Text objects
        myLibraryText = new Text("My Library");
        watchListText = new Text("Watch List");
        hallOfFameText = new Text("Hall of Fame");
        mountRushmoreText = new Text("Mount Rushmore");

        //Defining properties of Texts
        myLibraryText.setFont(buttonTextFont);
        myLibraryText.setFill(Color.WHITE);
        watchListText.setFont(buttonTextFont);
        watchListText.setFill(Color.WHITE);
        hallOfFameText.setFont(buttonTextFont);
        hallOfFameText.setFill(Color.WHITE);
        mountRushmoreText.setFont(buttonTextFont);
        mountRushmoreText.setFill(Color.WHITE);

        //Place all fixed components
        exitButton.relocate(windowWidth*14.0/15,windowHeight*5.0/216);
        menuHamburgerButton.relocate(windowWidth*10.0/192,windowHeight*10.0/108);
        centerStage.relocate(450,windowHeight*10.0/108);
        homeButton.relocate(windowWidth*13.4/15,windowHeight*5.0/216);
        previewWindow.relocate(windowWidth*11.0/15,windowHeight*10.0/108);
        myLibraryButton.relocate(windowWidth*10.0/192,windowHeight*10.0/108);
        watchListButton.relocate(windowWidth*10.0/192,windowHeight*10.0/108);
        hallOfFameButton.relocate(windowWidth*10.0/192,windowHeight*10.0/108);
        mountRushmoreButton.relocate(windowWidth*10.0/192,windowHeight*10.0/108);

        //Add the imageViews on to the respective button
        exitButton.getChildren().add(exitButtonImageView);
        menuHamburgerButton.getChildren().add(menuHamburgerButtonImageView);
        myLibraryButton.getChildren().add(myLibraryButtonImageView);
        watchListButton.getChildren().add(watchListButtonImageView);
        hallOfFameButton.getChildren().add(hallOfFameButtonImageView);
        mountRushmoreButton.getChildren().add(mountRushmoreButtonImageView);
        homeButton.getChildren().add(homeButtonImageView);

        //Add the texts to the Buttons
        myLibraryButton.getChildren().add(myLibraryText);
        watchListButton.getChildren().add(watchListText);
        hallOfFameButton.getChildren().add(hallOfFameText);
        mountRushmoreButton.getChildren().add(mountRushmoreText);

        //Bind text to respective icon
        myLibraryText.relocate(myLibraryButtonImageView.getX() + 50, myLibraryButtonImageView.getY() + 3);
        watchListText.relocate(watchListButtonImageView.getX() + 50, watchListButtonImageView.getY() + 3);
        hallOfFameText.relocate(hallOfFameButtonImageView.getX() + 50, hallOfFameButtonImageView.getY() + 3);
        mountRushmoreText.relocate(mountRushmoreButtonImageView.getX() + 50, mountRushmoreButtonImageView.getY() + 3);

        //Define specified sizes of components
        centerStage.setPrefSize(850,600);
        previewWindow.setPrefSize(10,10);

        //Set border of bordered components
        centerStage.setBorder(border);
        previewWindow.setBorder(border);

        //Add all fixed components to the view
        this.getChildren().addAll(exitButton,menuHamburgerButton,centerStage,previewWindow,homeButton);

        //Set all the images to respective imageView
        exitButtonImageView.setImage(exitButtonImage);
        menuHamburgerButtonImageView.setImage(menuHamburgerImage);
        homeButtonImageView.setImage(homeButtonImage);
        myLibraryButtonImageView.setImage(myLibraryButtonImage);
        watchListButtonImageView.setImage(watchListButtonImage);
        hallOfFameButtonImageView.setImage(hallOfFameButtonImage);
        mountRushmoreButtonImageView.setImage(mountRushmoreButtonImage);
    }
}
