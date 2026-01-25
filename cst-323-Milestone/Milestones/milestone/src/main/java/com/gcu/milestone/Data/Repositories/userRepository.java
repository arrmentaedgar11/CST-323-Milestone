package com.gcu.milestone.Data.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.gcu.milestone.Data.Entities.UserEntity;

/**
 * Spring Data repository for the users table.
 * Spring will generate SQL for these methods based on their names.
 */
public interface userRepository extends CrudRepository<UserEntity, Long> {

    // Used by the login logic to find a user by username and password.
    UserEntity findByUsernameAndPassword(String username, String password);
}
