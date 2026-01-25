package com.gcu.milestone.Models;
import org.springframework.data.annotation.Id;

public class CheckoutModel {
    
    @Id
    private int id; //uses the database id to identify checkouts

    private int movieId; //movie_id in database
    private int userId; //user_id in database


    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public int getMovieId(){return this.movieId;}
    public void setMovieId(int movieId){this.movieId = movieId;}

    public int getUserId(){return this.userId;}
    public void setUserId(int userId){this.userId = userId;}

    public CheckoutModel(){}

    public CheckoutModel(int id, int movieId, int userId){
        this.id = id;
        this.movieId = movieId;
        this.userId = userId;
    }

}
