package johkar2.kth.se.moviedatabase.view;

import javafx.scene.Cursor;
import johkar2.kth.se.moviedatabase.model.Model;

import java.io.IOException;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
        this.view.addEventHandlers(this);
    }

    void handleTvSeriesSelected(){
        System.out.println("TV");
    }

    void handleMovieSelected(){
        view.movieView();
    }

    void handleHover(Object source){
        if (source.equals(view.getMovieButton())){
            System.out.println("Movie hover");
        } else if (source.equals(view.getTv_seriesButton())){
            System.out.println("tvseries hover");
        } //else if (source.equals(view.getExitButton())){
            //view.setCursor(Cursor.HAND);
        //}
    }

    void handleMyLibrary(){
        view.generateMyLibraryList();
        view.showMyLibrary();
    }

    void handleAdd(ApplicationState applicationState){
        switch (applicationState){
            //case MOVIE_SUBMENU : model.addMovie(); break;
            case TV_SERIESMENU : model.addTv_Series(); break;
        }
    }

    void handleExitRequest() throws IOException {
        model.writeToFile();
        System.exit(0);
    }
}
