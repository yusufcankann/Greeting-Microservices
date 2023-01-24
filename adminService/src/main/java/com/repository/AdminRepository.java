package com.repository;

import com.model.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {

    Optional<AdminEntity> findById(Long id);
    Optional<AdminEntity> findByFirstNameAndLastName(String name, String surname);
    List<AdminEntity> findByFirstName(String name);
    List<AdminEntity> findByLastName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE AdminEntity SET message = :message WHERE firstName = :firstName AND lastName = :lastName")
    void updateByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName,@Param("message") String message);
}
