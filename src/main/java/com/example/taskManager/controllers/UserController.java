package com.example.taskManager.controllers;

import com.example.taskManager.Utils.Utils;
import com.example.taskManager.models.UserModel;
import com.example.taskManager.repositorys.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUserName(userModel.getUserName());

        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username indisponivel!");
        }

        Utils.doPasswordHash(userModel);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PutMapping("/{userName}-{id}/edit")
    public ResponseEntity update(@RequestBody UserModel userModel, HttpServletRequest httpServletRequest, @PathVariable UUID id) {
        var user = this.userRepository.findById(id);
        var idUser = httpServletRequest.getAttribute("id");

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario não contrado");
        }

    }
}
