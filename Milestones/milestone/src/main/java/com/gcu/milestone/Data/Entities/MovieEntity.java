package com.gcu.milestone.Data.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("movie")
public class MovieEntity {

    @Id
    @Column(value="id")
    private Long id; // Entity uses long to match CrudRepository

    @Column
    private String genre;

    @Column
    private float price;

    @Column
    private String status;

    @Column 
    private String title;

    @Column(value="current_user_id")
    private int userId;

    @Column
    private String image; // NEW: movie image filename

    // Getters and setters
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getGenre() { return this.genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Float getPrice() { return this.price; }
    public void setPrice(Float price) { this.price = price; }

    public String getStatus() { return this.status; }
    public void setStatus(String status) { this.status = status; }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public int getUserId() { return this.userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getImage() { return this.image; }
    public void setImage(String image) { this.image = image; }

    // Empty constructor
    public MovieEntity() {}

    // Full constructor with ID
    public MovieEntity(Long id, String genre, Float price, String status, String title, int userId, String image) 
    {
        this.id = id;
        this.genre = genre;
        this.price = price;
        this.status = status;
        this.title = title;
        this.userId = userId;
        this.image = image;
    }

    // Constructor without ID
    public MovieEntity(String genre, Float price, String status, String title, int userId, String image) 
    {
        this.genre = genre;
        this.price = price;
        this.status = status;
        this.title = title;
        this.userId = userId;
        this.image = image;
    }
}