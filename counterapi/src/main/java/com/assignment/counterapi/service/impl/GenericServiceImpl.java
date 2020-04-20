package com.assignment.counterapi.service.impl;

import com.assignment.counterapi.domain.User;
import com.assignment.counterapi.domain.Paragraph;
import com.assignment.counterapi.repository.UserRepository;
import com.assignment.counterapi.repository.ParagraphRepository;
import com.assignment.counterapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;

@Service
public class GenericServiceImpl implements GenericService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

}
