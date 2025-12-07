package com.cst323.cloud.Business;

import java.util.List;

import com.cst323.cloud.Models.PetModel;

public interface PetsBusinessInterface {
    
    public void test();
    public void init();
    public void destroy();
    public List<PetModel> getPets();
    public PetModel getPetById(Long id);
    public void updatePet(PetModel petModel);
    public void deletePet(Long id);
    
}
