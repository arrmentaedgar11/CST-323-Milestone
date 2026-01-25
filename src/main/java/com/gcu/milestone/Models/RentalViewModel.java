package com.gcu.milestone.Models;


public class RentalViewModel {

    private int id;
    private String movieTitle;
    private String username;

    public RentalViewModel() {
    }

    public RentalViewModel(int id, String movieTitle, String username) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
