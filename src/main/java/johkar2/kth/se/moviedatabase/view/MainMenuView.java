package johkar2.kth.se.moviedatabase.view;

import javafx.scene.Cursor;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import java.util.List;

public class MainMenuView extends View {

    private boolean flipped;

    private ImageView exitButtonImageView,menuHamburgerButtonImageView,myLibraryButtonImageView,watchListButtonImageView,
            hallOfFameButtonImageView,mountRushmoreButtonImageView,homeButtonImageView,mostRecentWatchImageView;
    private Image exitButtonImage,menuHamburgerImage,myLibraryButtonImage,watchListButtonImage,hallOfFameButtonImage,mountRushmoreButtonImage,homeButtonImage,mostRecentWatchImage;
    private Pane exitButton,menuHamburgerButton,previewWindow,myLibraryButton,centerStage,watchListButton,hallOfFameButton,mountRushmoreButton,homeButton;
    //Skulle va snyggt med egen definierad Button class som gör att man kan lägga text hur som helst.

    private ScrollPane myLibraryScrollPane;
    private List<MyLibraryLine> myLibraryList;
    private Text myLibraryText, watchListText, hallOfFameText, mountRushmoreText;



    public MainMenuView(){
        super();
        initUI();
        flipped = false;
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
            AnimationHandler.rotateObject(menuHamburgerButton,700,180,false,1);
            controller.handleMenuHamburger(flipped);});
        menuHamburgerButton.setOnMouseEntered(mouseEvent -> {
            setCursor(Cursor.HAND);
            menuHamburgerButton.setBackground(smallIconBackground);});
        menuHamburgerButton.setOnMouseExited(mouseEvent -> {
            setCursor(Cursor.DEFAULT);
            menuHamburgerButton.setBackground(null);});


    }

    void showMenuHamburgerSubMenu(){
        this.getChildren().addAll(myLibraryButton,watchListButton,hallOfFameButton,mountRushmoreButton);
        AnimationHandler.startTransition(myLibraryButton,this,500,75,false,1,false);
        AnimationHandler.startTransition(watchListButton,this,500,150,false,1,false);
        AnimationHandler.startTransition(hallOfFameButton,this,500,225,false,1,false);
        AnimationHandler.startTransition(mountRushmoreButton,this,500,300,false,1,false);
        flipped = true;
    }

    void hideMenuHamburgerSubMenu(){
        AnimationHandler.startTransition(myLibraryButton,this,500,0,false,1,true);
        AnimationHandler.startTransition(watchListButton,this,500,0,false,1,true);
        AnimationHandler.startTransition(hallOfFameButton,this,500,0,false,1,true);
        AnimationHandler.startTransition(mountRushmoreButton,this,500,0,false,1,true);
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

        //Place all fixed components
        exitButton.relocate(1400,25);
        menuHamburgerButton.relocate(100,100);
        centerStage.relocate(500,100);
        homeButton.relocate(1300,25);
        previewWindow.relocate(1100,100);
        myLibraryButton.relocate(100,100);
        watchListButton.relocate(100,100);
        hallOfFameButton.relocate(100,100);
        mountRushmoreButton.relocate(100,100);

        //Add the imageViews on to the respective button
        exitButton.getChildren().add(exitButtonImageView);
        menuHamburgerButton.getChildren().add(menuHamburgerButtonImageView);
        myLibraryButton.getChildren().add(myLibraryButtonImageView);
        watchListButton.getChildren().add(watchListButtonImageView);
        hallOfFameButton.getChildren().add(hallOfFameButtonImageView);
        mountRushmoreButton.getChildren().add(mountRushmoreButtonImageView);
        homeButton.getChildren().add(homeButtonImageView);

        //Define specified sizes of components
        centerStage.setPrefSize(500,700);
        previewWindow.setPrefSize(350,700);

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
