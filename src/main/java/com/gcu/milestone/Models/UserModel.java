package com.gcu.milestone.Models;
import org.springframework.data.annotation.Id;

public class UserModel {
    
    @Id
    private int id; 

    private String username; //not null 
    private String password; //not null 
    private String name;  //can be null

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public String getUsername(){return this.username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password = password;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public UserModel(){}

    public UserModel(int id, String username, String password, String name){
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }


}
