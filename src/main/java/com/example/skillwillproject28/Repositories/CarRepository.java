package com.example.skillwillproject28.Repositories;

import com.example.skillwillproject28.Models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CarRepository extends JpaRepository<CarModel, UUID> {

    @Query("select cm from CarModel cm where cm.id = :carid")
    Optional<CarModel> findById(@Param("carid") UUID carid);

}
