package com.example.skillwillproject28.Repositories;

import com.example.skillwillproject28.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    @Query("select um from UserModel um where um.userName = :username")
    UserModel findUserByUsername(@Param("username") String username);

}
