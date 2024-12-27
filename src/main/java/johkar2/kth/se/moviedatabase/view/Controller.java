package johkar2.kth.se.moviedatabase.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import johkar2.kth.se.moviedatabase.model.Media;
import johkar2.kth.se.moviedatabase.model.Model;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private StartMenuView startMenuView;
    private MainMenuView mainMenuView;
    private Model model;
    private Scene startMenuScene,mainMenuScene;
    private Stage stage;

    public Controller(StartMenuView view, Scene scene, Stage stage) {
        this.startMenuScene = scene;
        this.stage = stage;
        this.startMenuView = view;
        this.mainMenuView = new MainMenuView();
        startMenuView.addEventHandlers(this);
        this.mainMenuScene = new Scene(mainMenuView);
        mainMenuView.addEventHandlers(this);

        try {
            this.model = new Model();
        } catch (Exception e){
            e.printStackTrace();
        }
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

    void handleMyLibrarySelected(){
        handleBrowseSelected();
    }

    void handleWatchListSelected(){

    }

    void handleHallOfFameSelected(){

    }

    void handleMountRushmoreSelected(){

    }

    void handleBrowseSelected(){
        List<Media> mediaList = model.getAllMedia();
        mainMenuView.showBrowse(generateIconObjects(mediaList));
    }

    void handleHover(IconObject iconObject){
        mainMenuView.hoverIconObject(iconObject);
    }

    void handleHoverEnded(IconObject iconObject){
        mainMenuView.unHoverIconObject(iconObject);
    }

    /*void handleMenuHamburger(boolean flipped){
        view.rotateMenuHamburger();
        if (flipped) view.hideSubMenuButtons();
        else view.showSubMenuButtons();
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
            e.printStackTrace();
            System.out.println("Exit funkade inte");
        }
        System.exit(0);
    }

    private List<IconObject> generateIconObjects(List<Media> mediaList){
        List<IconObject> iconObjectList = new ArrayList<>();
        for (Media m : mediaList){
            iconObjectList.add(new IconObject(m.getTitle(),this));
        }

        return iconObjectList;
    }
}
