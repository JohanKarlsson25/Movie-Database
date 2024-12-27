package johkar2.kth.se.moviedatabase.model;

import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Media implements Serializable {

    private String title;
    private String description;
    private double rating;
    private int year, hours, minutes;
    private Image image; //?????
    //Should be functionality in view to check title and get corresponding image from that title

    protected Media(String title, String description, double rating, int year, int hours, int minutes){
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public double getRating(){
        return rating;
    }

    public int getYear(){
        return year;
    }

    public int getHours(){
        return hours;
    }

    public int getMinutes(){
        return minutes;
    }

    public void setTitle(String title){

    }


    public void setDescription(String description){

    }

    public void setRating(){

    }

    public void setImage(Image image){
        this.image = image;
    }
}