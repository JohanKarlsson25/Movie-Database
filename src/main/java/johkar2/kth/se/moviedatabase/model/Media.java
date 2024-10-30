package johkar2.kth.se.moviedatabase.model;

public abstract class Media {

    private String title;
    private String description;
    private int rating;

    protected Media(String title, String description, int rating){
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public int getRating(){
        return rating;
    }

    public void setTitle(String title){

    }


    public void setDescription(String description){

    }

    public void setRating(){

    }
}