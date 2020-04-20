package com.assignment.counterapi.repository;

import com.assignment.counterapi.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
