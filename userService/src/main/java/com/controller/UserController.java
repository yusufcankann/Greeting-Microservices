package com.controller;

import com.model.UserEntity;
import com.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController{

        @Autowired
        private final UserService userService;


        @PostMapping(value = "add")
        public ResponseEntity<String> addUser(UserEntity userValue) {
                userService.addUser(userValue);
                return ResponseEntity.ok().body("OK");
        }


        @GetMapping(value = "getUser", params = "id")
        public ResponseEntity<UserEntity> getUserById(@RequestParam(required = true) Long id){
                return ResponseEntity.ok().body(userService.getUserById(id));
        }

        @GetMapping(value = "getUser", params = {"firstName","lastName"})
        public ResponseEntity<UserEntity> getUserByFistNameAndLastName(@RequestParam(required = true) String firstName,
                                                                         @RequestParam(required = true) String lastName){
                return ResponseEntity.ok().body(userService.getUserByFistNameAndLastName(firstName,lastName));
        }

        @GetMapping(value = "getUserFN", params = {"firstName"})
        public ResponseEntity<List<UserEntity>> getUserByFistName(@RequestParam(required = true) String firstName){
                return ResponseEntity.ok().body(userService.getUsersByFirstName(firstName));
        }

        @GetMapping(value = "getUserLN", params = {"lastName"})
        public ResponseEntity<List<UserEntity>> getUserByLastName(@RequestParam(required = true) String lastName){
                return ResponseEntity.ok().body(userService.getUsersByLastName(lastName));
        }

        @PutMapping(value = "update", params = {"firstName","lastName","message"})
        public ResponseEntity<String> updateMessage(@RequestParam(required = true) String firstName,
                                                    @RequestParam(required = true) String lastName,
                                                    @RequestParam(required = true) String message){
                userService.updateMessageByFirstNameAndLastName(firstName,lastName,message);
                return ResponseEntity.ok().body("OK");
        }


}
