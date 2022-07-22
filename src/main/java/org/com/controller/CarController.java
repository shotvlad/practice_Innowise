package org.com.controller;

import org.com.entity.Brand;
import org.com.entity.Car;
import org.com.service.CarService;
import org.com.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController extends AbstractController<Car> {
    @Autowired
    private CarService service;

    @Override
    public Service<Car> getService() {
        return service;
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Car>> getByModel(@PathVariable String model) {
        List<Car> cars = service.readByModel(model);
        if (cars.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cars, headers, HttpStatus.OK);
    }

    @GetMapping("/price/{begin}to{end}")
    public ResponseEntity<List<Car>> getByPrice(@PathVariable double begin, @PathVariable double end) {
        List<Car> cars = service.readByPrice(begin, end);
        if (cars.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cars, headers, HttpStatus.OK);
    }

    @GetMapping("/number/{begin}to{end}")
    public ResponseEntity<List<Car>> getByNumber(@PathVariable Long begin, @PathVariable Long end) {
        List<Car> cars = service.readByNumber(begin, end);
        if (cars.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cars, headers, HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Car>> getByBrand(@PathVariable Brand brand) {
        List<Car> cars = service.readByBrand(brand);
        if (cars.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cars, headers, HttpStatus.OK);
    }
}
