package com.example.skillwillproject28.Repositories;

//import com.example.skillwillproject28.Models.UserCarModel;
import com.example.skillwillproject28.Models.UserCarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserCarRepository extends JpaRepository<UserCarModel, UUID> {

    @Query("select umm from UserCarModel umm where umm.userModel.id = :userid")
    List<UserCarModel> findByUserId(@Param("userid") UUID userid);

}
