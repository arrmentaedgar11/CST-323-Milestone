package com.gcu.milestone.Data.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.milestone.Data.Entities.MovieEntity;

public interface movieRepository extends CrudRepository<MovieEntity, Long>
{
//find movies by user id
	List<MovieEntity> findByCurrentUserId(Long currentUserId);
}
