package com.user.controller;

import com.user.model.UserEntity;
import com.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController{

        @Autowired
        private final UserService userService;

        @PreAuthorize("hasAnyAuthority('ROLE_SUPER_USER')")
        @PostMapping(value = "add")
        public ResponseEntity<String> addUser(UserEntity userValue) {
                userService.addUser(userValue);
                return ResponseEntity.ok().body("OK");
        }

        @PreAuthorize("hasAnyAuthority('ROLE_SUPER_USER','ROLE_USER')")
        @GetMapping(value = "getUser", params = "id")
        public ResponseEntity<UserEntity> getUserById(@RequestParam(required = true) Long id){
                return ResponseEntity.ok().body(userService.getUserById(id));
        }

        @PreAuthorize("hasAnyAuthority('ROLE_SUPER_USER','ROLE_USER')")
        @GetMapping(value = "getUser", params = {"firstName","lastName"})
        public ResponseEntity<UserEntity> getUserByFistNameAndLastName(@RequestParam(required = true) String firstName,
                                                                         @RequestParam(required = true) String lastName){
                return ResponseEntity.ok().body(userService.getUserByFistNameAndLastName(firstName,lastName));
        }

        @PreAuthorize("hasAnyAuthority('ROLE_SUPER_USER','ROLE_USER')")
        @GetMapping(value = "getUserFN", params = {"firstName"})
        public ResponseEntity<List<UserEntity>> getUserByFistName(@RequestParam(required = true) String firstName){
                return ResponseEntity.ok().body(userService.getUsersByFirstName(firstName));
        }

        @PreAuthorize("hasAnyAuthority('ROLE_SUPER_USER','ROLE_USER')")
        @GetMapping(value = "getUserLN", params = {"lastName"})
        public ResponseEntity<List<UserEntity>> getUserByLastName(@RequestParam(required = true) String lastName){
                return ResponseEntity.ok().body(userService.getUsersByLastName(lastName));
        }

        @PreAuthorize("hasAnyAuthority('ROLE_SUPER_USER','ROLE_USER')")
        @PutMapping(value = "update", params = {"firstName","lastName","message"})
        public ResponseEntity<String> updateMessage(@RequestParam(required = true) String firstName,
                                                    @RequestParam(required = true) String lastName,
                                                    @RequestParam(required = true) String message){
                userService.updateMessageByFirstNameAndLastName(firstName,lastName,message);
                return ResponseEntity.ok().body("OK");
        }

        @PreAuthorize("hasAnyAuthority('ROLE_SUPER_USER')")
        @DeleteMapping(value = "deleteUser", params = "id")
        public ResponseEntity<String> deleteUserById(@RequestParam(required = true) Long id){
                userService.deleteUser(id);
                return ResponseEntity.ok().body("OK");
        }
}
