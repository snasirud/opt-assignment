package com.assignment.counterapi.service;

import com.assignment.counterapi.domain.User;
import com.assignment.counterapi.domain.Paragraph;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();
}
