package com.gcu.milestone.Data.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class UserEntity {

    @Id
    @Column(value="id")
    private Long id; //uses long to match crudRepository

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String name;


    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}

    public String getUsername(){return this.username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password = password;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}


    public UserEntity(){}

    public UserEntity(Long id, String username, String password, String name){
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public UserEntity( String username, String password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
    }
    
}
