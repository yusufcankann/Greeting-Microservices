package com.user.service;

import com.user.model.UserEntity;
import com.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void addUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public UserEntity getUserById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public UserEntity getUserByFistNameAndLastName(String firstName,String lastName){
        Optional<UserEntity> user = userRepository.findByFirstNameAndLastName(firstName,lastName);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public List<UserEntity> getUsersByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

    public List<UserEntity> getUsersByLastName(String lastName){
        return userRepository.findByLastName(lastName);
    }

    public void updateMessageByFirstNameAndLastName(String firstName,String lastName,String message){
        userRepository.updateByFirstNameAndLastName(firstName,lastName,message);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
