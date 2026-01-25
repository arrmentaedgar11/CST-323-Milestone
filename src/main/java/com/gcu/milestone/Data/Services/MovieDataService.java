package com.gcu.milestone.Data.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.milestone.Data.Entities.MovieEntity;
import com.gcu.milestone.Data.Repositories.movieRepository;
import com.gcu.milestone.Models.movieModel;

/**
 * Data access service for  the Movie records.
 */
@Service
public class MovieDataService implements DataAccessInterface<movieModel> {

    @Autowired
    private movieRepository movieRepository;

    /**
     * Returns every movie as a list of movieModel objects.
     */
    @Override
    public List<movieModel> findAll() {
        List<movieModel> movies = new ArrayList<>();

        Iterable<MovieEntity> entities = movieRepository.findAll();
        for (MovieEntity entity : entities) {
            movies.add(convertFromEntity(entity));
        }

        return movies;
    }

    /**
     * Look up a single movie by id.
     */
    @Override
    public movieModel findById(Long id) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        return entity.map(this::convertFromEntity).orElse(null);
    }

    @Override
    public movieModel findByName(String name) {
        return null; // not implemented
    }

    /**
     * Creates a new movie row.
     */
    public boolean create(MovieEntity movie) {
        movieRepository.save(movie);
        return true;
    }

    /**
     * Updates an existing movie row without losing data.
     */
    public boolean update(MovieEntity movie) {
        Optional<MovieEntity> existingOpt = movieRepository.findById(movie.getId());
        if (existingOpt.isPresent()) {
            MovieEntity entityToSave = existingOpt.get();

            // Only updates the fields that changes during checkout/return
            entityToSave.setStatus(movie.getStatus());
            entityToSave.setUserId(movie.getUserId());

            // Image, title, genre, price remain unchanged
            movieRepository.save(entityToSave);
            return true;
        }
        return false;
    }

    /**
     * Delete a movie by id.
     */
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    /**
     *changes from model to entity.
     */
    public MovieEntity convertFromModel(movieModel model) {
        MovieEntity entity = new MovieEntity();
        entity.setId((long) model.getId());
        entity.setGenre(model.getGenre());
        entity.setPrice(model.getPrice());
        entity.setStatus(model.getStatus());
        entity.setTitle(model.getTitle());
        entity.setUserId(model.getUserId());
        entity.setImage(model.getImage()); // include image
        return entity;
    }

    /**
     * changes from entity to model.
     */
    public movieModel convertFromEntity(MovieEntity entity) {
        movieModel model = new movieModel();
        model.setId(entity.getId().intValue());
        model.setGenre(entity.getGenre());
        model.setPrice(entity.getPrice());
        model.setStatus(entity.getStatus());
        model.setTitle(entity.getTitle());
        model.setUserId(entity.getUserId());
        model.setImage(entity.getImage()); // include image
        return model;
    }
}
