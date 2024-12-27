package johkar2.kth.se.moviedatabase.model;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private final ArrayList<Media> allMedia;

    public Model() throws Exception {
        allMedia = new ArrayList<>();
        readFromFile();
        //allMedia.add(new Movie("Silicon Valley","gh",8.8,1,2,3));
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

    public boolean isTitleUnique(String title){
        for (Media m : allMedia){
            if (m.getTitle().equals(title)) return false;
        }
        return true;
    }
}
