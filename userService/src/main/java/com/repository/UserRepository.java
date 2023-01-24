package com.repository;

import com.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByFirstNameAndLastName(String name, String surname);
    List<UserEntity> findByFirstName(String name);
    List<UserEntity> findByLastName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE UserEntity SET message = :message WHERE firstName = :firstName AND lastName = :lastName")
    void updateByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("message") String message);

}
