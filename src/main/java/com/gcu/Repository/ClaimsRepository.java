package com.gcu.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.models.ClaimsModel;

@Repository
public interface ClaimsRepository extends CrudRepository<ClaimsModel, Long>{
	
	List<ClaimsModel> findAll();

}
