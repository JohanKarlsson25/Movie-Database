package johkar2.kth.se.moviedatabase.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import johkar2.kth.se.moviedatabase.model.Model;

public class Controller {

    private StartMenuView startMenuView;
    private MainMenuView mainMenuView;
    private Model model;
    private Scene startMenuScene,mainMenuScene;
    private Stage stage;

    public Controller(StartMenuView view, Scene scene, Stage stage){

        this.startMenuScene = scene;
        this.stage = stage;
        this.startMenuView = view;
        this.model = new Model();
        this.mainMenuView = new MainMenuView();
        startMenuView.addEventHandlers(this);
        this.mainMenuScene = new Scene(mainMenuView);
        mainMenuView.addEventHandlers(this);
    }

    void handleEnterSelected(){
        stage.setScene(mainMenuScene);
    }

    void handleHomeSelected(){
        stage.setScene(startMenuScene);
    }

    void handleMenuHamburger(boolean flipped){
        if (flipped) mainMenuView.hideMenuHamburgerSubMenu();
        else mainMenuView.showMenuHamburgerSubMenu();
    }

    /*void handleMenuHamburger(boolean flipped){
        view.rotateMenuHamburger();
        if (flipped) view.hideSubMenuButtons();
        else view.showSubMenuButtons();
    }*/

    /*void handleHover(Object source){
        if (source.equals(view.getMovieButton())){
            System.out.println("Movie hover");
        } else if (source.equals(view.getTv_seriesButton())){
            System.out.println("tvseries hover");
        } //else if (source.equals(view.getExitButton())){
            //view.setCursor(Cursor.HAND);
        //}
    }

    void handleMyLibrary(ApplicationState applicationState){
        view.generateMyLibraryList((applicationState == ApplicationState.MOVIE_SUBMENU) ? model.getAllMovies() : model.getAllTv_Series());
        view.showMyLibrary();
    }*/

    void handleAdd(ApplicationState applicationState){
        switch (applicationState){
            //case MOVIE_SUBMENU : model.addMovie(); break;
            case TV_SERIESMENU : model.addTv_Series(); break;
        }
    }

    void handleExitRequest() {
        try{
            model.writeToFile();
        } catch (Exception e){
            //view.alert();
        }
        System.exit(0);
    }
}
