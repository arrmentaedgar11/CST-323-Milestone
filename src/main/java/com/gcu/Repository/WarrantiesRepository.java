package com.gcu.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.models.WarrantyModel;

@Repository
public interface WarrantiesRepository extends CrudRepository<WarrantyModel, Long>{
	
	List<WarrantyModel> findAll();

}
