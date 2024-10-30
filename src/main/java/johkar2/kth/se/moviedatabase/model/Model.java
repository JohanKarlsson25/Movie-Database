package johkar2.kth.se.moviedatabase.model;

import java.util.ArrayList;

public class Model {

    private final ArrayList<Media> allEntries;

    public Model(){
        allEntries = new ArrayList<>();
    }

    public void readFromFile(){

    }

    public void writeToFile(){

    }

    //TODO maybe should be a "MEDIAHANDLER" and have facade functions here and private there
    public void addMovie(String title){
        if (!isTitleUnique(title)) throw new IllegalArgumentException("Movie Title already exists");
    }

    public void addTv_Series(){

    }

    public boolean isTitleUnique(String title){
        for (Media m : allEntries){
            if (m.getTitle().equals(title)) return false;
        }
        return true;
    }
}
