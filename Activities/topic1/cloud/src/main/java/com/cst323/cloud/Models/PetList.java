package com.cst323.cloud.Models;

import java.util.ArrayList;
import java.util.List;

//@XmlRootElement(name="pets")
public class PetList {
    private List<PetModel> pets = new ArrayList<PetModel>();

   //XmlElement(name="pet")
    public List<PetModel> getPets(){
        return this.pets;
    }

    public void setPets(List<PetModel> pets){
        this.pets = pets;
    }
}
