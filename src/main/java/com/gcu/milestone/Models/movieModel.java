package com.gcu.milestone.Models;

import org.springframework.data.annotation.Id;

public class movieModel {

    @Id
    private int id;

    private String title;    // varchar
    private String genre;    // varchar
    private Float price;     // decimal
    private String status;   // varchar
    private int userId;      // int, 
    private String image;    // URL or path to the image

    // contsructors
    public movieModel() { }

    // Full constructor
    public movieModel(int id, String title, String genre, Float price, String status, int userId, String image) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.status = status;
        this.userId = userId;
        this.image = image;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
