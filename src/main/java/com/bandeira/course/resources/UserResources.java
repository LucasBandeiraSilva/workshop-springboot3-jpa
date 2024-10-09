package com.bandeira.course.resources;

import com.bandeira.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @GetMapping
    public ResponseEntity<User>findAll(){
        User user = new User(1L,"Lucas","lucas@gmail.com","999999-99","a1b2c5b7");
        return ResponseEntity.ok().body(user);
    }
}
