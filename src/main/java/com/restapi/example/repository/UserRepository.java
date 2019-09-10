package com.restapi.example.repository;

import com.restapi.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Retrieves User object by name
     *
     * @param username input parameter of User object
     * @return User object
     */
    User findByUsername(String username);
}
