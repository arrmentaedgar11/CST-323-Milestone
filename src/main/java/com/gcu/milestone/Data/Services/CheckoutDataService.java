package com.gcu.milestone.Data.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.milestone.Data.Entities.CheckoutEntity;
import com.gcu.milestone.Data.Repositories.checkoutRepository;
import com.gcu.milestone.Models.CheckoutModel;

/**
 * Data access service for working with Checkout records.
 */
@Service
public class CheckoutDataService implements DataAccessInterface<CheckoutModel> {

    @Autowired
    private checkoutRepository checkoutRepository;

    /**
     * Returns every checkout as a list of CheckoutModel objects.
     */
    @Override
    public List<CheckoutModel> findAll() {
        List<CheckoutModel> checkouts = new ArrayList<>();

        Iterable<CheckoutEntity> entities = checkoutRepository.findAll();
        for (CheckoutEntity entity : entities) {
            checkouts.add(convertFromEntity(entity));
        }

        return checkouts;
    }

    /**
     * Find a single checkout row by id.
     */
    @Override
    public CheckoutModel findById(Long id) {
        Optional<CheckoutEntity> entity = checkoutRepository.findById(id);
        return entity.map(this::convertFromEntity).orElse(null);
    }

    /**
     * n/a
     */
    @Override
    public CheckoutModel findByName(String name) {
        return null;
    }

    /**
     * Creates a new checkout row.
     */
    public boolean create(CheckoutEntity checkout) {
        checkoutRepository.save(checkout);
        return true;
    }

    /**
     * Updatse an existing checkout row.
     */
    public boolean update(CheckoutEntity checkout) {
        checkoutRepository.save(checkout);
        return true;
    }

    /**
     * Deletes a checkout row by id.
     */
    public void delete(Long id) {
        checkoutRepository.deleteById(id);
    }

    /**
     * Converts from model to entity.
     */
    public CheckoutEntity convertFromModel(CheckoutModel model) {
        CheckoutEntity entity = new CheckoutEntity();
        entity.setId((long) model.getId());
        entity.setMovieId(model.getMovieId());
        entity.setUserId(model.getUserId());
        return entity;
    }

    /**
     * Converts from entity to model.
     */
    public CheckoutModel convertFromEntity(CheckoutEntity entity) {
        CheckoutModel model = new CheckoutModel();
        model.setId(entity.getId().intValue());
        model.setMovieId(entity.getMovieId());
        model.setUserId(entity.getUserId());
        return model;
    }
}
