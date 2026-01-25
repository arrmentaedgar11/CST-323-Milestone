package com.gcu.milestone.Data.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.milestone.Data.Entities.UserEntity;
import com.gcu.milestone.Data.Repositories.userRepository;
import com.gcu.milestone.Models.UserModel;

/**
 * Data access service for working with User records.
 */
@Service
public class UserDataService implements DataAccessInterface<UserModel> {

    @Autowired
    private userRepository userRepository;

    /**
     * Returns every user as a list of UserModel objects.
     */
    @Override
    public List<UserModel> findAll() {
        List<UserModel> users = new ArrayList<>();

        Iterable<UserEntity> entities = userRepository.findAll();
        for (UserEntity entity : entities) {
            users.add(convertFromEntity(entity));
        }

        return users;
    }

    /**
     * Find a single user by id.
     */
    @Override
    public UserModel findById(Long id) {
        Optional<UserEntity> entity = userRepository.findById(id);
        return entity.map(this::convertFromEntity).orElse(null);
    }

    
    @Override
    public UserModel findByName(String name) {
        return null;
    }

    /**
     * Creates a new user row.
     */
    public boolean create(UserEntity user) {
        userRepository.save(user);
        return true;
    }

    /**
     * Updates an existing user row.
     */
    public boolean update(UserEntity user) {
        userRepository.save(user);
        return true;
    }

    /**
     * Deletes a user by id.
     */
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

   
    public UserModel convertFromEntity(UserEntity entity) {
        int id = (entity.getId() == null) ? 0 : entity.getId().intValue();
        return new UserModel(
                id,
                entity.getUsername(),
                entity.getPassword(),
                entity.getName());
    }

    
    public UserEntity convertFromModel(UserModel model) {
        Long id = (long) model.getId();
        return new UserEntity(
                id,
                model.getUsername(),
                model.getPassword(),
                model.getName());
    }

    /**
     * Used for login authentication.
     */
    public UserModel findByUsernameAndPassword(String username, String password) {
        UserEntity entity = userRepository.findByUsernameAndPassword(username, password);
        if (entity == null) {
            return null;
        }
        return convertFromEntity(entity);
    }
}

