package com.admin.controller;

import com.admin.model.AdminEntity;
import com.admin.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    @Autowired
    private final AdminService adminService;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "add")
    public ResponseEntity<String> addAdmin(AdminEntity adminValue) {
        adminService.addAdmin(adminValue);
        return ResponseEntity.ok().body("OK");
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_ADMIN')")
    @GetMapping(value = "getAdmin", params = "id")
    public ResponseEntity<AdminEntity> getAdminById(@RequestParam(required = true) Long id){
        return ResponseEntity.ok().body(adminService.getAdminById(id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_ADMIN')")
    @GetMapping(value = "getAdmin", params = {"firstName","lastName"})
    public ResponseEntity<AdminEntity> getAdminByFistNameAndLastName(@RequestParam(required = true) String firstName,
                                                                     @RequestParam(required = true) String lastName){
        return ResponseEntity.ok().body(adminService.getAdminByFistNameAndLastName(firstName,lastName));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_ADMIN')")
    @GetMapping(value = "getAdminFN", params = {"firstName"})
    public ResponseEntity<List<AdminEntity>> getAdminByFistName(@RequestParam(required = true) String firstName){
        return ResponseEntity.ok().body(adminService.getAdminsByFirstName(firstName));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_ADMIN')")
    @GetMapping(value = "getAdminLN", params = {"lastName"})
    public ResponseEntity<List<AdminEntity>> getAdminByLastName(@RequestParam(required = true) String lastName){
        return ResponseEntity.ok().body(adminService.getAdminsByLastName(lastName));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @PutMapping(value = "update", params = {"firstName","lastName","message"})
    public ResponseEntity<String> updateMessage(@RequestParam(required = true) String firstName,
                                                           @RequestParam(required = true) String lastName,
                                                           @RequestParam(required = true) String message){
        adminService.updateMessageByFirstNameAndLastName(firstName,lastName,message);
        return ResponseEntity.ok().body("OK");
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @DeleteMapping(value = "deleteAdmin", params = "id")
    public ResponseEntity<String> deleteAdminById(@RequestParam(required = true) Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().body("OK");
    }

}