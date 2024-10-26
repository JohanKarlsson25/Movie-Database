package johkar2.kth.se.moviedatabase.view;

import johkar2.kth.se.moviedatabase.model.Model;

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
        System.out.println("movie");
    }
}
