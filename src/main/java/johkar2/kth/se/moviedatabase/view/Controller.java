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
        view.movieView();
    }

    void handleHover(Object source){
        if (source.equals(view.getMovieImageview())){
            System.out.println("Movie hover");
        } else if (source.equals(view.getTv_seriesImageview())){
            System.out.println("tvseries hover");
        }
    }

    void handleAdd(ApplicationState applicationState){
        switch (applicationState){
            case MOVIE_SUBMENU : model.addMovie(); break;
            case TV_SERIESMENU : model.addTv_Series(); break;
        }
    }
}
