package com.gcu.milestone.Data.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.gcu.milestone.Data.Entities.MovieEntity;

public interface movieRepository extends CrudRepository<MovieEntity, Long>{
    
}
