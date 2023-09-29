package com.learning.attemptapi.controller;

import com.learning.attemptapi.controller.dto.NewUserDto;
import com.learning.attemptapi.controller.dto.UpdateUserDto;
import com.learning.attemptapi.controller.dto.UserDto;
import com.learning.attemptapi.model.User;
import com.learning.attemptapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    ResponseEntity<UserDto> create(@RequestBody NewUserDto newUserDto) {

        User mappedUser = mapper.map(newUserDto, User.class);
        User newUser = userService.addUser(
                mappedUser);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.map(newUser, UserDto.class));
    }

    @PutMapping
    ResponseEntity<UserDto> update(@RequestBody UpdateUserDto updateUserDto) {
        User mappedUser = mapper.map(updateUserDto, User.class);
        return ResponseEntity.ok()
                .body(mapper.map(userService.updateUser(mappedUser), UserDto.class));
    }

    @GetMapping("/all")
    ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok()
                .body(userService.getAllUsers().stream().map(user -> mapper.map(user, UserDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/search/{email}")
    ResponseEntity<UserDto> getByEmail(@PathVariable(name = "email") String email) {
        return ResponseEntity.ok()
                .body(mapper.map(userService.getUserbyEmail(email), UserDto.class));
    }
}
