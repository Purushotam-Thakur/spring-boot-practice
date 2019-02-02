package com.in28minutes.rest.webservices.restfullwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

@RestController
public class userResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveAllUsers(@PathVariable int id){
        User user =  service.findOne(id);

        if(user==null)
            throw new UserNotFoundException("id-"+id);

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
