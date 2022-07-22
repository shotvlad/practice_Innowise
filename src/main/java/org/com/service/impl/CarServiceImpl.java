package org.com.service.impl;

import org.com.entity.Car;
import org.com.entity.Brand;
import org.com.repository.CarRepository;
import org.com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository repository;

    @Override
    public Car read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Car> read() {
        return repository.findAll();
    }

    @Override
    public void save(Car entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Car entity) {
        Car car = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        car.setBrand(entity.getBrand());
        car.setModel(entity.getModel());
        car.setPrice(entity.getPrice());
        car.setNumber(entity.getNumber());
        repository.save(car);
    }

    @Override
    public List<Car> readByModel(String model) {
        return repository.findByModelContaining(model);
    }

    @Override
    public List<Car> readByBrand(Brand brand) {
        return repository.findByBrand(brand);
    }

    @Override
    public List<Car> readByPrice(double begin, double end) {
        return repository.findByPriceBetween(begin, end);
    }

    @Override
    public List<Car> readByNumber(Long begin, Long end) {
        return repository.findByNumberBetween(begin, end);
    }
}
