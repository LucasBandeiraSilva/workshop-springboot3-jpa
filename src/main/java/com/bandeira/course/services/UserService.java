package com.bandeira.course.services;

import com.bandeira.course.entities.User;
import com.bandeira.course.repositories.UserRepository;
import com.bandeira.course.services.exceptions.DatabaseException;
import com.bandeira.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return optional.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public User insertUser( User user ) {
        return userRepository.save(user);
    }

    public void deleteUserById( Long id ) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            userRepository.delete(user);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User updateUser( Long id, User user ) {
        try {
            User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
            updateData(entity, user);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData( User entity, User user ) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}
