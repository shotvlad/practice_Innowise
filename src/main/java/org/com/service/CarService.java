package org.com.service;


import org.com.entity.Car;
import org.com.entity.Brand;
import java.util.List;

public interface CarService extends Service<Car> {
    List<Car> readByModel(String model);
    List<Car> readByPrice(double begin, double end);
    List<Car> readByNumber(Long begin, Long end);
    List<Car> readByBrand(Brand brand);
}
