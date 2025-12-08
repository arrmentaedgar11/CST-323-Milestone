package com.cst323.cloud.Models;

import org.springframework.data.annotation.Id;

public class PetModel {
    
    @Id
    private Long id;

    public String petName; 
    public String petDesc;
    public String petGender;
    public String petAge;
    public String petSpecies;
    public String petStatus;
    public String petPic;

    public Long getId(){return id;}
    public void setId(Long Id) {id = Id;}
    
    public String getPetName(){
        return petName;
    }
    public void setPetName(String name){
        petName = name;
    }

    public String getPetDesc(){ return petDesc;}
    public void setPetDesc(String desc) {petDesc = desc;}

    public String getPetGender(){ return petGender;}
    public void setPetGender(String gender){ petGender = gender;}
    
    public String getPetAge(){ return petAge;}
    public void setPetAge(String age){petAge = age;}

    public String getPetSpecies(){return petSpecies;}
    public void setPetSpecies(String species){ petSpecies = species;}

    public String getPetStatus(){return petStatus;}
    public void setPetStatus(String status){petStatus = status;}

    public String getPetPic(){return petPic;}
    public void setPetPic(String pic){petPic = pic;}

    public PetModel(Long id,String name, String desc, String gender, String age, String species,
        String status, String pic){
            this.id = id;
            this.petName = name;
            this.petDesc = desc;
            this.petGender = gender;
            this.petAge = age;
            this.petSpecies = species;
            this.petStatus = status;
            this.petPic = pic;
        }
    public PetModel() {
        //TODO Auto-generated constructor stub
    }
}
