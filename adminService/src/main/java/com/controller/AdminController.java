package com.controller;

import com.model.AdminEntity;
import com.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    @Autowired
    private final AdminService adminService;

    @PostMapping(value = "add")
    public ResponseEntity<String> addAdmin(AdminEntity adminValue) {
        adminService.addAdmin(adminValue);
        return ResponseEntity.ok().body("OK");
    }


    @GetMapping(value = "getAdmin", params = "id")
    public ResponseEntity<AdminEntity> getAdminById(@RequestParam(required = true) Long id){
        return ResponseEntity.ok().body(adminService.getAdminById(id));
    }

    @GetMapping(value = "getAdmin", params = {"firstName","lastName"})
    public ResponseEntity<AdminEntity> getAdminByFistNameAndLastName(@RequestParam(required = true) String firstName,
                                                                     @RequestParam(required = true) String lastName){
        return ResponseEntity.ok().body(adminService.getAdminByFistNameAndLastName(firstName,lastName));
    }

    @GetMapping(value = "getAdminFN", params = {"firstName"})
    public ResponseEntity<List<AdminEntity>> getAdminByFistName(@RequestParam(required = true) String firstName){
        return ResponseEntity.ok().body(adminService.getAdminsByFirstName(firstName));
    }

    @GetMapping(value = "getAdminLN", params = {"lastName"})
    public ResponseEntity<List<AdminEntity>> getAdminByLastName(@RequestParam(required = true) String lastName){
        return ResponseEntity.ok().body(adminService.getAdminsByLastName(lastName));
    }

    @PutMapping(value = "update", params = {"firstName","lastName","message"})
    public ResponseEntity<String> updateMessage(@RequestParam(required = true) String firstName,
                                                           @RequestParam(required = true) String lastName,
                                                           @RequestParam(required = true) String message){
        adminService.updateMessageByFirstNameAndLastName(firstName,lastName,message);
        return ResponseEntity.ok().body("OK");
    }

}