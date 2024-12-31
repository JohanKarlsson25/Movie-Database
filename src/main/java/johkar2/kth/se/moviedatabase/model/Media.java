package johkar2.kth.se.moviedatabase.model;

import java.io.Serializable;

public abstract class Media implements Serializable {

    private String title, description;
    private double rating;
    private int year, hours, minutes;

    private boolean hallOfFameStatus, watchedStatus, watchListStatus;

    protected Media(String title, String description, double rating, int year, int hours, int minutes){
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public double getRating(){return rating;}
    public int getYear(){return year;}
    public int getHours(){return hours;}
    public int getMinutes(){return minutes;}
    public boolean getHallOfFameStatus(){return hallOfFameStatus;}
    public boolean getWatchedStatus(){return watchedStatus;}
    public boolean getWatchListStatus(){return watchListStatus;}

    public void setRating(){

    }

    public void setHallOfFameStatus(boolean status){
        this.hallOfFameStatus = status;
    }

    public void setWatchedStatus(boolean status){
        this.watchedStatus = status;
    }

    public void setWatchListStatus(boolean status){
        this.watchListStatus = status;
    }
}