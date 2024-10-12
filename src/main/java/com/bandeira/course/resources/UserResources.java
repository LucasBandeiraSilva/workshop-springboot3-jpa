package com.bandeira.course.resources;

import com.bandeira.course.entities.User;
import com.bandeira.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity <List <User>> findAll() {
        List <User> userList = userService.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <User> findById( @PathVariable Long id ) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity <User> insert( @RequestBody User user ) {
        user = userService.insertUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
