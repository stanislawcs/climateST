package com.example.climatest.code.repositories;

import com.example.climatest.code.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findCarByNumber(String number);
}
