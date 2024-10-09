package com.bandeira.course.services;

import com.bandeira.course.entities.User;
import com.bandeira.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List <User> findAll() {
        return userRepository.findAll();
    }

    public User findById( Long id ) {

        Optional <User> optional = userRepository.findById(id);
         return optional.get();

    }

}
