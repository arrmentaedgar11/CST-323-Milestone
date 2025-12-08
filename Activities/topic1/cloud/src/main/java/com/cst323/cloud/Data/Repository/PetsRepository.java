package com.cst323.cloud.Data.Repository;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.cst323.cloud.Data.Entity.PetsEntity;
import com.cst323.cloud.Models.PetModel;;

public interface PetsRepository extends CrudRepository<PetsEntity, Long> {
    
    @Override
    @Query(value = "SELECT * FROM CATFISH")
    public List<PetsEntity> findAll();

    //public void save(PetModel petModel);
}
