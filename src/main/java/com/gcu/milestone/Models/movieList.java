package com.gcu.milestone.Models;

import java.util.ArrayList;
import java.util.List;

public class movieList {
        private List<movieModel> movies = new ArrayList<movieModel>();

   // Getter and Setter
    public List<movieModel> getMovies(){
        return this.movies;
    }

    public void setMovies(List<movieModel> movies){
        this.movies = movies;
    }
}
