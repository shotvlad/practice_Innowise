package org.com.repository;

import org.com.entity.Car;
import org.com.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByModelContaining(String model);
    List<Car> findByPriceBetween(double begin, double end);
    List<Car> findByNumberBetween(Long begin, Long end);
    List<Car> findByBrand(Brand brand);
}
