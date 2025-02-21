package johkar2.kth.se.moviedatabase.model;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private final ArrayList<Media> allMedia;

    public Model() throws Exception {
        allMedia = new ArrayList<>();
        readFromFile();
        /*allMedia.add(new Movie("Django Unchained","gh",8.8,1,2,3));
        allMedia.add(new Tv_Series("Silicon Valley","gh",8.8,1,2,3));
        allMedia.add(new Movie("Dune 2","gh",8.8,1,2,3));
        allMedia.add(new Movie("The Dark Knight","gh",8.8,1,2,3));
        allMedia.add(new Tv_Series("Arcane","gh",8.8,1,2,3));
        allMedia.get(0).setWatchedStatus(true);
        allMedia.get(0).setHallOfFameStatus(true);
        allMedia.get(0).setWatchListStatus(false);
        allMedia.get(1).setWatchedStatus(true);
        allMedia.get(1).setHallOfFameStatus(false);
        allMedia.get(1).setWatchListStatus(false);
        allMedia.get(2).setWatchedStatus(true);
        allMedia.get(2).setHallOfFameStatus(false);
        allMedia.get(2).setWatchListStatus(false);
        allMedia.get(3).setWatchedStatus(true);
        allMedia.get(3).setHallOfFameStatus(true);
        allMedia.get(3).setWatchListStatus(false);
        allMedia.get(4).setWatchedStatus(true);
        allMedia.get(4).setHallOfFameStatus(true);
        allMedia.get(4).setWatchListStatus(false);
        allMedia.add(new Movie("Dune","gh",8.8,1,2,3));
        allMedia.add(new Tv_Series("Stranger Things","gh",8.8,1,2,3));
        allMedia.add(new Tv_Series("The Last Dance","gh",8.8,1,2,3));
        allMedia.add(new Tv_Series("The Office","gh",8.8,1,2,3));
        allMedia.add(new Tv_Series("Game Of Thrones","gh",8.8,1,2,3));
        allMedia.get(5).setWatchedStatus(true);
        allMedia.get(5).setHallOfFameStatus(false);
        allMedia.get(5).setWatchListStatus(false);
        allMedia.get(6).setWatchedStatus(true);
        allMedia.get(6).setHallOfFameStatus(true);
        allMedia.get(6).setWatchListStatus(false);
        allMedia.get(7).setWatchedStatus(true);
        allMedia.get(7).setHallOfFameStatus(false);
        allMedia.get(7).setWatchListStatus(false);
        allMedia.get(8).setWatchedStatus(true);
        allMedia.get(8).setHallOfFameStatus(true);
        allMedia.get(8).setWatchListStatus(false);
        allMedia.get(9).setWatchedStatus(true);
        allMedia.get(9).setHallOfFameStatus(true);
        allMedia.get(9).setWatchListStatus(false);*/
        //allMedia.add(new Movie("Gladiator","sg",9.2,2000,2,35));
    }

    public void readFromFile() throws Exception {
        allMedia.addAll(FileIO.readMediaFromFile());
    }

    public void writeToFile() throws Exception {
        FileIO.writeMediaToFile(allMedia);
    }
    //DESIGN!!!! What am i really doing. Database and choose? or manipulate the database
    public void addMovie(String title, String description, double rating, int year, int hour, int minutes){
        if (!isTitleUnique(title)) throw new IllegalArgumentException("Movie Title already exists");
        allMedia.add(new Movie(title,description,rating,year,hour,minutes));
    }

    public void addTv_Series(){

    }

    public List<String> getTitles(){
        ArrayList<String> copy = new ArrayList<>();
        for (Media m : allMedia){
            copy.add(m.getTitle());
        }
        return copy;
    }

    public List<Media> getAllMedia(){
        return new ArrayList<>(allMedia);
    }

    public List<Media> getAllMovies(){
        ArrayList<Media> copy = new ArrayList<>();
        for (Media m : allMedia){
            if (m instanceof Movie) copy.add(m);
        }
        return copy;
    }

    public List<Media> getAllTv_Series(){
        ArrayList<Media> copy = new ArrayList<>();
        for (Media m : allMedia){
            if (m instanceof Tv_Series) copy.add(m);
        }
        return copy;
    }

    public Media getMostRecentWatch(){
        for (int i = allMedia.size()-1; i >= 0; i--){
            if (allMedia.get(i).getWatchedStatus()) return allMedia.get(i);
        }
        throw new RuntimeException("No movie has been watched");
    }

    public boolean isTitleUnique(String title){
        for (Media m : allMedia){
            if (m.getTitle().equals(title)) return false;
        }
        return true;
    }
}
