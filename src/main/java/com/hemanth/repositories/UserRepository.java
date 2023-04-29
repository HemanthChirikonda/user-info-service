package com.hemanth.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hemanth.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{


}
