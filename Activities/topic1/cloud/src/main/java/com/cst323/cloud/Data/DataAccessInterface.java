package com.cst323.cloud.Data;

import java.util.List;

import com.cst323.cloud.Data.Entity.PetsEntity;
import com.cst323.cloud.Models.PetModel;


public interface DataAccessInterface <T> {

    public List<T> findAll();
    public T findById(Long id);
    public T findByName(String name);
    //public boolean create(T t);
    public boolean update(PetsEntity t);
    public void delete(Long t);
    public boolean create(PetsEntity t);
    
}
