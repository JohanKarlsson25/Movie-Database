package johkar2.kth.se.moviedatabase.model;

import johkar2.kth.se.moviedatabase.view.ApplicationState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private final ArrayList<Media> allEntries;

    public Model(){
        allEntries = new ArrayList<>();
        allEntries.add(new Movie("Django Unchained", " ", 8.5,2012,2,45));
        allEntries.add(new Movie("The Dark Knight", " ", 8.9,2008,2,12));
        allEntries.add(new Movie("Starwas", " ", 8.5,2012,2,45));
        allEntries.add(new Movie("gerwgwgr", " ", 8.5,206,2,45));
    }

    public void readFromFile() throws Exception {
        allEntries.addAll(FileIO.readMediaFromFile());
    }

    public void writeToFile() throws Exception {
        FileIO.writeMediaToFile(allEntries);
    }

    //TODO maybe should be a "MEDIAHANDLER" and have facade functions here and private there???
    public void addMovie(String title){
        if (!isTitleUnique(title)) throw new IllegalArgumentException("Movie Title already exists");
    }

    public void addTv_Series(){

    }

    public List<String> getTitles(){
        ArrayList<String> copy = new ArrayList<>();
        for (Media m : allEntries){
            copy.add(m.getTitle());
        }
        return copy;
    }

    public List<Media> getAllEntries(){
        return new ArrayList<>(allEntries);
    }

    public List<Media> getAllMovies(){
        ArrayList<Media> copy = new ArrayList<>();
        for (Media m : allEntries){
            if (m instanceof Movie) copy.add(m);
        }
        return copy;
    }

    public List<Media> getAllTv_Series(){
        ArrayList<Media> copy = new ArrayList<>();
        for (Media m : allEntries){
            if (m instanceof Tv_Series) copy.add(m);
        }
        return copy;
    }

    public boolean isTitleUnique(String title){
        for (Media m : allEntries){
            if (m.getTitle().equals(title)) return false;
        }
        return true;
    }
}
