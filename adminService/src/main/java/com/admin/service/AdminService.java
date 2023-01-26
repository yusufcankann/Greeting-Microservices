package com.admin.service;

import com.admin.model.AdminEntity;
import com.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final AdminRepository adminRepository;

    public void addAdmin(AdminEntity adminEntity){
        adminRepository.save(adminEntity);
    }

    public AdminEntity getAdminById(Long id){
        Optional<AdminEntity> admin = adminRepository.findById(id);
        if(admin.isPresent()){
            return admin.get();
        }
        return null;
    }

    public AdminEntity getAdminByFistNameAndLastName(String firstName,String lastName){
        Optional<AdminEntity> admin = adminRepository.findByFirstNameAndLastName(firstName,lastName);
        if(admin.isPresent()){
            return admin.get();
        }
        return null;
    }

    public List<AdminEntity> getAdminsByFirstName(String firstName){
        return adminRepository.findByFirstName(firstName);
    }

    public List<AdminEntity> getAdminsByLastName(String lastName){
        return adminRepository.findByLastName(lastName);
    }

    public void updateMessageByFirstNameAndLastName(String firstName,String lastName,String message){
        adminRepository.updateByFirstNameAndLastName(firstName,lastName,message);
    }

    public void deleteAdmin(Long id){
        adminRepository.deleteById(id);
    }

}

