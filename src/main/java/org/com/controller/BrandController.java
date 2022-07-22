package org.com.controller;

import org.com.entity.Brand;
import org.com.service.BrandService;
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
@RequestMapping("api/brand")
public class BrandController extends AbstractController<Brand> {
    @Autowired
    private BrandService service;

    @Override
    public Service<Brand> getService() {
        return service;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Brand>> getByStatus(@PathVariable String status) {
        List<Brand> brands = service.readByStatus(status);
        if (brands.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(brands, headers, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Brand>> getByName(@PathVariable String name) {
        List<Brand> brands = service.readByName(name);
        if (brands.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(brands, headers, HttpStatus.OK);
    }
}
