package com.gcu.milestone.Data.Entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("checkout")
public class CheckoutEntity {

    @Id
    @Column(value="id")
    private Long id;

    @Column(value="movie_id")
    private int movieId;

    @Column(value="user_id")
    private int userId; 


    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}

    public int getMovieId(){return this.movieId;}
    public void setMovieId(int movieId){this.movieId = movieId;}

    public int getUserId(){return this.userId;}
    public void setUserId(int userId){this.userId = userId;}

    public CheckoutEntity(){}

    public CheckoutEntity(Long id, int movieId, int userId){
        this.id = id;
        this.movieId = movieId;
        this.userId = userId;
    }

    public CheckoutEntity(int movieId, int userId){
        this.movieId = movieId;
        this.userId = userId;
    }

}
