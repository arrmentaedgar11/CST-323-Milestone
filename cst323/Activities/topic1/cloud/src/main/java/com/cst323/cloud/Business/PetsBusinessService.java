package com.cst323.cloud.Business;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.cst323.cloud.Data.PetsDataService;
import com.cst323.cloud.Data.Entity.PetsEntity;
import com.cst323.cloud.Models.PetModel;

public class PetsBusinessService implements PetsBusinessInterface{

    @Autowired
    private PetsDataService service;
    private DataSource dataSource;

    @Override   
    public void test(){
        System.out.println("Hello from petsbusinessservice");
        System.out.println("DataSource? " + dataSource);
    }

    @Override
    public void init(){
        System.out.println("init");
    }

    @Override
    public void destroy(){
        System.out.println("destroy");
    }

    @Override
    public List<PetModel> getPets(){
        System.out.println("PetsBusinessService.getPetPets()");

        List<PetsEntity> petsEntity = service.findAll();
        System.out.println("Current pets list length = " + petsEntity.size());
        //Iterate to move from PetsEntity to PetModel
        List<PetModel> petModels = new ArrayList<PetModel>();
        for(PetsEntity entity: petsEntity){
            petModels.add(new PetModel(entity.getId(), entity.getPetName(), entity.getPetDesc(), entity.getPetGender(), entity.getPetAge(), entity.getPetSpecies(), entity.getPetStatus(), entity.getPetPic()));
            System.out.println("found another pet: " + entity.getPetName());
        }

        return petModels;
    }

    @Override
    public PetModel getPetById(Long id) {
        System.out.println("PetsBusinessService.getPetById");
        PetModel pet = service.findById(id);
        return pet;
    }

    @Override
    public void updatePet(PetModel petModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePet'");
    }

    @Override
    public void deletePet(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePet'");
    }
    
}
